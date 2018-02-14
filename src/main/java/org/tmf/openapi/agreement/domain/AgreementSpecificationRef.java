package org.tmf.openapi.agreement.domain;

import java.net.URI;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)

public class AgreementSpecificationRef {

	private String description;

	private URI href;

	private String id;

	private String name;

}
