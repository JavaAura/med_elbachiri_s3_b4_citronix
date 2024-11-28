package com.citronix.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citronix.api.dto.get.TreeGetDto;
import com.citronix.api.dto.post.TreePostDto;

@Service
public interface TreeService {
	List<TreeGetDto> getAll(Integer page);

	TreeGetDto findById(Long id);

	TreeGetDto add(TreePostDto dto);

	TreeGetDto update(Long id, TreePostDto dto);

	void delete(Long id);
}
