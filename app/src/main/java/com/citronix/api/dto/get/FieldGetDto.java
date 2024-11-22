package com.citronix.api.dto.get;
import lombok.*;

@Data
@Builder
public class FieldGetDto {
   Long id;
   String name;
   Double areaM2;
   Long farmId;
   int numberOfTrees;
   int harvestTimes;
}
