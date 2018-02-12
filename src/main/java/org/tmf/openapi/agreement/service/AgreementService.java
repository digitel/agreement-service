package org.tmf.openapi.agreement.service;

import java.util.Date;

import javax.validation.Valid;

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

		if (null == agreement.getCompletionDate()) {
			agreement.setCompletionDate(new Date());
		}

		if (null == agreement.getVersion()) {
			agreement.setVersion("0");
		}

		return agreementRepository.save(agreement);
	}

}
