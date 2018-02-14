package org.tmf.openapi.agreement.domain;

import static org.tmf.openapi.agreement.common.Constant.DATE_WITH_TIME_PATTERN;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.tmf.openapi.agreement.validator.ValidTimePeriod;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@ValidTimePeriod

@Data
@ToString(includeFieldNames = true)

public class TimePeriod {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_WITH_TIME_PATTERN)
	@NotNull(message = "Start Date is mandatory")
	private Date startDateTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_WITH_TIME_PATTERN)
	@NotNull(message = "End Date is mandatory")
	private Date endDateTime;

}
