package org.tmf.openapi.agreement.domain;

public enum AgreementStatus {

	INITIALIZED("Initialized"), IN_PROCESS("In_Process"), PENDING_UPDATE("Pending_Update"), VALIDATED(
			"Validated"), REJECTED("Rejected"), CLOSED("closed");

	private final String value;

	AgreementStatus(String value) {
		this.value = value;
	}

	public static AgreementStatus fromValue(String v) {
		for (AgreementStatus c : AgreementStatus.values()) {
			if (c.value.equalsIgnoreCase(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "AgreementStatus{" + "value='" + value + '\'' + '}';
	}

}
