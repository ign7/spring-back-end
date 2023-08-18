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

import com.example.control.entity.Manutencao;
import com.example.control.entity.Veiculo;
import com.example.control.repository.ManutencaoRepository;
import com.example.control.repository.VeiculoRepository;
import com.example.control.service.ManutencaoService;


@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

	@Autowired
	ManutencaoService service;
	
	@Autowired
	ManutencaoRepository er;
	
	@Autowired
	VeiculoRepository vr;
	
	

	@GetMapping
	public ResponseEntity<List<Manutencao>> findAll() {
		List<Manutencao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/{veiculoId}")	
	
	public ResponseEntity<Manutencao> insert(@RequestBody Manutencao obj, @PathVariable("veiculoId") Long veiculoId) {
	    Veiculo p = vr.findById(veiculoId).orElseThrow(() -> new IllegalArgumentException("Veiculo não encontrado"));
	    p.getManutencoes().add(obj);
	    obj.setManutencao(p);
	    obj = service.insert(obj);
	    return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
