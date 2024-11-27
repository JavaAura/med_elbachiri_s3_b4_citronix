package com.citronix.api.dto.post;

import javax.validation.constraints.*;
import lombok.*;

@Data
@Builder
public class FarmPostDto {
    Long id;

    @NotNull(message = "name is required")
    String name;
    
    @NotNull(message = "location is required")
    String location;
    
    @NotNull(message = "areaM2 is required")
    @Min(value = 2000, message = "areaM2 must be at least 2000 m2")
    @Positive(message = "areaM2 must be positive")
    Double areaM2;
}
