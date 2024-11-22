package com.citronix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.citronix.api.entity.Field;


@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
    boolean existsByNameAndAreaM2(String name, Double areaM2);   
}
