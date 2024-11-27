package com.citronix.api.entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sale_date")
    @NotNull(message = "saleDate is required")
    private LocalDate saleDate;

    @Column(name = "quantity_kg")
    private Double quantityKg;

    @Column(name = "unit_price")
    @NotNull(message = "unitPrice is required")
    private Double unitPrice;
    
    @NotNull(message = "harvest is required")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @NotNull(message = "must be sold to a client")
    private Client client;
}
