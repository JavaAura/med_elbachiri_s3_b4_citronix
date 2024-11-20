package com.citronix.api.entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @Column(name = "quantity_kg")
    private Double quantityKg;

    @Column(name = "unit_price")
    private Double unitPrice;
    
    @OneToOne
    @NotNull(message = "harvest is required")
    private Harvest harvest;

    @ManyToOne
    @NotNull(message = "must be sold to a client")
    private Client client;
}
