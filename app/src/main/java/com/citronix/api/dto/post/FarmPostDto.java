package com.citronix.api.dto.post;


import javax.validation.constraints.*;
import lombok.*;

@Data
@Builder
public class FarmPostDto {
    Long id;

    @NotNull(message = "name is required")
    private String name;
    
    @NotNull(message = "location is required")
    private String location;
    
    @NotNull(message = "areaM2 is required")
    @Min(message = "areaM2 must be at least 1000 m2", value = 1000)
    @Positive(message = "areaM2 must be positive")
    private Double areaM2;

}
