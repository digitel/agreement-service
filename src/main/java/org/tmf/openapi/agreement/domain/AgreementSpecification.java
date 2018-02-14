package org.tmf.openapi.agreement.domain;

import static org.tmf.openapi.agreement.common.Constant.DATE_WITH_TIME_PATTERN;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Document
@JsonFilter("agreementSpecificationFilter")
@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class AgreementSpecification {

	@Id
	private String id;

	private URI href;

	private String description;

	private boolean isBundle;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_WITH_TIME_PATTERN)
	private Date lastUpdate;

	private AgreementStatus lifecycleStatus;

	private String name;

	@Valid
	private TimePeriod validFor;

	private String version;

	private CategoryRef serviceCategory;

	private List<AgreementSpecCharacteristic> specCharacteristic;

	private List<AgreementAttachment> attachment;

	private List<AgreementSpecificationRelationship> specificationRelationship;

	private List<RelatedPartyRef> relatedParty;

}
