package org.tmf.openapi.agreement.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmf.openapi.agreement.domain.AgreementSpecification;
import org.tmf.openapi.agreement.repository.AgreementSpecificationRepository;

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

	private void setDefaultAttributes(AgreementSpecification agreementSpecification) {

		if (null == agreementSpecification.getIsBundle()) {

			agreementSpecification.setIsBundle(false);
		}

	}

}
