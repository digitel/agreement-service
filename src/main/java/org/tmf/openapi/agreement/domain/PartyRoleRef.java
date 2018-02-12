package org.tmf.openapi.agreement.domain;

import javax.validation.constraints.NotEmpty;

public class PartyRoleRef {

	@NotEmpty(message="Id is mandatory")
	private String id;

	private String href;

	@NotEmpty(message="Name is mandatory")
	private String name;

	private String partyId;

	private String partyName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	@Override
	public String toString() {
		return "PartyRoleRef{" + "id='" + id + '\'' + ", href='" + href + '\'' + ", name='" + name + '\''
				+ ", partyID='" + partyId + '\'' + ", partyName='" + partyName + '\'' + '}';
	}
}
