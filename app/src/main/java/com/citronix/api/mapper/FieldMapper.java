package com.citronix.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.entity.Field;
import com.citronix.api.mapper.use.BaseMapper;
import com.citronix.api.service.FarmService;

@Mapper(componentModel = "spring", uses = {FarmService.class})
public interface FieldMapper {

    @Mapping(source = "farmId", target = "farm")
    Field toEntity(FieldPostDto postDto);

    @Mapping(source = "farm.id", target = "farmId")
    FieldGetDto toDto(Field field);

    Field toEntity(FieldGetDto getDto);
}
