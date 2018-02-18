package org.tmf.openapi.agreement.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.tmf.openapi.agreement.common.ObjectMapper.mapObjectWithExcludeFilter;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tmf.openapi.agreement.domain.AgreementSpecification;
import org.tmf.openapi.agreement.service.AgreementSpecificationService;

@RestController
@RequestMapping("/agreementManagement/agreementSpecification")
public class AgreementSpecificationController {

	@Autowired
	AgreementSpecificationService agreementSpecificationService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> createAgreementSpecificationService(
			@RequestBody @Valid AgreementSpecification agreementSpecification) {
		
		agreementSpecification = agreementSpecificationService.createAgreementSpecification(agreementSpecification);
		return ResponseEntity.created(populateHref(agreementSpecification).getHref())
				.body(mapObjectWithExcludeFilter(agreementSpecification, null));
	}

	private AgreementSpecification populateHref(AgreementSpecification agreementSpecification) {
		agreementSpecification.setHref(linkTo(AgreementSpecificationController.class).slash(agreementSpecification.getId()).toUri());
		return agreementSpecification;
	}

	private List<AgreementSpecification> populateHref(List<AgreementSpecification> agreementSpecifications) {
		for (AgreementSpecification agreementSpecification : agreementSpecifications) {
			populateHref(agreementSpecification);
		}
		return agreementSpecifications;
	}
}
