package com.citronix.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.citronix.api.service.FieldService;
import com.citronix.api.dto.get.TreeGetDto;
import com.citronix.api.dto.post.TreePostDto;
import com.citronix.api.entity.Tree;
import com.citronix.api.mapper.use.BaseMapper;


@Mapper(componentModel = "spring", uses = {FieldService.class})
public interface TreeMapper extends BaseMapper<Tree, TreePostDto, TreeGetDto> {
    @Mapping(source = "fieldId", target = "field")
    Tree toEntity(TreePostDto postDto);

    @Mapping(source = "age", target = "age")
    @Mapping(source = "field.id", target = "fieldId")
    @Mapping(source = "productivity", target = "productivityKg")
    TreeGetDto toDto(Tree tree);

    List<TreeGetDto> toDtos(List<Tree> trees);
}