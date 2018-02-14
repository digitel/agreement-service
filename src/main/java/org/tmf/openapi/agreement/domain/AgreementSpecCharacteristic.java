package org.tmf.openapi.agreement.domain;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class AgreementSpecCharacteristic {

	private boolean configurable;

	private String description;

	private String name;

	private TimePeriod validFor;

	private String valueType;

	private List<AgreementSpecCharacteristicValue> specCharacteristicValue;

}
