package com.example.control.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.control.entity.Entrega;
import com.example.control.entity.Veiculo;
import com.example.control.repository.EmpresaRepository;
import com.example.control.repository.VeiculoRepository;
import com.example.control.service.EntregaService;
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	EntregaService service;
	@Autowired
	EmpresaRepository er;
	@Autowired
	VeiculoRepository vr;
	
	
	
	@GetMapping
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<List<Entrega>> findAll() {
		List<Entrega> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	@CrossOrigin("http://localhost:3000")
	public  ResponseEntity<Optional<Entrega>> findByid(@PathVariable Long id){		
		Optional<Entrega> v=service.findbyid(id);
		return ResponseEntity.ok().body(v);
	}

	@PostMapping("/{empresaId}/{veiculoId}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Entrega> insert(@RequestBody Entrega obj, @PathVariable("empresaId") Long empresaId, @PathVariable("veiculoId") Long veiculoId) {
	    Empresa p = er.findById(empresaId).orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
	    Veiculo v = vr.findById(veiculoId).orElseThrow(() -> new IllegalArgumentException("veiculo não encontrado"));
	    p.getEntregas().add(obj);
	    v.getEntregas().add(obj);
	    obj.setEntregaVeiculos(v);
	    obj.setEntregaEmpresa(p);  
	    //obj.getTotal();
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
