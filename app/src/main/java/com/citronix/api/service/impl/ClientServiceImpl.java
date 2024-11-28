package com.citronix.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.ClientGetDto;
import com.citronix.api.dto.post.ClientPostDto;
import com.citronix.api.entity.Client;
import com.citronix.api.exception.ElementDuplicationException;
import com.citronix.api.exception.ElementNotFoundException;
import com.citronix.api.mapper.ClientMapper;
import com.citronix.api.repository.ClientRepository;
import com.citronix.api.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository repository;
	@Autowired
	ClientMapper mapper;

	@Override
	public List<ClientGetDto> getAll(Integer page) {
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Client> clients = repository.findAll();

		return clients.stream().map(client -> mapper.toDto(client)).collect(Collectors.toList());
	}

	@Override
	public ClientGetDto findById(Long id) {
		return repository.findById(id).map(mapper::toDto)
				.orElseThrow(() -> new ElementNotFoundException(Client.class, id));
	}

	@Override
	public ClientGetDto add(ClientPostDto dto) {
		Client findClient = repository.findByNameAndPhoneAndEmail(dto.getName(), dto.getPhone(), dto.getEmail());
		if (findClient == null) {
			return mapper.toDto(repository.save(mapper.toEntity(dto)));
		} else {
			throw new ElementDuplicationException();
		}
	}

	@Override
	public ClientGetDto update(Long id, ClientPostDto postDto) {
		findById(id);
		postDto.setId(id);
		return mapper.toDto(repository.save(mapper.toEntity(postDto)));
	}

	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	@Override
	public Client getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(Client.class, id));
	}
}
