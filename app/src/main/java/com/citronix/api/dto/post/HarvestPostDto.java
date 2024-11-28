package com.citronix.api.dto.post;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;


@Builder
@Data
public class HarvestPostDto {
    Long id;

    @NotNull(message = "harvestDate is required")
    LocalDate harvestDate;

    @NotNull(message = "must be associated with a field, 'fieldId' is required")    
    Long fieldId;
}
