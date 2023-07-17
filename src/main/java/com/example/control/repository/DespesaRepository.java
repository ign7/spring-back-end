package com.example.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.control.entity.Despesa;


public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}


