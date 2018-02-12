package org.tmf.openapi.agreement.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.tmf.openapi.agreement.common.ObjectMapper.mapObjectWithExcludeFilter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tmf.openapi.agreement.domain.Agreement;
import org.tmf.openapi.agreement.service.AgreementService;

@RestController
@RequestMapping("/agreementManagement/agreement")
public class AgreementController {

	@Autowired
	AgreementService agreementService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> createAgreement(@RequestBody @Valid Agreement agreement) {
		agreement = agreementService.createAgreement(agreement);
		return ResponseEntity.created(populateHref(agreement).getHref())
				.body(mapObjectWithExcludeFilter(agreement, null));
	}

	private Agreement populateHref(Agreement agreement) {
		agreement.setHref(linkTo(AgreementController.class).slash(agreement.getId()).toUri());
		return agreement;
	}

}