package com.citronix.api.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.HarvestGetDto;
import com.citronix.api.dto.post.HarvestPostDto;
import com.citronix.api.entity.Harvest;
import com.citronix.api.exception.*;
import com.citronix.api.mapper.HarvestMapper;
import com.citronix.api.repository.HarvestRepository;
import com.citronix.api.service.HarvestService;
import com.citronix.api.validation.HarvestValidator;

@Service
public class HarvestServiceImpl implements HarvestService {
    @Autowired HarvestRepository repository;
    @Autowired HarvestMapper mapper;
    @Autowired HarvestValidator validator;

    public List<HarvestGetDto> getAll(){
        // return repository.findAll().stream().map(farm -> mapper.toDto(farm)).collect(Collectors.toList());
        return mapper.toDtos(repository.findAll());
    }

    public HarvestGetDto findById(Long id){
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ElementNotFoundException(Harvest.class, id));
    }
    public HarvestGetDto add(HarvestPostDto dto){
        Harvest findHarvest = repository.findBySeasonAndHarvestYearAndFieldId(validator.figureOutSeason(dto.getHarvestDate()), dto.getHarvestDate().getYear(), dto.getFieldId());
        if (findHarvest == null) {
            Harvest harvest = mapper.toEntity(dto);
            harvest.setSeason(validator.figureOutSeason(harvest.getHarvestDate()));
            harvest.setHarvestYear(harvest.getHarvestDate().getYear());

            return mapper.toDto(repository.save(harvest));
        } else throw new InvalidDataException("This field was already been harvested in this season in the year.");
    }

    public HarvestGetDto update(Long id, HarvestPostDto postDto){
        findById(id);
        postDto.setId(id);
        return mapper.toDto(repository.save(mapper.toEntity(postDto)));
    }

    public void delete(Long id){
        findById(id); // will fail if not found
        repository.deleteById(id);
    }

    public Harvest getById(Long id){
        return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(Harvest.class, id));
    }
}
