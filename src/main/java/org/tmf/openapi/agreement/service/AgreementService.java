package org.tmf.openapi.agreement.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmf.openapi.agreement.domain.Agreement;
import org.tmf.openapi.agreement.repository.AgreementRepository;

@Service
public class AgreementService {

	@Autowired
	private AgreementRepository agreementRepository;

	public Agreement createAgreement(@Valid Agreement agreement) {

		if (agreement.getId() != null) {
			throw new IllegalArgumentException("id must be empty while creating Agreement");
		}

		setDefaultAttributes(agreement);

		return agreementRepository.save(agreement);
	}

	public Agreement findAgreement(@NotNull String id) {
		return agreementRepository.findById(id).get();
	}

	public Agreement partialUpdateAgreement(Agreement agreement) {

		Agreement existingAgreement = getExistingAgreement(agreement.getId());
		updateExistingAgreement(agreement, existingAgreement);
		return agreementRepository.save(existingAgreement);
	}

	public void deleteAgreement(@NotNull String id) {

		Agreement existingAgreement = getExistingAgreement(id);
		agreementRepository.delete(existingAgreement);
	}

	private void setDefaultAttributes(Agreement agreement) {
		if (null == agreement.getCompletionDate()) {
			agreement.setCompletionDate(new Date());
		}

		if (null == agreement.getVersion()) {
			agreement.setVersion("0");
		}
	}

	private Agreement getExistingAgreement(@NotNull String id) {
		Optional<Agreement> existingAgreementOption = agreementRepository.findById(id);
		if (!existingAgreementOption.isPresent()) {
			throw new IllegalArgumentException("Agreement with id " + id + " doesnot exists");
		}

		Agreement existingAgreement = existingAgreementOption.get();
		return existingAgreement;
	}

	private void updateExistingAgreement(Agreement agreement, Agreement existingAgreement) {

		if (null != agreement.getHref() || null != agreement.getCompletionDate()) {

			throw new IllegalArgumentException("href and completionDate cannot be updated.");
		}

		if (null != agreement.getAgreementAuthorization()) {
			existingAgreement.setAgreementAuthorization(agreement.getAgreementAuthorization());
		}

		if (null != agreement.getAgreementItem()) {
			existingAgreement.setAgreementItem(agreement.getAgreementItem());
		}

		if (null != agreement.getAgreementPeriod()) {
			existingAgreement.setAgreementPeriod(agreement.getAgreementPeriod());
		}

		if (null != agreement.getDescription()) {
			existingAgreement.setDescription(agreement.getDescription());
		}

		if (null != agreement.getDocumentNumber()) {
			existingAgreement.setDocumentNumber(agreement.getDocumentNumber());
		}

		if (null != agreement.getInitialDate()) {
			existingAgreement.setInitialDate(agreement.getInitialDate());
		}

		if (null != agreement.getName()) {
			existingAgreement.setName(agreement.getName());
		}

		if (null != agreement.getStatementOfIntent()) {
			existingAgreement.setStatementOfIntent(agreement.getStatementOfIntent());
		}
		if (null != agreement.getStatus()) {
			existingAgreement.setStatus(agreement.getStatus());
		}
		if (null != agreement.getType()) {
			existingAgreement.setType(agreement.getType());
		}
		if (null != agreement.getVersion()) {
			existingAgreement.setVersion(agreement.getVersion());
		}
		if (null != agreement.getAgreementSpecification()) {
			existingAgreement.setAgreementSpecification(agreement.getAgreementSpecification());
		}
		if (null != agreement.getEngagedPartyRole()) {
			existingAgreement.setEngagedPartyRole(agreement.getEngagedPartyRole());
		}
		if (null != agreement.getCharacteristic()) {
			existingAgreement.setCharacteristic(agreement.getCharacteristic());
		}
		if (null != agreement.getAssociatedAgreement()) {
			existingAgreement.setAssociatedAgreement(agreement.getAssociatedAgreement());
		}
	}

}
