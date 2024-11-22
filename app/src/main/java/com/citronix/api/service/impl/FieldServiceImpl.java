package com.citronix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.entity.Field;
import com.citronix.api.exception.*;
import com.citronix.api.mapper.FieldMapper;
import com.citronix.api.repository.FieldRepository;
import com.citronix.api.service.FieldService;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired FieldRepository repository;
    @Autowired FieldMapper mapper;

    public List<FieldGetDto> getAll(){
        return repository.findAll().stream().map(field -> mapper.toDto(field)).collect(Collectors.toList());
    }

    public FieldGetDto findById(Long id){
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ElementNotFoundException(Field.class, id));
    }
    public FieldGetDto add(FieldPostDto dto){
        boolean fieldExist = repository.existsByNameAndAreaM2(dto.getName(), dto.getAreaM2());
        if (!fieldExist) {
            Field f = repository.save(mapper.toEntity(dto));
            return mapper.toDto(f);
        } else throw new ElementDuplicationException();
    }

    public Field update(Long id, FieldPostDto dto){
        findById(id);
        dto.setId(id);

        return repository.save(mapper.toEntity(dto));
    }

    public void delete(Long id){
        // Field findField = findById(id);
        repository.deleteById(id);
    }
}
