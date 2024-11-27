package com.citronix.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.entity.Field;
import com.citronix.api.mapper.use.BaseMapper;
import com.citronix.api.service.FarmService;


@Mapper(componentModel = "spring", uses = {FarmService.class})
public interface FieldMapper extends BaseMapper<Field, FieldPostDto, FieldGetDto> {

    @Mapping(source = "farmId", target = "farm")
    Field toEntity(FieldPostDto postDto);

    @Mapping(source = "farm.id", target = "farmId")
    @Mapping(source = "trees", target = "trees")
    @Mapping(source = "treesCount", target = "numberOfTrees")
    @Mapping(source = "harvestsCount", target = "harvestTimes")
    @Mapping(source = "harvests", target = "harvests")
    FieldGetDto toDto(Field field);

    Field toEntity(FieldGetDto getDto);
}
