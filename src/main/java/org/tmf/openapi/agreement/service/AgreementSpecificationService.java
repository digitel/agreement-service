package org.tmf.openapi.agreement.service;

import static org.tmf.openapi.agreement.common.ListUtils.toList;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmf.openapi.agreement.domain.AgreementSpecification;
import org.tmf.openapi.agreement.repository.AgreementSpecificationRepository;

import com.querydsl.core.types.Predicate;

@Service
public class AgreementSpecificationService {

	@Autowired
	private AgreementSpecificationRepository agreementSpecificationRepository;

	public AgreementSpecification createAgreementSpecification(@Valid AgreementSpecification agreementSpecification) {

		if (agreementSpecification.getId() != null) {
			throw new IllegalArgumentException("id must be empty while creating Agreement");
		}

		setDefaultAttributes(agreementSpecification);

		return agreementSpecificationRepository.save(agreementSpecification);
	}

	public AgreementSpecification findAgreementSpecification(@NotNull String id) {
		return agreementSpecificationRepository.findById(id).get();
	}

	public List<AgreementSpecification> findAgreementSpecification(Predicate predicate) {

		return toList(agreementSpecificationRepository.findAll(predicate));
	}

	public AgreementSpecification partialUpdateAgreementSpecification(AgreementSpecification agreementSpecification) {
		AgreementSpecification existingAgreementSpecification = getExistingAgreementSpecification(
				agreementSpecification.getId());
		updateExistingAgreementSpecification(agreementSpecification, existingAgreementSpecification);
		return agreementSpecificationRepository.save(existingAgreementSpecification);
	}

	public void deleteAgreementSpecification(@NotNull String id) {

		AgreementSpecification existingAgreementSpecification = getExistingAgreementSpecification(id);
		agreementSpecificationRepository.delete(existingAgreementSpecification);
	}

	private void updateExistingAgreementSpecification(AgreementSpecification agreementSpecification,
			AgreementSpecification existingAgreementSpecification) {

		if (null != agreementSpecification.getHref()) {

			throw new IllegalArgumentException("href cannot be updated.");
		}

		if (null != agreementSpecification.getDescription()) {
			existingAgreementSpecification.setDescription(agreementSpecification.getDescription());
		}

		if (null != agreementSpecification.getIsBundle()) {
			existingAgreementSpecification.setIsBundle(agreementSpecification.getIsBundle());
		}
		if (null != agreementSpecification.getLastUpdate()) {
			existingAgreementSpecification.setLastUpdate(agreementSpecification.getLastUpdate());
		}

		if (null != agreementSpecification.getLifecycleStatus()) {
			existingAgreementSpecification.setLifecycleStatus(agreementSpecification.getLifecycleStatus());
		}

		if (null != agreementSpecification.getName()) {
			existingAgreementSpecification.setName(agreementSpecification.getName());
		}
		if (null != agreementSpecification.getValidFor()) {
			existingAgreementSpecification.setValidFor(agreementSpecification.getValidFor());
		}

		if (null != agreementSpecification.getVersion()) {
			existingAgreementSpecification.setVersion(agreementSpecification.getVersion());
		}
		if (null != agreementSpecification.getServiceCategory()) {
			existingAgreementSpecification.setServiceCategory(agreementSpecification.getServiceCategory());
		}

		if (null != agreementSpecification.getSpecCharacteristic()) {
			existingAgreementSpecification.setSpecCharacteristic(agreementSpecification.getSpecCharacteristic());
		}
		if (null != agreementSpecification.getRelatedParty()) {
			existingAgreementSpecification.setRelatedParty(agreementSpecification.getRelatedParty());
		}

		if (null != agreementSpecification.getAttachment()) {
			existingAgreementSpecification.setAttachment(agreementSpecification.getAttachment());
		}

		if (null != agreementSpecification.getSpecificationRelationship()) {
			existingAgreementSpecification
					.setSpecificationRelationship(agreementSpecification.getSpecificationRelationship());
		}

	}

	private void setDefaultAttributes(AgreementSpecification agreementSpecification) {

		if (null == agreementSpecification.getIsBundle()) {

			agreementSpecification.setIsBundle(false);
		}

	}

	private AgreementSpecification getExistingAgreementSpecification(@NotNull String id) {
		Optional<AgreementSpecification> existingAgreementSpecificationOption = agreementSpecificationRepository
				.findById(id);
		if (!existingAgreementSpecificationOption.isPresent()) {
			throw new IllegalArgumentException("Agreement Specification with id " + id + " doesnot exists");
		}

		AgreementSpecification existingAgreementSpecification = existingAgreementSpecificationOption.get();
		return existingAgreementSpecification;
	}

}
