package com.citronix.api.entity;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import com.citronix.api.annotation.PlantingPeriod;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trees")
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "planting_date")
    @NotNull(message = "planting date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PlantingPeriod
    private LocalDate plantingDate;

    @Column(name = "age_at_time_of_planting")
    private int ageAtTimeOfPlanting; // if not provided, means a new in life tree
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    @NotNull(message = "must be associated with a field")
    private Field field;

    @OneToMany(mappedBy = "tree", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HarvestDetail> harvestDetails;

    public int getAge(){
        return Year.now().getValue() - plantingDate.getYear() + ageAtTimeOfPlanting;
    }

    
    public Double getProductivity(){ // returns double representing kg/saison
        int age = getAge();
        if (age < 3) {
            return 2.5;
        } else if (age >= 3 && age <= 10) {
            return 12.0; 
        } else if (age > 10 && age <= 20) {
            return 20.0; 
        } else { return 0.0; } // unproductive
    }
}
