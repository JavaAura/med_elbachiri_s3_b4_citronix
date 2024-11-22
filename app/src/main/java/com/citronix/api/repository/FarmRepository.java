package com.citronix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citronix.api.entity.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    Farm findByNameAndLocationAndAreaM2(String name, String location, Double areaM2);   
}
