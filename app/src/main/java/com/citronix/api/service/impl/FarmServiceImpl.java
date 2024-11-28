package com.citronix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.FarmGetDto;
import com.citronix.api.dto.post.FarmPostDto;
import com.citronix.api.entity.Farm;
import com.citronix.api.exception.ElementDuplicationException;
import com.citronix.api.exception.ElementNotFoundException;
import com.citronix.api.mapper.FarmMapper;
import com.citronix.api.repository.FarmRepository;
import com.citronix.api.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService {
	@Autowired
	FarmRepository repository;
	@Autowired
	FarmMapper mapper;

	@Override
	public List<FarmGetDto> getAll(Integer page) {
		int size = 3;
		Pageable pageable = PageRequest.of(page, 3);
		List<Farm> farms = repository.findAll(pageable).getContent();
		return farms.stream().map(farm -> mapper.toDto(farm)).collect(Collectors.toList());
	}

	@Override
	public FarmGetDto findById(Long id) {
		return repository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ElementNotFoundException(Farm.class, id));
	}

	@Override
	public FarmGetDto add(FarmPostDto dto) {
		Farm findFarm = repository.findByNameAndLocationAndAreaM2(dto.getName(), dto.getLocation(), dto.getAreaM2());
		if (findFarm == null) {
			return mapper.toDto(repository.save(mapper.toEntity(dto)));
		} else {
			throw new ElementDuplicationException();
		}
	}

	@Override
	public FarmGetDto update(Long id, FarmPostDto postDto) {
		findById(id);
		postDto.setId(id);
		return mapper.toDto(repository.save(mapper.toEntity(postDto)));
	}

	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	@Override
	public Farm getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(Farm.class, id));
	}
}
