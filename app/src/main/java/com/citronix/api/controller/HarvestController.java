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
import org.springframework.web.bind.annotation.RestController;

import com.citronix.api.dto.get.HarvestGetDto;
import com.citronix.api.dto.post.HarvestPostDto;
import com.citronix.api.service.HarvestService;

@RestController
@RequestMapping("/api/harvests")
public class HarvestController {
    
    @Autowired HarvestService service;
   
    @GetMapping
    public List<HarvestGetDto> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HarvestGetDto get(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public HarvestGetDto post(@Valid @RequestBody HarvestPostDto dto){
        return service.add(dto);
    }

    @PatchMapping("/{id}")
    public HarvestGetDto patch(@PathVariable Long id, @RequestBody HarvestPostDto postDto){
        return service.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
