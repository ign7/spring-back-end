package com.example.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.control.entity.Empresa;
import com.example.control.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository repository;
	
	
	public List<Empresa> findAll(){
		return repository.findAll();
	}
	
	public Empresa insert(Empresa obj){
		return repository.save(obj);
	}
	
	public Empresa insertEmpresa(Empresa obj){
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
