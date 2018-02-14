package org.tmf.openapi.agreement.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class PartyRoleRef {

	@NotEmpty(message = "Id is mandatory")
	private String id;

	private String href;

	@NotEmpty(message = "Name is mandatory")
	private String name;

	private String partyId;

	private String partyName;

}
