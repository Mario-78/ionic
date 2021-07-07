package com.mario.testProject.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.testProject.domain.Produto;
import com.mario.testProject.dto.ProdutoDTO;
import com.mario.testProject.servisces.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nameDecoded = URL.decodeParam(name);
		List<Integer> ids = URL.decodeIntList1(categorias);
		Page<Produto> list = service.search(nameDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}*/

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categorias") Integer[] categorias) {

		List<Integer> listCategorieIds = Objects.nonNull(categorias) ? Arrays.asList(categorias): Collections.emptyList();

		Page<ProdutoDTO> categoriasDto = service.search(name, listCategorieIds, page, linesPerPage, orderBy, direction).map(ProdutoDTO::new);

		return ResponseEntity.ok().body(categoriasDto);
	}

}
