package com.citronix.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.citronix.api.service.FieldService;
import com.citronix.api.dto.get.HarvestGetDto;
import com.citronix.api.dto.post.HarvestPostDto;
import com.citronix.api.entity.Harvest;
import com.citronix.api.mapper.use.BaseMapper;



@Mapper(componentModel = "spring", uses = {FieldService.class})
public interface HarvestMapper extends BaseMapper<Harvest, HarvestPostDto, HarvestGetDto> {
    @Mapping(source = "fieldId", target = "field")
    Harvest toEntity(HarvestPostDto postDto);

    // @Mapping(source = "quantityKg", target = "quantityKg")
    @Mapping(source = "field.id", target = "fieldId")
    @Mapping(source = "sale.id", target = "saleId")
    HarvestGetDto toDto(Harvest harvest);

    Harvest toEntity(HarvestGetDto getDto);

    List<HarvestGetDto> toDtos(List<Harvest> harvests);
}
