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

import com.citronix.api.dto.get.SaleGetDto;
import com.citronix.api.dto.post.SalePostDto;
import com.citronix.api.service.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired SaleService service;
   
    @GetMapping
    public List<SaleGetDto> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SaleGetDto get(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public SaleGetDto post(@Valid @RequestBody SalePostDto dto){
        return service.add(dto);
    }

    @PatchMapping("/{id}")
    public SaleGetDto patch(@PathVariable Long id, @RequestBody SalePostDto postDto){
        return service.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
