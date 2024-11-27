package com.citronix.api.mapper;

import org.mapstruct.Mapper;

import com.citronix.api.dto.get.ClientGetDto;
import com.citronix.api.dto.post.ClientPostDto;
import com.citronix.api.entity.Client;
import com.citronix.api.mapper.use.BaseMapper;


@Mapper(componentModel = "spring")
public interface ClientMapper extends BaseMapper<Client, ClientPostDto, ClientGetDto> {
}
