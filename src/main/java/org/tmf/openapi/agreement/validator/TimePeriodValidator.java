package org.tmf.openapi.agreement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.tmf.openapi.agreement.domain.TimePeriod;

public class TimePeriodValidator implements ConstraintValidator<ValidTimePeriod, TimePeriod> {
	 
    @Override
    public boolean isValid(TimePeriod timePeriod, ConstraintValidatorContext context) {
    	
		return timePeriod.getStartDateTime().before(timePeriod.getEndDateTime());
    }
 
}