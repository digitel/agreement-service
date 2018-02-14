package org.tmf.openapi.agreement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class AgreementSpecCharacteristicValue {

	@JsonProperty("default")
	private boolean _default;

	private String unitOfMeasure;

	private TimePeriod validFor;

	private String value;

	private String valueFrom;

	private String valueTo;

	private String valueType;

}
