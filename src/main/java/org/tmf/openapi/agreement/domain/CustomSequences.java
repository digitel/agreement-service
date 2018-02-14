package org.tmf.openapi.agreement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Document(collection = "customSequences")
@Data
@EqualsAndHashCode(of = "id")
@ToString(includeFieldNames = true)
public class CustomSequences {

	@Id
	private String id;

	private int seq;

}