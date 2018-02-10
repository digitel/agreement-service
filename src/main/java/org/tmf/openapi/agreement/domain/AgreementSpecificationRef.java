package org.tmf.openapi.agreement.domain;

import java.net.URI;

public class AgreementSpecificationRef {

	private String description;

	private URI href;

	private String id;

	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public URI getHref() {
		return href;
	}

	public void setHref(URI href) {
		this.href = href;
	}

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

	@Override
	public String toString() {
		return "AgreementSpecificationRef{" + "description='" + description + '\'' + ", href='" + href + '\'' + ", id='"
				+ id + '\'' + ", name='" + name + '\'' + '}';
	}
}
