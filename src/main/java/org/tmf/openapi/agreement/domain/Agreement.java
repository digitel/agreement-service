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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Document
@JsonFilter("agreementFilter")
@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class Agreement {

	@Id
	private String id;

	@Valid
	private TimePeriod agreementPeriod;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private Date completionDate;

	private String description;

	private Long documentNumber;

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

}
