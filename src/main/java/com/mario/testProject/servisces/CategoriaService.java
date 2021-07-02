package com.mario.testProject.servisces;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.testProject.domain.Categoria;
import com.mario.testProject.repositores.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj;
		
	}

}
