package com.citronix.api.service;

import java.util.List;

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.entity.Field;

public interface FieldService {
    List<FieldGetDto> getAll();
    FieldGetDto findById(Long id);
    FieldGetDto add(FieldPostDto dto);
    Field update(Long id, FieldPostDto dto);
    void delete(Long id);
}
