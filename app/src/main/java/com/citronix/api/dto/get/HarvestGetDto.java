package com.citronix.api.dto.get;

import java.time.LocalDate;

import com.citronix.api.entity.enums.Season;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HarvestGetDto {
    Long id;
    LocalDate harvestDate;
    Season season;
    int harvestYear;
    Long fieldId;
    Long saleId;
    Double quantityKg;
}
