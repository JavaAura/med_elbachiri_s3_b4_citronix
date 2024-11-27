package com.citronix.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.stereotype.Component;

import com.citronix.api.validation.PlantingPeriodValidator;

@Component
@Documented
@Constraint(validatedBy = PlantingPeriodValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlantingPeriod {
    String message() default "planting can only be between march and may (spring season).";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
