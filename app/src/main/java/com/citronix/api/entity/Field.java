package com.citronix.api.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @NotNull(message = "name is required")
    private String name;
    
    @Column(name = "area_m2")
    @NotNull(message = "areaM2 is required")
    private Double areaM2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    @NotNull(message = "must be associated with a farm")
    private Farm farm;

    @OneToMany(mappedBy = "field")
    private List<Tree> trees;

    @OneToMany(mappedBy = "field")
    private List<Harvest> harvests;
    
}
