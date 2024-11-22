package com.citronix.api.mapper.use;


import org.mapstruct.Mapper;

// @Mapper(componentModel = "spring")
public interface BaseMapper<E, P, G> {
    E toEntity(P dtoPost);
    G toDto(E entity);
}
