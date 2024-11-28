package com.citronix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.citronix.api.entity.HarvestDetail;

@Repository
public interface HarvestDetailRepository extends JpaRepository<HarvestDetail, Long> {
}
