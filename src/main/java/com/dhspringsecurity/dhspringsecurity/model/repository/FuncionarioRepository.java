package com.dhspringsecurity.dhspringsecurity.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhspringsecurity.dhspringsecurity.model.entity.Funcionario;
@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

}
