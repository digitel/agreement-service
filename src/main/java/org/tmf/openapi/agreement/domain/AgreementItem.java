package org.tmf.openapi.agreement.domain;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class AgreementItem {

	private List<ProductOfferingRef> productOffering;

	private List<AgreementTermOrCondition> termOrCondition;

}
