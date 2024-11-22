package com.citronix.api.dto.post;

import javax.validation.constraints.NotNull;


import lombok.*;

@Data
@Builder
public class FieldPostDto {
    Long id;

    @NotNull(message = "name is required")
    String name;

    @NotNull(message = "areaM2 is required")
    Double areaM2;

    @NotNull(message = "must be associated with a farm, 'farmId' missing.")
    Long farmId;
}
