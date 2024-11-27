package com.citronix.api.dto.get;
import java.time.LocalDate;

import lombok.*;

@Data
@Builder
public class SaleGetDto {
   Long id;
   LocalDate saleDate;
   Double quantityKg;
   Double unitPrice;
   Long harvestId;
   Long clientId;
}
