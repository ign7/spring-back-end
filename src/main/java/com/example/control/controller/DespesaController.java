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
import com.example.control.entity.Despesa;
import com.example.control.repository.CargaRepository;
import com.example.control.repository.EmpresaRepository;
import com.example.control.service.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

	@Autowired
	DespesaService service;

	@Autowired
	CargaRepository cr;

	@Autowired
	EmpresaRepository er;

	@GetMapping
	public ResponseEntity<List<Despesa>> findAll() {
		List<Despesa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/{cargaId}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Despesa> insert(@RequestBody Despesa obj, @PathVariable("cargaId") Long cargaId) {
		Carga p = cr.findById(cargaId).orElseThrow(() -> new IllegalArgumentException("carga não encontrada"));
		obj.setCarga(p);
		p.setDespesa(obj);
		double refeicao=obj.getRefeicao();
		double ajudante= obj.getAjudante();
		double pedagio=obj.getPedagio();
		double total=refeicao+ajudante+pedagio;
		obj.setGastoTotal(total);
		double lucro=p.getValor()-total;
		p.setLucro(lucro);
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")

	public ResponseEntity<Void> Delete(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
