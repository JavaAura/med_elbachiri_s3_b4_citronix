package com.citronix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.entity.Field;
import com.citronix.api.exception.ElementDuplicationException;
import com.citronix.api.exception.ElementNotFoundException;
import com.citronix.api.exception.InvalidDataException;
import com.citronix.api.mapper.FieldMapper;
import com.citronix.api.repository.FieldRepository;
import com.citronix.api.service.FieldService;
import com.citronix.api.validation.FieldValidator;

@Service
public class FieldServiceImpl implements FieldService {
	@Autowired
	FieldRepository repository;
	@Autowired
	FieldMapper mapper;
	@Autowired
	FieldValidator fieldValidator;

	@Override
	public List<FieldGetDto> getAll(Integer page) {
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Field> fields = repository.findAll(pageable).getContent();
		return fields.stream().map(field -> mapper.toDto(field)).collect(Collectors.toList());
	}

	@Override
	public FieldGetDto findById(Long id) {
		return repository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ElementNotFoundException(Field.class, id));
	}

	@Override
	public FieldGetDto add(FieldPostDto dto) {
		boolean fieldExist = repository.existsByNameAndAreaM2(dto.getName(), dto.getAreaM2());
		if (!fieldExist) {
			Field f = mapper.toEntity(dto);
			if (f.getFarm().getFieldsCount() < 10) {
				if (fieldValidator.isFieldAreaLessHalfFarmArea(f.getAreaM2(), f.getFarm().getAreaM2())) {
					if (fieldValidator.doesFieldFitInFarm(f.getAreaM2(), f.getFarm().getAreaM2(),
							f.getFarm().getTotalFieldsArea())) {
						return mapper.toDto(repository.save(mapper.toEntity(dto)));
					} else {
						throw new InvalidDataException(
								"Field area does not fit in the farm (farm does not have much empty area, '"
										+ (f.getFarm().getAreaM2() - f.getFarm().getTotalFieldsArea()) + "' left.).");
					}
				} else {
					throw new InvalidDataException("Field area is over the half area of the farm.");
				}
			} else {
				throw new InvalidDataException("Farm can not have more than 10 fields");
			}
		} else {
			throw new ElementDuplicationException();
		}
	}

	@Override
	public FieldGetDto update(Long id, FieldPostDto dto) {
		findById(id);
		dto.setId(id);
		Field field = mapper.toEntity(dto);
		if (field.getAreaM2() != null
				&& !fieldValidator.isFieldAreaLessHalfFarmArea(field.getAreaM2(), field.getFarm().getAreaM2())
				&& !fieldValidator.doesFieldFitInFarm(field.getAreaM2(), field.getFarm().getAreaM2(),
						field.getFarm().getTotalFieldsArea())) {
			throw new InvalidDataException("Invalid field area.");
		}

		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	// used by field mapper
	@Override
	public Field getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(Field.class, id));
	}
}
