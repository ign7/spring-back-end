package com.example.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.control.entity.Entrega;
import com.example.control.repository.EntregaRepository;
@Service
public class EntregaService {
	
	
	@Autowired
	EntregaRepository repository;
	
	
	public List<Entrega> findAll(){
		return repository.findAll();
	}
	
	public Entrega insert(Entrega obj){
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
