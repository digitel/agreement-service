package org.tmf.openapi.agreement.domain;

import java.util.List;

public class AgreementItem {

	private List<ProductOfferingRef> productOffering;

	private List<AgreementTermOrCondition> termOrCondition;

	public List<ProductOfferingRef> getProductOffering() {
		return productOffering;
	}

	public void setProductOffering(List<ProductOfferingRef> productOffering) {
		this.productOffering = productOffering;
	}

	public List<AgreementTermOrCondition> getTermOrCondition() {
		return termOrCondition;
	}

	public void setTermOrCondition(List<AgreementTermOrCondition> termOrConditions) {
		this.termOrCondition = termOrConditions;
	}

	@Override
	public String toString() {
		return "AgreementItem{" + "productOffering=" + productOffering + ", termOrConditions=" + termOrCondition + '}';
	}
}
