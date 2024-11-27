package com.citronix.api.dto.get;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Data
public class FarmGetDto {
    Long id;
    LocalDate createdAt;
    String name;
    String location;
    Double areaM2;
    int numberOfFields;
    // int areaLeft;
    List<FieldGetDto> fields;
}
