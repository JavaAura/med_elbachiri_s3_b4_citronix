package com.citronix.api.dto.post;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.*;

@Data
@Builder
public class FieldPostDto {
    Long id;

    @NotNull(message = "name is required")
    String name;

    @NotNull(message = "areaM2 is required")
    @Min(message = "areaM2 must be at least 1000 m2", value = 1000)
    @Positive(message = "areaM2 must be positive")
    Double areaM2;

    @NotNull(message = "must be associated with a farm, 'farmId' missing.")
    Long farmId;
}
