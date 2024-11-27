package com.citronix.api.dto.post;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import com.citronix.api.annotation.PlantingPeriod;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TreePostDto {
    Long id;

    @PlantingPeriod
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "planting date is required")
    LocalDate plantingDate;

    int ageAtTimeOfPlanting; // if not provided, this means a new in life tree
    
    @NotNull(message = "must be associated with a field")
    Long fieldId;
}
