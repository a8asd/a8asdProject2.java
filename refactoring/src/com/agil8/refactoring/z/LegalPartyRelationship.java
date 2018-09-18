package com.agil8.refactoring.z;

public class LegalPartyRelationship {
	private int relatedLegalPartyId;
	private LegalPartyRelationshipType relationshipType;
	private int legalPartyId;
	private LegalParty accountOperator;

	public int getRelatedLegalPartyId() {
		return relatedLegalPartyId;
	}

	public void setRelatedLegalPartyId(int relatedLegalPartyId) {
		this.relatedLegalPartyId = relatedLegalPartyId;
	}

	public LegalPartyRelationshipType getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(
			LegalPartyRelationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}

	public int getLegalPartyId() {
		return legalPartyId;
	}

	public void setLegalPartyId(int legalPartyId) {
		this.legalPartyId = legalPartyId;
	}

	public LegalParty getAccountOperator() {
		return accountOperator;
	}

	public void setAccountOperator(LegalParty accountOperator) {
		this.accountOperator = accountOperator;
	}
}
