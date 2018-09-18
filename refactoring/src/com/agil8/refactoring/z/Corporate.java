package com.agil8.refactoring.z;

import java.util.List;

public class Corporate {
	private List<LegalPartyRelationship> relationships;
	private int legalPartyId;

	public List<LegalPartyRelationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<LegalPartyRelationship> relationships) {
		this.relationships = relationships;
	}

	public int getLegalPartyId() {
		return legalPartyId;
	}

	public void setLegalPartyId(int legalPartyId) {
		this.legalPartyId = legalPartyId;
	}
}
