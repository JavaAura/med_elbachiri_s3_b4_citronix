package com.citronix.api.validation;

import java.time.LocalDate;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.citronix.api.annotation.PlantingPeriod;

public class PlantingPeriodValidator implements ConstraintValidator<PlantingPeriod, LocalDate> {
    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        int month = date.getMonthValue();
        return month <= 5 && month >= 3;
    }
}
