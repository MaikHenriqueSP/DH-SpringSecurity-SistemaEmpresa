package com.dhspringsecurity.dhspringsecurity.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.dhspringsecurity.dhspringsecurity.model.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
