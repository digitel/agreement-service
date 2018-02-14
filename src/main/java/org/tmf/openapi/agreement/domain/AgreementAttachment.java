package org.tmf.openapi.agreement.domain;

import java.net.URI;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class AgreementAttachment {

	@Id
	private String id;

	private URI href;

	private String type;

	private URI url;

}
