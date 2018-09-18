package com.agil8.refactoring.z;

import java.util.List;

    public class ContractParty
    {
        private Type type;
        private List<LegalPartyRelationship> relationships;
        private LegalPartyRelationship applicationSource;
		private int legalPartyId;
		public int getLegalPartyId() {
			return legalPartyId;
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		public List<LegalPartyRelationship> getRelationships() {
			return relationships;
		}
		public void setRelationships(List<LegalPartyRelationship> relationships) {
			this.relationships = relationships;
		}
		public LegalPartyRelationship getApplicationSource() {
			return applicationSource;
		}
		public void setApplicationSource(LegalPartyRelationship applicationSource) {
			this.applicationSource = applicationSource;
		}
    }
