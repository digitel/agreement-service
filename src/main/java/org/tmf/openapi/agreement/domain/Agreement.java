package org.tmf.openapi.agreement.domain;

import static org.tmf.openapi.agreement.common.Constant.DATE_PATTERN;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document
@JsonFilter("agreementFilter")
public class Agreement {

	@Id
	private String id;

	@Valid
	private TimePeriod agreementPeriod;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private Date completionDate;

	private String description;

	private long documentNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private Date initialDate;

	@NotEmpty(message = "Name is mandatory")
	private String name;

	private String statementOfIntent;

	private AgreementStatus status;

	@NotEmpty(message = "Type is mandatory")
	private String type;

	private String version;

	private AgreementSpecificationRef agreementSpecification;

	@NotEmpty(message = "Agreement Item is mandatory")
	@Valid
	private List<AgreementItem> agreementItem;

	@NotEmpty(message = "Engaged Party Role is mandatory")
	@Valid
	private List<PartyRoleRef> engagedPartyRole;

	private List<AgreementAuthorization> agreementAuthorization;

	private List<Characteristic> characteristic;
	
	@Valid
	private List<AgreementRef> associatedAgreement;

	@Transient
	private URI href;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TimePeriod getAgreementPeriod() {
		return agreementPeriod;
	}

	public void setAgreementPeriod(TimePeriod agreementPeriod) {
		this.agreementPeriod = agreementPeriod;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(long documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatementOfIntent() {
		return statementOfIntent;
	}

	public void setStatementOfIntent(String statementOfIntent) {
		this.statementOfIntent = statementOfIntent;
	}

	public URI getHref() {
		return href;
	}

	public void setHref(URI href) {
		this.href = href;
	}

	public AgreementStatus getStatus() {
		return status;
	}

	public void setStatus(AgreementStatus status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public AgreementSpecificationRef getAgreementSpecification() {
		return agreementSpecification;
	}

	public void setAgreementSpecification(AgreementSpecificationRef agreementSpecification) {
		this.agreementSpecification = agreementSpecification;
	}

	public List<AgreementItem> getAgreementItem() {
		return agreementItem;
	}

	public void setAgreementItem(List<AgreementItem> agreementItem) {
		this.agreementItem = agreementItem;
	}

	public List<PartyRoleRef> getEngagedPartyRole() {
		return engagedPartyRole;
	}

	public void setEngagedPartyRole(List<PartyRoleRef> engagedPartyRole) {
		this.engagedPartyRole = engagedPartyRole;
	}

	public List<AgreementAuthorization> getAgreementAuthorization() {
		return agreementAuthorization;
	}

	public void setAgreementAuthorization(List<AgreementAuthorization> agreementAuthorization) {
		this.agreementAuthorization = agreementAuthorization;
	}

	public List<Characteristic> getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(List<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}

	public List<AgreementRef> getAssociatedAgreement() {
		return associatedAgreement;
	}

	public void setAssociatedAgreement(List<AgreementRef> associatedAgreement) {
		this.associatedAgreement = associatedAgreement;
	}

}
