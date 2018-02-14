package org.tmf.openapi.agreement.domain;

import javax.validation.Valid;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class RelatedPartyRef {

	private String id;

	private String href;

	private String name;

	private String role;

	@Valid
	private TimePeriod validFor;

}
