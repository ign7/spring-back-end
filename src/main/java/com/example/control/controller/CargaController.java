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
import com.example.control.entity.Veiculo;
import com.example.control.repository.CargaRepository;
import com.example.control.repository.EmpresaRepository;
import com.example.control.repository.EntregaRepository;
import com.example.control.repository.VeiculoRepository;
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
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<List<Carga>> findAll() {
		List<Carga> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/{empresaId}/{veiculoId}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Carga> insert(@RequestBody Carga obj, @PathVariable("empresaId") Long empresaId, @PathVariable("veiculoId") Long veiculoId) {
	    Empresa p = er.findById(empresaId).orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
	    Veiculo v = vr.findById(veiculoId).orElseThrow(() -> new IllegalArgumentException("veiculo não encontrado"));
	    p.getCargas().add(obj);
	    v.getCargas().add(obj);
	    obj.setCargaVeiculo(v);
	    obj.setEmpresa(p);
	    obj.setNomeEmpresa(p.getNome());	    
	    obj = service.insert(obj);
	    return ResponseEntity.ok().body(obj);
	}
	
	//@PostMapping("/{empresaId}/{entregaId}")	
	//@CrossOrigin("http://localhost:3000")
	//public ResponseEntity<Carga> insertent(@RequestBody Carga obj, @PathVariable("empresaId") Long empresaId, @PathVariable("entregaId") Long entregaId) {
	    //Empresa p = er.findById(empresaId).orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
	    //Entrega v = entr.findById(entregaId).orElseThrow(() -> new IllegalArgumentException("veiculo não encontrado"));
	    //p.getCargas().add(obj);
	    //v.getCargas().add(obj);
	    //obj.setCargaVeiculo(v);
	    //obj.setEmpresa(p);
	    //obj.setNomeEmpresa(p.getNome());	    
	    //obj = service.insert(obj);
	    //return ResponseEntity.ok().body(obj);
	//}
	
	//@PostMapping("/auto/{veiculoId}")	
	//@CrossOrigin("http://localhost:3000")
	//public ResponseEntity<Carga> insertVeiculo(@RequestBody Carga obj, @PathVariable("veiculoId") Long veiculoId) {
	    //Veiculo p = vr.findById(veiculoId).orElseThrow(() -> new IllegalArgumentException("veiculo não encontrado"));
	    //p.getCargas().add(obj);
	    //obj.setCargaVeiculo(p);	 
	    //obj = service.insertVeiculo(obj);
	    //return ResponseEntity.ok().body(obj);
	//}
	
	@DeleteMapping(value="/{id}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
