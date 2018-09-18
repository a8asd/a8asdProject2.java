package com.agil8.refactoring.z;

import java.util.ArrayList;
import java.util.List;

public class AccountOpenApp {
	private ResponseMsg response;

	public enum DbName {
		Atlas
	}

	public enum ErrorCode {
		Warning, Ok
	}

	public enum LegalPartyLoadType {
		Full
	}

	public ResponseMsg personOpen(Person person, int contractPartyId,
			int signatoryTypeId, int modifiedBy) {

		final int AccountHolder = 1;
		final int AuthorisedSignatory = 9;
		final int AuthorisedUser = 2;
		final int Director = 3;
		final int NonSignatory = 10;
		final int Trustee = 11;
		final int SingleContract = 1;
		final int JointContract = 2;

		response = new ResponseMsg();

		// Load the contract party details...
		ContractParty contract = ContractPartyApp.ContractPartyGet(contractPartyId, AccountOpenApp.LegalPartyLoadType.Full);

		if ((contract == null) || (contract.getLegalPartyId() != contractPartyId)) {
			Person person2 = null;

			// 1 - Load details if existing person has been supplied...
			if (person.getLegalPartyId() > 0) {
				person2 = PersonApp.PersonGet(person.getLegalPartyId());

				if ((person2 == null)
						|| (person2.getLegalPartyId() != person
								.getLegalPartyId())) {
					response.setErrorCode(AccountOpenApp.ErrorCode.Warning);
					response.setMessage("Person party identifier does not exist.");
					return response;
				}
			} else {
				// Add the person's useful events...
				person.setEvents(createLegalPartyEvents(person
						.getRegulatoryClassification()));

				// Determine the regulator associated with the employer's
				// country...
				if ((person.getEmployment() != null)
						&& (person.getEmployment().getRegulator() != null)) {
					Country country = CountryApp.CountryGet(person
							.getEmployment().getEmployerAddress().getCountry()
							.getId());
					person.getEmployment().getRegulator()
							.setId(country.getRegulator().getId());
				}
			}

			// 2 - Determine that party has a current registered address...
			response = checkForRegisteredAddress(person.getAddresses());

			if (response.getErrorCode() != AccountOpenApp.ErrorCode.Ok) {
				return response;
			}

			// 3 - Build the relationships between the person, corporate and
			// contract parties...
			List<LegalPartyRelationship> relationships = new ArrayList<LegalPartyRelationship>();
			LegalPartyRelationship relationship;
			boolean found = false;

			// Contract party is single or joint type...
			if (contract.getType().getId() == SingleContract
					|| contract.getType().getId() == JointContract) {
				// Existing person has been supplied so check for existing
				// 'account holder' relationship with contract...
				if (person.getLegalPartyId() > 0
						&& contract.getRelationships() != null) {
					for (LegalPartyRelationship item : contract
							.getRelationships()) {
						if ((item.getRelatedLegalPartyId() == person
								.getLegalPartyId())
								&& (item.getRelationshipType().getId() == AccountHolder)) {
							found = true;
							break;
						}
					}
				}

				// If it doesn't exist then specify an 'account holder'
				// relationship between the individual and the contract...
				if (found == false) {
					relationship = createLegalPartyRelationship(
							contract.getLegalPartyId(),
							person.getLegalPartyId(), AccountHolder);
					relationships.add(relationship);
				}
			} else {
				// Contract type is corporate, superannuation or trust...
				Corporate corporate = null;

				// Determine that there is an existing 'account holder'
				// relationship between the contract and a corporate party...
				if (contract.getRelationships() != null) {
					for (LegalPartyRelationship item : contract
							.getRelationships()) {
						if (item.getRelationshipType().getId() == AccountHolder) {
							// Load the corporate details...
							corporate = CorporateApp.CorporateGet(item
									.getRelatedLegalPartyId());

							if (corporate != null) {
								found = true;
								break;
							}
						}
					}
				}

				// Construct the relationship between the corporate and
				// individual...
				if (found == false) {
					response.setErrorCode(AccountOpenApp.ErrorCode.Warning);
					response.setMessage("Corporate contract must have an associated corporate party as an account holder prior to adding individuals.");
					return response;
				} else {
					found = false;

					// Existing individual has been supplied so check for
					// existing relationship with the contract...
					if (person.getLegalPartyId() > 0
							&& ((corporate != null) && (corporate
									.getRelationships() != null))) {
						for (LegalPartyRelationship item : corporate
								.getRelationships()) {
							if (item.getRelatedLegalPartyId() == person
									.getLegalPartyId()
									&& item.getRelationshipType().getId() == signatoryTypeId) {
								found = true;
								break;
							}
						}
					}

					// No relationship was found...
					if (found == false) {
						relationship = new LegalPartyRelationship();
						relationship.setLegalPartyId(corporate
								.getLegalPartyId());
						relationship.setRelatedLegalPartyId(person
								.getLegalPartyId());

						switch (signatoryTypeId) {
						case Director:
							relationship.getRelationshipType().setId(Director);
							break;
						case AuthorisedSignatory:
							relationship.getRelationshipType().setId(
									AuthorisedSignatory);
							break;
						case NonSignatory:
							relationship.getRelationshipType().setId(
									NonSignatory);
							break;
						case Trustee:
							relationship.getRelationshipType().setId(Trustee);
							break;
						}

						relationships.add(relationship);
					}
				}

				// Construct the 'authorised user' relationship between the
				// contract and individual...
				found = false;

				// Construct the 'authorised user' relationship between the
				// contract and individual...
				if (person.getLegalPartyId() > 0
						&& contract.getRelationships() != null) {
					for (LegalPartyRelationship item : contract
							.getRelationships()) {
						if ((item.getRelatedLegalPartyId() == person
								.getLegalPartyId())
								&& (item.getRelationshipType().getId() == AuthorisedUser)) {
							found = true;
							break;
						}
					}
				}

				if (found == false) {
					relationship = createLegalPartyRelationship(
							contract.getLegalPartyId(),
							person.getLegalPartyId(), AuthorisedUser);
					relationships.add(relationship);
				}
			}

			// 4 - Validate each new relationship against any existing contract
			// relationships...
			if (person.getLegalPartyId() > 0 && relationships != null) {
				for (LegalPartyRelationship item : relationships) {
					response = LegalPartyApp
							.LegalPartyRelationshipValidate(item);

					if (response.getErrorCode() != AccountOpenApp.ErrorCode.Ok) {
						break;
					}
				}
			}

			// 5 - If person exists then set any values that can be confidently
			// updated...
			Person updatePerson = null;
			List<AccountUser> users = null;

			if (person.getLegalPartyId() >= 0) {
				updatePerson = personUpdateMapper(person, person2);
				users = new ArrayList<AccountUser>();

				if (updatePerson != null) {
					PersonApp.PersonValidate(updatePerson, users);
				}
			}

			boolean insertAirmilesRegistration = false;
			int AMOperatorId = 0;

			ClientAccount client = ClientAccountDA
					.ClientAccountGetByLegalPartyId(contract.getLegalPartyId());

			// The following only applies if the contract type is Single or
			// Joint...
			if (contract.getType().getId() == AccountHolder
					|| contract.getType().getId() == SingleContract
					|| contract.getType().getId() == JointContract) {
				// Check whether an operator account exists for using airmiles.
				int accountOperatorId = contract.getApplicationSource()
						.getAccountOperator().getLegalPartyId();
				AMOperatorId = AirmilesDA
						.ClientAirmilesAccountOperatorExists(accountOperatorId);

				if (AMOperatorId != 0) {
					Address address = null;

					for (Address item : person.getAddresses()) {
						if (item.getStatus().getId() == 1
								&& item.getType().getId() == 1) {
							address = item;
							break;
						}
					}

					Country countryDTO = address.getCountry();
					int countryId = countryDTO.getId();

					// Check if country accepted by account operator
					if (AirmilesDA.AccountOperatorCountry(countryId,
							AMOperatorId)) {
						// Check whether the client account already has a person
						// registered for AirMiles associated.
						// ClientAccountApplication.getClientAccountIdByLegalPartyId(person.getLegalPartyId());
						if (!AirmilesDA.ClientAirmilesRegistrationExists(client
								.getClientAccountId())) {
							insertAirmilesRegistration = true;
						}
					}
				}
			}

			// Commit the data...
			if (response.getErrorCode() == AccountOpenApp.ErrorCode.Ok) {
				TransactionBlock transactionBlock = new TransactionBlock(
						AccountOpenApp.DbName.Atlas);
				// Commit person details...
				if (person.getLegalPartyId() <= 0) {
					person.setLegalPartyId(PersonApp.PersonAdd(
							transactionBlock, person, modifiedBy));
				} else if (updatePerson != null) {
					PersonApp.PersonUpdate(transactionBlock, updatePerson,
							users, modifiedBy);
				}

				// Commit any relationships...
				if (relationships != null) {
					for (LegalPartyRelationship item : relationships) {
						item.setRelatedLegalPartyId(person.getLegalPartyId());
						LegalPartyDA.LegalPartyRelationshipAdd(
								transactionBlock, item, modifiedBy);
					}
				}

				if (insertAirmilesRegistration) { // a new airmiles registration
					AirmilesDA.AddClientAirmilesRegistration(null,
							AMOperatorId, client.getClientAccountId(),
							person.getLegalPartyId(), 2);
				}

				response.setId(person.getLegalPartyId());

				transactionBlock.Complete();
			}
		} else {
			response.setErrorCode(AccountOpenApp.ErrorCode.Warning);
			response.setMessage("Contract party identifier does not exist.");
			return response;
		}

		return response;
	}

	// ****** dummy methods only here to make it compile
	// ****************************/////
	private Person personUpdateMapper(Person person,
			Person person2) {
		return new Person();
	}

	private LegalPartyRelationship createLegalPartyRelationship(
			int id, int i, int holder) {
		return null;
	}

	private ResponseMsg checkForRegisteredAddress(
			List<Address> addresses) {
		return null;
	}

	private List<LegalPartyEvents> createLegalPartyEvents(
			int classification) {
		return null;
	}
}
