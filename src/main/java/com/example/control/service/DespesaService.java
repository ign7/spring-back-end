package com.example.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.control.entity.Despesa;
import com.example.control.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	DespesaRepository repository;
	
	
	public List<Despesa> findAll(){
		return repository.findAll();
	}
	
	public Despesa insert(Despesa obj){
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
