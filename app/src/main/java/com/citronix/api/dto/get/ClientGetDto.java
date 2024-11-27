package com.citronix.api.dto.get;

import java.util.List;

import lombok.*;

@Data
public class ClientGetDto {
    Long id;
    String name;
    String phone;
    String email;
    List<SaleGetDto> sales;
}
