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
import com.example.control.entity.Entrega;
import com.example.control.entity.Veiculo;
import com.example.control.repository.CargaRepository;
import com.example.control.repository.EmpresaRepository;
import com.example.control.repository.EntregaRepository;
import com.example.control.repository.VeiculoRepository;
import com.example.control.util.CorsConfiguration;
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
	
	@Autowired
	VeiculoRepository vr;
	
	@Autowired
	EntregaRepository entr;
	

	@GetMapping	
	public ResponseEntity<List<Carga>> findAll() {
		List<Carga> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	//@PostMapping("/{empresaId}/{veiculoId}")	
	//
	//public ResponseEntity<Carga> insert(@RequestBody Carga obj, @PathVariable("empresaId") Long empresaId, @PathVariable("veiculoId") Long veiculoId) {
	    //Empresa p = er.findById(empresaId).orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
	    //Veiculo v = vr.findById(veiculoId).orElseThrow(() -> new IllegalArgumentException("veiculo não encontrado"));
	    //p.getCargas().add(obj);
	    //v.getCargas().add(obj);
	    //obj.setCargaVeiculo(v);
	    //obj.setEmpresa(p);
	    //obj.setNomeEmpresa(p.getNome());	    
	    //obj = service.insert(obj);
	    //return ResponseEntity.ok().body(obj);
	//}
	
	@PostMapping("/{entregaid}")	
	public ResponseEntity<Carga> insert(@RequestBody Carga obj,@PathVariable("entregaid") Long entregaid){
		Entrega entrega =entr.findById(entregaid).orElseThrow(()-> new IllegalArgumentException("id entrega nao encontrado"));
		String nomeEmpresa=entrega.getEntregaEmpresa().getNome();
		entrega.getCargas().add(obj);
		obj.setEntregaCarga(entrega);
		obj.setNomeEmpresa(nomeEmpresa);
		
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@DeleteMapping(value="/{id}")		
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
