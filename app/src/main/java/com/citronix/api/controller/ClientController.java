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

import com.citronix.api.dto.get.ClientGetDto;
import com.citronix.api.dto.post.ClientPostDto;
import com.citronix.api.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired ClientService service;
   
    @GetMapping
    public List<ClientGetDto> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ClientGetDto get(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ClientGetDto post(@Valid @RequestBody ClientPostDto dto){
        return service.add(dto);
    }

    @PatchMapping("/{id}")
    public ClientGetDto patch(@Valid @PathVariable Long id, @RequestBody ClientPostDto postDto){
        return service.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
