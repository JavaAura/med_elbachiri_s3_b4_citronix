package com.citronix.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.citronix.api.dto.get.SaleGetDto;
import com.citronix.api.dto.post.SalePostDto;
import com.citronix.api.entity.Sale;
import com.citronix.api.mapper.use.BaseMapper;
import com.citronix.api.service.ClientService;
import com.citronix.api.service.HarvestService;


@Component
@Mapper(componentModel = "spring", uses = {HarvestService.class, ClientService.class})
public interface SaleMapper extends BaseMapper<Sale, SalePostDto, SaleGetDto> {
    @Mapping(source = "harvestId", target = "harvest")
    @Mapping(source = "clientId", target = "client")
    Sale toEntity(SalePostDto postDto);
}
