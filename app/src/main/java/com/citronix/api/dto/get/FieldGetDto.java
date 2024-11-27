package com.citronix.api.dto.get;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Data
@Builder
public class FieldGetDto {
   Long id;
   LocalDate createdAt;
   String name;
   Double areaM2;
   Long farmId;
   int numberOfTrees;
   int harvestTimes;
   List<TreeGetDto> trees;
   List<HarvestGetDto> harvests;
}
