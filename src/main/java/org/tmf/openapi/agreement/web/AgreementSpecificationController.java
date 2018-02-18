package org.tmf.openapi.agreement.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.tmf.openapi.agreement.common.ObjectMapper.mapObjectWithExcludeFilter;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
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
import org.tmf.openapi.agreement.domain.AgreementSpecification;
import org.tmf.openapi.agreement.service.AgreementSpecificationService;

import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/agreementManagement/agreementSpecification")
public class AgreementSpecificationController {

	@Autowired
	AgreementSpecificationService agreementSpecificationService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> createAgreementSpecification(
			@RequestBody @Valid AgreementSpecification agreementSpecification) {

		agreementSpecification = agreementSpecificationService.createAgreementSpecification(agreementSpecification);
		return ResponseEntity.created(populateHref(agreementSpecification).getHref())
				.body(mapObjectWithExcludeFilter(agreementSpecification, null));
	}

	@PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> patchAgreementSpecification(@PathVariable String id,
			@RequestBody AgreementSpecification agreementSpecification) {

		validateAgreementSpecification(id, agreementSpecification);
		return ResponseEntity.ok(mapObjectWithExcludeFilter(
				populateHref(agreementSpecificationService.partialUpdateAgreementSpecification(agreementSpecification)),
				null));

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> getAgreementSpecification(@PathVariable String id,
			@RequestParam MultiValueMap<String, String> requestParams) {
		return ResponseEntity.ok(mapObjectWithExcludeFilter(
				populateHref(agreementSpecificationService.findAgreementSpecification(id)), requestParams));

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> getAgreementSpecification(
			@RequestParam MultiValueMap<String, String> requestParams,
			@QuerydslPredicate(root = AgreementSpecification.class) Predicate predicate) {
		return ResponseEntity.ok(mapObjectWithExcludeFilter(
				populateHref(agreementSpecificationService.findAgreementSpecification(predicate)), requestParams));

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MappingJacksonValue> deleteAgreementSpecification(@PathVariable String id) {
		agreementSpecificationService.deleteAgreementSpecification(id);
		return ResponseEntity.noContent().build();

	}

	private void validateAgreementSpecification(String id, AgreementSpecification agreementSpecification) {
		if ((null == agreementSpecification.getId())
				|| (null != agreementSpecification.getId() && !id.equals(agreementSpecification.getId()))) {
			throw new IllegalArgumentException("id cannot be updated.");
		}

	}

	private AgreementSpecification populateHref(AgreementSpecification agreementSpecification) {
		agreementSpecification
				.setHref(linkTo(AgreementSpecificationController.class).slash(agreementSpecification.getId()).toUri());
		return agreementSpecification;
	}

	private List<AgreementSpecification> populateHref(List<AgreementSpecification> agreementSpecifications) {
		for (AgreementSpecification agreementSpecification : agreementSpecifications) {
			populateHref(agreementSpecification);
		}
		return agreementSpecifications;
	}
}
