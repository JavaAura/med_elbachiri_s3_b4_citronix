package com.citronix.api.entity;

import com.citronix.api.entity.enums.Saison;

import java.time.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "harvest_date")
    @NotNull(message = "harvestDate is required")
    private LocalDate harvestDate;

    private Saison saison;
    private int year;

    @ManyToOne
    @NotNull(message = "must be associated with a 'field'")
    private Field field;

    @OneToOne
    private Sale sale;

    public Double getQuantityKg() {
        return field.getTrees().stream().mapToDouble(tree -> tree.getProductivity()).sum();
    }
}
