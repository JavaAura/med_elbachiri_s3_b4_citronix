package com.citronix.api.service.impl;

import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.HarvestGetDto;
import com.citronix.api.dto.post.HarvestPostDto;
import com.citronix.api.entity.Harvest;
import com.citronix.api.exception.ElementNotFoundException;
import com.citronix.api.exception.InvalidDataException;
import com.citronix.api.mapper.HarvestMapper;
import com.citronix.api.repository.HarvestRepository;
import com.citronix.api.service.HarvestService;
import com.citronix.api.validation.HarvestValidator;

@Service
public class HarvestServiceImpl implements HarvestService {
	@Autowired
	HarvestRepository repository;
	@Autowired
	HarvestMapper mapper;
	@Autowired
	HarvestValidator validator;

	@Override
	public List<HarvestGetDto> getAll(Integer page) {
		// return repository.findAll().stream().map(farm ->
		// mapper.toDto(farm)).collect(Collectors.toList());

		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Harvest> harvests = repository.findAll(pageable).getContent();
		return mapper.toDtos(harvests);
	}

	@Override
	public HarvestGetDto findById(Long id) {
		return repository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ElementNotFoundException(Harvest.class, id));
	}


	@Override
	public HarvestGetDto add(HarvestPostDto dto) {
		Harvest findHarvest = repository.findBySeasonAndHarvestYearAndFieldId(
				validator.figureOutSeason(dto.getHarvestDate()), dto.getHarvestDate().getYear(), dto.getFieldId());
		if (findHarvest == null) {
			Harvest harvest = mapper.toEntity(dto);
			harvest.setSeason(validator.figureOutSeason(harvest.getHarvestDate()));
			harvest.setHarvestYear(harvest.getHarvestDate().getYear());
			harvest.setQuantityKg(harvest.figureOutQuantityKg());
			return mapper.toDto(repository.save(harvest));
		} else {
			throw new InvalidDataException("This field was already been harvested in this season in the year.");
		}
	}

    public HarvestGetDto update(Long id, HarvestPostDto postDto){
        findById(id);
        Harvest harvest = mapper.toEntity(postDto);
        harvest.setId(id);
        harvest.setSeason(validator.figureOutSeason(harvest.getHarvestDate()));
        harvest.setHarvestYear(harvest.getHarvestDate().getYear());
        harvest.setQuantityKg(harvest.figureOutQuantityKg());
        // harvest.setSale(harvest.getSale());
        return mapper.toDto(repository.save(harvest));
    }

	@Override
	public void delete(Long id) {
		findById(id); // will fail if not found
		repository.deleteById(id);
	}

	@Override
	public Harvest getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(Harvest.class, id));
	}
}
