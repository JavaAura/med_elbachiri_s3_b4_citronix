
package com.citronix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citronix.api.entity.Harvest;
import com.citronix.api.entity.enums.Season;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    Harvest findBySeasonAndHarvestYearAndFieldId(Season season, int harvestYear, Long fieldId);
}
