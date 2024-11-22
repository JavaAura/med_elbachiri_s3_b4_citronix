package com.citronix.api.entity;

import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @NotNull(message = "name is required")
    private String name;
    
    @NotNull(message = "location is required")
    private String location;
    
    @Column(name = "area_m2")
    @NotNull(message = "areaM2 is required")
    @Min(message = "areaM2 must be at least 1000 m2", value = 1000)
    @Positive(message = "areaM2 must be positive")
    private Double areaM2;

    @OneToMany(mappedBy = "farm")
    private List<Field> fields;

}
