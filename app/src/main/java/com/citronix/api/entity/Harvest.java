package com.citronix.api.entity;

import com.citronix.api.entity.enums.Season;

import java.time.*;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "harvest_date")
    @NotNull(message = "harvestDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate harvestDate;

    @Enumerated(EnumType.STRING)
    private Season season;

    @Column(name = "harvest_year") // 'year' is ordered by db
    private Integer harvestYear;

    @Column(name = "quantity_kg")
    private Double quantityKg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    @NotNull(message = "must be associated with a 'field'")
    private Field field;

    @OneToOne(mappedBy = "harvest")
    private Sale sale;

    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HarvestDetail> harvestDetails;

    public Double figureOutQuantityKg() {
        return field.getTrees().stream().mapToDouble(tree -> tree.getProductivity()).sum();
    }
}
