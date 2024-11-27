package com.citronix.api.validation;

import org.springframework.stereotype.Component;

@Component
public class FieldValidator {
    public boolean isFieldAreaLessHalfFarmArea(Double fieldArea, Double farmArea){
        if (fieldArea == null || farmArea == null) {
            return false;
        }
        return fieldArea <= (farmArea / 2);
    }
    public boolean doesFieldFitInFarm(Double fieldArea, Double farmArea, Double totalFieldsArea){
        if (fieldArea == null || farmArea == null || totalFieldsArea == null) {
            return false;
        }
        return fieldArea <= (farmArea - totalFieldsArea);
    }
}
