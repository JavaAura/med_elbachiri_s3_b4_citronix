package com.citronix.api.validation;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.citronix.api.entity.enums.Season;

@Component
public class HarvestValidator {

    public Season figureOutSeason(LocalDate harvestDate) {
        if (harvestDate == null) {
            return null;
        }
        int harvestMonth = harvestDate.getMonthValue();

        if (harvestMonth == 12 | harvestMonth < 3 ) {
            return Season.WINTER;
        } else if (harvestMonth >= 3 && harvestMonth <= 5) {
            return Season.SPRING;
        } else if (harvestMonth >= 6 && harvestMonth <= 8) {
            return Season.SUMMER;
        } else { //if (harvestMonth >= 9 && harvestMonth <= 11) 
            return Season.AUTUMN;
        }
    }
}
