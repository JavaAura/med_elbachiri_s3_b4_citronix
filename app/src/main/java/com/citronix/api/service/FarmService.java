package com.citronix.api.service;

import java.util.List;

import com.citronix.api.dto.get.FarmGetDto;
import com.citronix.api.dto.post.FarmPostDto;
import com.citronix.api.entity.Farm;

public interface FarmService {
    List<FarmGetDto> getAll();
    Farm findById(Long id);
    Farm add(FarmPostDto dto);
    Farm update(Long id, FarmPostDto dto);
    void delete(Long id);
}
