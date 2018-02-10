package org.tmf.openapi.agreement.domain;

import static org.tmf.openapi.agreement.common.Constant.DATE_WITH_TIME_PATTERN;

import java.text.ParseException;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.tmf.openapi.agreement.validator.ValidTimePeriod;

import com.fasterxml.jackson.annotation.JsonFormat;

@ValidTimePeriod
public class TimePeriod {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_WITH_TIME_PATTERN)
	@NotNull(message="Start Date is mandatory")
	private Date startDateTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_WITH_TIME_PATTERN)
	@NotNull(message="End Date is mandatory")
	private Date endDateTime;

	public Date getStartDateTime() {
		return startDateTime;

	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) throws ParseException {
		this.endDateTime = endDateTime;
	}

	@Override
	public String toString() {
		return "TimePeriod{" + "startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + '}';
	}
}
