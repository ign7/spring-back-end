package com.example.control.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.control.entity.Veiculo;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	//Optional<Veiculo> finByid(Long id);
}


