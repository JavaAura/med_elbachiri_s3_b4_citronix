package com.citronix.api.dto.post;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPostDto {
    Long id;

    @NotNull(message = "name is required")
    String name;
    
    @NotNull(message = "phone is required")
    String phone;
    
    @NotNull(message = "email is required")
    String email; 
}
