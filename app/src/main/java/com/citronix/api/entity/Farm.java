package com.citronix.api.entity;

import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is required")
    private String name;
    
    @NotNull(message = "location is required")
    private String location;
    
    @Column(name = "area_m2")
    private Double areaM2;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_date")    
    private LocalDate createdDate;

    @OneToMany
    private List<Field> fields;

}
