package com.agil8.refactoring.z;

import java.util.List;


    public class Person
    {
        private int regulatoryClassification;
        private int legalPartyId;
        private Employment employment;
        private int id;
        private List<Address> addresses;
		private List<LegalPartyEvents> events;
		public int getRegulatoryClassification() {
			return regulatoryClassification;
		}
		public void setRegulatoryClassification(int regulatoryClassification) {
			this.regulatoryClassification = regulatoryClassification;
		}
		public int getLegalPartyId() {
			return legalPartyId;
		}
		public void setLegalPartyId(int legalPartyId) {
			this.legalPartyId = legalPartyId;
		}
		public Employment getEmployment() {
			return employment;
		}
		public void setEmployment(Employment employment) {
			this.employment = employment;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public List<Address> getAddresses() {
			return addresses;
		}
		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
		public void setEvents(List<LegalPartyEvents> events) {
			this.events = events;
		}
		public List<LegalPartyEvents> getEvents() {
			return events;
		}
    }

