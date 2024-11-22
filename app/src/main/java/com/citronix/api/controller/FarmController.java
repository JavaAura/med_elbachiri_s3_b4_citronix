package com.citronix.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citronix.api.dto.get.FarmGetDto;
import com.citronix.api.dto.post.FarmPostDto;
import com.citronix.api.entity.Farm;
import com.citronix.api.service.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    @Autowired FarmService service;

    @GetMapping
    public List<FarmGetDto> all(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Farm get(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Farm post(@Valid @RequestBody FarmPostDto dto){
        return service.add(dto);
    }

    @PatchMapping("/{id}")
    public Farm patch(@Valid @PathVariable Long id, @RequestBody FarmPostDto postDto){
        return service.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
