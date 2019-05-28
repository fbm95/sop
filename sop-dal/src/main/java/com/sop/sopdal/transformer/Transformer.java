package com.sop.sopdal.transformer;

public interface Transformer<Entity,DTO> {

    Entity toEntity(DTO dto);

    DTO toDTO(Entity entity);
}
