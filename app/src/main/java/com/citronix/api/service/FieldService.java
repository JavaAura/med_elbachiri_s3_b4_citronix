package com.citronix.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.entity.Field;

@Service
public interface FieldService {
	List<FieldGetDto> getAll(Integer page);

	FieldGetDto findById(Long id);

	FieldGetDto add(FieldPostDto dto);

	FieldGetDto update(Long id, FieldPostDto dto);

	void delete(Long id);

	Field getById(Long id);
}
