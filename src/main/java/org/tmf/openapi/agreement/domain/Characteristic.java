package org.tmf.openapi.agreement.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class Characteristic {

	private String name;

	private String value;

}
