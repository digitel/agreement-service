package org.tmf.openapi.agreement.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class ProductOfferingRef {

	private String id;

	private String href;

	private String name;

}
