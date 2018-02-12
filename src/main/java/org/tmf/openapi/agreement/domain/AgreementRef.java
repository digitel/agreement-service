package org.tmf.openapi.agreement.domain;

import javax.validation.constraints.NotEmpty;

public class AgreementRef {

	@NotEmpty(message = "Id  is mandatory")
	private String id;
	private String name;

	@NotEmpty(message = "href  is mandatory")
	private String href;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
