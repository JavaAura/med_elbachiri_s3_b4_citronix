package com.citronix.api.entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name required")
    private String name;

    @NotNull(message = "phone required")
    private String phone;

    @NotNull(message = "email required")
    private String email;

    private List<Sale> sales;
}
