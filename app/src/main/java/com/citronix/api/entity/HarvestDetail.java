package com.citronix.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="harvest_details")
public class HarvestDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "unitQuantityKg is required.")
    @Column(name = "unit_quantity_kg")
    Double unitQuantityKg;

    @ManyToOne
    @JoinColumn(name = "harvest_id", insertable = false, updatable = false)
    Harvest harvest;

    @ManyToOne
    @JoinColumn(name = "tree_id", insertable = false, updatable = false)
    Tree tree;
}
