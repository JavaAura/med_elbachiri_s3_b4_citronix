package com.citronix.api.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citronix.api.entity.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
    Tree findByPlantingDateAndFieldId(LocalDate plantingDate, Long fieldId);
}
