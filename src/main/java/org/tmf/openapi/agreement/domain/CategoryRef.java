package org.tmf.openapi.agreement.domain;

import java.net.URI;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class CategoryRef {

	@Id
	private String id;

	private URI href;

	private String name;

	private String version;

}
// TODO Base ref object (id,href,name)