package com.citronix.api.service;

import java.util.List;

import com.citronix.api.dto.get.FarmGetDto;
import com.citronix.api.dto.post.FarmPostDto;
import com.citronix.api.entity.Farm;

public interface FarmService {
	List<FarmGetDto> getAll(Integer page);

	FarmGetDto findById(Long id);

	FarmGetDto add(FarmPostDto dto);

	FarmGetDto update(Long id, FarmPostDto dto);

	void delete(Long id);

	Farm getById(Long id);
}
