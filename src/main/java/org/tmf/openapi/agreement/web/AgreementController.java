package org.tmf.openapi.agreement.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.tmf.openapi.agreement.common.ObjectMapper.mapObjectWithExcludeFilter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> patchAgreement(@PathVariable String id,
			@RequestBody Agreement agreement) {

		validateAgreement(id, agreement);
		return ResponseEntity
				.ok(mapObjectWithExcludeFilter(populateHref(agreementService.partialUpdateAgreement(agreement)), null));

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> getAgreement(@PathVariable String id,
			@RequestParam MultiValueMap<String, String> requestParams) {
		return ResponseEntity
				.ok(mapObjectWithExcludeFilter(populateHref(agreementService.findAgreement(id)), requestParams));

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> deleteAgreement(@PathVariable String id) {
		agreementService.deleteAgreement(id);
		return ResponseEntity.noContent().build();

	}

	private Agreement populateHref(Agreement agreement) {
		agreement.setHref(linkTo(AgreementController.class).slash(agreement.getId()).toUri());
		return agreement;
	}

	private void validateAgreement(String id, Agreement agreement) {
		if ((null == agreement.getId()) || (null != agreement.getId() && !id.equals(agreement.getId()))) {
			throw new IllegalArgumentException("id cannot be updated.");
		}
	}

}
