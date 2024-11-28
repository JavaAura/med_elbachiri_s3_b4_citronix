package com.citronix.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.SaleGetDto;
import com.citronix.api.dto.post.SalePostDto;

@Service
public interface SaleService {
	List<SaleGetDto> getAll(Integer page);

	SaleGetDto findById(Long id);

	SaleGetDto add(SalePostDto dto);

	SaleGetDto update(Long id, SalePostDto dto);

	void delete(Long id);
}
