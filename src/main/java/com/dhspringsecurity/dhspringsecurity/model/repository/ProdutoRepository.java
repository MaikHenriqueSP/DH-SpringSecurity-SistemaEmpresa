package com.dhspringsecurity.dhspringsecurity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhspringsecurity.dhspringsecurity.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
