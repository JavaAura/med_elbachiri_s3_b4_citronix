package com.citronix.api.dto.post;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalePostDto {
    Long id;
    @NotNull(message = "saleDate is required")
    LocalDate saleDate;

    @NotNull(message = "unitPrice is required")
    Double unitPrice;
    
    @NotNull(message = "harvestId is required")
    Long harvestId;

    @NotNull(message = "must be sold to a client, 'clientId' missing")
    Long clientId;

}
