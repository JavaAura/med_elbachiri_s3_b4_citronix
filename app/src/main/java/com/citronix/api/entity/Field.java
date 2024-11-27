package com.citronix.api.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    @Min(message = "areaM2 must be at least 1000 m2", value = 1000)
    @Positive(message = "areaM2 must be positive")
    private Double areaM2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    @NotNull(message = "must be associated with a farm")
    private Farm farm;

    @OneToMany(mappedBy = "field")
    private List<Tree> trees;

    @OneToMany(mappedBy = "field")
    private List<Harvest> harvests;

    public int getTreesCount(){ return this.trees != null ? this.trees.size() : 0; }
    public int getHarvestsCount(){ return this.harvests != null ? this.harvests.size() : 0; }
    
}
