package com.citronix.api.validation;

import org.springframework.stereotype.Component;

@Component
public class TreeValidator {
    public boolean doesTreeFitInField(Double fieldArea, int fieldTreesCount){
        return fieldTreesCount < (fieldArea / 100);
    }
}
