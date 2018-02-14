package org.tmf.openapi.agreement.domain;

import java.net.URI;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class AgreementSpecificationRelationship {

	private String id;

	private URI href;

	private String type;

	private TimePeriod validFor;

}
