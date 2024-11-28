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

import com.citronix.api.dto.get.FieldGetDto;
import com.citronix.api.dto.post.FieldPostDto;
import com.citronix.api.service.FieldService;

@RestController
@RequestMapping("/api/fields")
public class FieldController {

	@Autowired
	FieldService service;

	@GetMapping
	public List<FieldGetDto> all(@RequestParam(name = "page", defaultValue = "0") Integer page) {
		return service.getAll(page);
	}

	@GetMapping("/{id}")
	public FieldGetDto get(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public FieldGetDto post(@Valid @RequestBody FieldPostDto postDto) {
		return service.add(postDto);
	}

	@PatchMapping("/{id}")
	public FieldGetDto patch(@PathVariable Long id, @RequestBody FieldPostDto postDto) {
		return service.update(id, postDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
