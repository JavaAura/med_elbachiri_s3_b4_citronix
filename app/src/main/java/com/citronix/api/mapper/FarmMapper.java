package com.citronix.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.citronix.api.service.FarmService;
import com.citronix.api.dto.get.FarmGetDto;
import com.citronix.api.dto.post.FarmPostDto;
import com.citronix.api.entity.Farm;
import com.citronix.api.mapper.use.BaseMapper;



@Mapper(componentModel = "spring", uses = {FarmService.class})
public interface FarmMapper extends BaseMapper<Farm, FarmPostDto, FarmGetDto> {
    @Mapping(source = "fields", target = "fields")
    @Mapping(source = "fieldsCount", target = "numberOfFields")
    // @Mapping(source = "java(farm.getAreaM2() - farm.getTotalFieldsArea())", target = "areaLeft")
    FarmGetDto toDto(Farm farm);
}
