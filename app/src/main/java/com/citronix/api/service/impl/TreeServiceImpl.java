package com.citronix.api.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.TreeGetDto;
import com.citronix.api.dto.post.TreePostDto;
import com.citronix.api.entity.Tree;
import com.citronix.api.exception.*;
import com.citronix.api.mapper.TreeMapper;
import com.citronix.api.repository.TreeRepository;
import com.citronix.api.service.TreeService;
import com.citronix.api.validation.TreeValidator;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired TreeRepository repository;
    @Autowired TreeMapper mapper;
    @Autowired TreeValidator validator;

    public List<TreeGetDto> getAll(){
        // return repository.findAll().stream().map(farm -> mapper.toDto(farm)).collect(Collectors.toList());
        return mapper.toDtos(repository.findAll());
    }

    public TreeGetDto findById(Long id){
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ElementNotFoundException(Tree.class, id));
    }
    public TreeGetDto add(TreePostDto dto){
        // Tree findTree = repository.findByPlantingDateAndFieldId(dto.getPlantingDate(), dto.getFieldId());
        // if (findTree == null) {
            Tree tree = mapper.toEntity(dto);
            if (validator.doesTreeFitInField(tree.getField().getAreaM2(), tree.getField().getTreesCount())) {
                return mapper.toDto(repository.save(tree));
            } else throw new InvalidDataException("Field does not have any more space to add a new tree (only 10 trees per 1000 m2).");
        // } else throw new ElementDuplicationException();
    }

    public TreeGetDto update(Long id, TreePostDto postDto){
        findById(id);
        postDto.setId(id);
        return mapper.toDto(repository.save(mapper.toEntity(postDto)));
    }

    public void delete(Long id){
        findById(id); // will fail if not found
        repository.deleteById(id);
    }
}
