package com.example.control.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.control.entity.Empresa;
import com.example.control.entity.Veiculo;
import com.example.control.repository.EmpresaRepository;
import com.example.control.repository.VeiculoRepository;
import com.example.control.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	EmpresaService service;
	
	@Autowired
	EmpresaRepository er;
	
	@Autowired
	VeiculoRepository vr;
	
	

	@GetMapping
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<List<Empresa>> findAll() {
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/{veiculoId}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Empresa> insert(@RequestBody Empresa obj, @PathVariable("veiculoId") Long veiculoId) {
	    Veiculo p = vr.findById(veiculoId).orElseThrow(() -> new IllegalArgumentException("Veiculo não encontrado"));
	    p.getEmpresas().add(obj);
	    obj.setVeiculo(p);
	    obj = service.insert(obj);
	    return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Empresa> insertEmpresa(@RequestBody Empresa obj){
		obj  = service.insert(obj);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); 
	}
	
	@DeleteMapping(value="/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
