package com.mario.testProject.repositores;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mario.testProject.domain.Categoria;
import com.mario.testProject.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Transactional(readOnly=true)
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:name% AND cat IN :categorias")
	Page<Produto> findDistinctByNameIgnoreCaseContainingAndCategoriasIn(@Param("name") String name, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	
}	
