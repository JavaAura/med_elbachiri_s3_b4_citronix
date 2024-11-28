package com.citronix.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.ClientGetDto;
import com.citronix.api.dto.post.ClientPostDto;
import com.citronix.api.entity.Client;

@Service
public interface ClientService {
	List<ClientGetDto> getAll(Integer page);

	ClientGetDto findById(Long id);

	ClientGetDto add(ClientPostDto dto);

	ClientGetDto update(Long id, ClientPostDto dto);

	void delete(Long id);

	Client getById(Long id);
}
