package com.example.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.control.entity.Carga;
import com.example.control.repository.CargaRepository;

@Service
public class CargaService {
	
	@Autowired
	CargaRepository repository;
	
	
	public List<Carga> findAll(){
		return repository.findAll();
	}
	
	public Carga insert(Carga obj){
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
