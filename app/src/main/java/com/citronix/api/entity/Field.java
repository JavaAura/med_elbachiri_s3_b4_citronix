package com.citronix.api.entity;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(name = "area_m2")
    private Double areaM2;

    @ManyToOne
    @NotNull(message = "must be associated with a farm")
    private Farm farm;

    @OneToMany
    private List<Tree> trees;

    @OneToMany
    private List<Harvest> harvests;
}
