package com.citronix.api.mapper.use;

public interface BaseMapper<E, P, G> {
    E toEntity(P dtoPost);
    G toDto(E entity);
}
