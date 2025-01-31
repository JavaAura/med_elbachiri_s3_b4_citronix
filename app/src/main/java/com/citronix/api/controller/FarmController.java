package com.citronix.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citronix.api.dto.get.FarmGetDto;
import com.citronix.api.dto.post.FarmPostDto;
import com.citronix.api.service.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

	@Autowired
	FarmService service;

	@GetMapping
	public List<FarmGetDto> all(@RequestParam(name = "page", defaultValue = "0") Integer page) {
		return service.getAll(page);
	}

	@GetMapping("/{id}")
	public FarmGetDto get(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public FarmGetDto post(@Valid @RequestBody FarmPostDto dto) {
		return service.add(dto);
	}

	@PatchMapping("/{id}")
	public FarmGetDto patch(@Valid @PathVariable Long id, @RequestBody FarmPostDto postDto) {
		return service.update(id, postDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
