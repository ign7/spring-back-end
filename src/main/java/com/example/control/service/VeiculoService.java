package com.example.control.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.control.entity.Veiculo;
import com.example.control.repository.VeiculoRepository;


@Service
public class VeiculoService {
	
	@Autowired
	VeiculoRepository repository;
	
	
	public List<Veiculo> findAll(){
		return repository.findAll();
	}
	
	public Optional<Veiculo> findbyid(Long id) {
		 Optional <Veiculo> obj = repository.findById(id);
		 return obj;
	}
	
	public Veiculo insert(Veiculo obj){
		
		return repository.save(obj);
	}
	
	public void  delete(long obj) {
		try {
			repository.deleteById(obj);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

}
