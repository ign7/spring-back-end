package com.example.control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.control.entity.Carga;
import com.example.control.entity.Empresa;
import com.example.control.repository.CargaRepository;
import com.example.control.repository.EmpresaRepository;
import com.example.control.service.CargaService;

@RestController
@RequestMapping("/cargas")
public class CargaController {

	@Autowired
	CargaService service;
	
	@Autowired
	CargaRepository cr;
	
	@Autowired
	EmpresaRepository er;
	

	@GetMapping
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<List<Carga>> findAll() {
		List<Carga> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/{empresaId}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Carga> insert(@RequestBody Carga obj, @PathVariable("empresaId") Long empresaId) {
	    Empresa p = er.findById(empresaId).orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
	    p.getCargas().add(obj);
	    obj.setEmpresa(p);
	    obj.setNomeEmpresa(p.getNome());
	    obj = service.insert(obj);
	    return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{id}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
