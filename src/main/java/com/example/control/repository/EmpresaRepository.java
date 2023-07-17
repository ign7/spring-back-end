package com.example.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.control.entity.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}


