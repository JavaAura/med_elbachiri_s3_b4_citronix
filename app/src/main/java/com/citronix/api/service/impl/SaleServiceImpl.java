package com.citronix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.SaleGetDto;
import com.citronix.api.dto.post.SalePostDto;
import com.citronix.api.entity.Sale;
import com.citronix.api.exception.ElementNotFoundException;
import com.citronix.api.exception.InvalidDataException;
import com.citronix.api.mapper.SaleMapper;
import com.citronix.api.repository.SaleRepository;
import com.citronix.api.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	SaleRepository repository;
	@Autowired
	SaleMapper mapper;

	@Override
	public List<SaleGetDto> getAll(Integer page) {
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Sale> sales = repository.findAll(pageable).getContent();
		return sales.stream().map(sale -> mapper.toDto(sale)).collect(Collectors.toList());
	}

	@Override
	public SaleGetDto findById(Long id) {
		return repository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ElementNotFoundException(Sale.class, id));
	}

	@Override
	public SaleGetDto add(SalePostDto dto) {
		Sale findSale = repository.findByHarvestId(dto.getHarvestId());
		if (findSale == null) {
			Sale sale = mapper.toEntity(dto);
			sale.setQuantityKg(sale.getHarvest().getQuantityKg());
			return mapper.toDto(repository.save(sale));
		} else {
			throw new InvalidDataException("The harvest was already sold.");
		}
	}

	@Override
	public SaleGetDto update(Long id, SalePostDto postDto) {
		findById(id);
		postDto.setId(id);
		return mapper.toDto(repository.save(mapper.toEntity(postDto)));
	}

	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
