package org.tmf.openapi.agreement.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)

public class AgreementRef {

	@NotEmpty(message = "Id  is mandatory")
	private String id;
	private String name;

	@NotEmpty(message = "href  is mandatory")
	private String href;

}
