package com.citronix.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.HarvestGetDto;
import com.citronix.api.dto.post.HarvestPostDto;
import com.citronix.api.entity.Harvest;

@Service
public interface HarvestService {
	List<HarvestGetDto> getAll(Integer page);

	HarvestGetDto findById(Long id);

	HarvestGetDto add(HarvestPostDto dto);

	HarvestGetDto update(Long id, HarvestPostDto dto);

	void delete(Long id);

	Harvest getById(Long id);
}
