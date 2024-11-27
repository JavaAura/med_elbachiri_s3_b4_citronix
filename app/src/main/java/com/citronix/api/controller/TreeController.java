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

import com.citronix.api.dto.get.TreeGetDto;
import com.citronix.api.dto.post.TreePostDto;
import com.citronix.api.service.TreeService;

@RestController
@RequestMapping("/api/trees")
public class TreeController {
    @Autowired TreeService service;
   
    @GetMapping
    public List<TreeGetDto> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TreeGetDto get(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public TreeGetDto post(@Valid @RequestBody TreePostDto dto){
        return service.add(dto);
    }

    @PatchMapping("/{id}")
    public TreeGetDto patch(@PathVariable Long id, @RequestBody TreePostDto postDto){
        return service.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
