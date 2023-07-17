package com.example.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.control.entity.Manutencao;
import com.example.control.repository.ManutencaoRepository;

@Service
public class ManutencaoService {
	
	@Autowired
	ManutencaoRepository repository;
	
	
	public List<Manutencao> findAll(){
		return repository.findAll();
	}
	
	public Manutencao insert(Manutencao obj){
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
