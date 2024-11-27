package com.citronix.api.dto.get;
import java.time.LocalDate;

import lombok.*;

@Data
@Builder
public class TreeGetDto {
    Long id;
    LocalDate plantingDate;
    int ageAtTimeOfPlanting;
    int age;
    Long fieldId;
    Double productivityKg;
    // HarvestGetDto harvestDetails;
}
