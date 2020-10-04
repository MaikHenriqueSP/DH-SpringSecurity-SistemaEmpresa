package com.dhspringsecurity.dhspringsecurity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhspringsecurity.dhspringsecurity.model.entity.Funcionario;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
