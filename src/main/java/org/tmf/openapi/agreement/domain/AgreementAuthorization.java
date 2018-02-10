package org.tmf.openapi.agreement.domain;

import java.util.Date;

import static org.tmf.openapi.agreement.common.Constant.DATE_WITH_TIME_PATTERN;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AgreementAuthorization {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_WITH_TIME_PATTERN)
	private Date date;

	private String signatureRepresentation;

	private String state;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSignatureRepresentation() {
		return signatureRepresentation;
	}

	public void setSignatureRepresentation(String signatureRepresentation) {
		this.signatureRepresentation = signatureRepresentation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AgreementAuthorization{" + "date=" + date + ", signatureRepresentation='" + signatureRepresentation
				+ '\'' + ", state='" + state + '\'' + '}';
	}
}
