package com.example.control.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.control.entity.Veiculo;
import com.example.control.service.VeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/veiculos")

public class VeiculoController {

	@Autowired
	VeiculoService veiculoService;

	@GetMapping
	@CrossOrigin("https://front-control-git-main-ign7.vercel.app")
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> list = veiculoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value="/{id}")
	@CrossOrigin("http://localhost:3000")
	public  ResponseEntity<Optional<Veiculo>> findByid(@PathVariable Long id){		
		Optional<Veiculo> v=veiculoService.findbyid(id);
		return ResponseEntity.ok().body(v);
	}
	
	
	
	@PostMapping(consumes = "multipart/form-data")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Veiculo> insert(@RequestParam("veiculo") String veiculoj, @RequestParam("imagem") MultipartFile imagem ) throws JsonMappingException, JsonProcessingException {
	    Veiculo veiculo = new ObjectMapper().readValue(veiculoj, Veiculo.class);

	    if (!imagem.isEmpty()) {
	        String nomeArquivo = imagem.getOriginalFilename();
	        String diretorio = "C:\\Users\\User\\front-end-control\\src\\images"; 

	        try {
	            imagem.transferTo(new File(diretorio, nomeArquivo));
	            System.out.println("nome arquivo"+nomeArquivo+" diretorio :"+diretorio);
	            veiculo.setImagem(nomeArquivo);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    Veiculo savedVeiculo = veiculoService.insert(veiculo);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedVeiculo.getId()).toUri();
	    return ResponseEntity.created(uri).body(savedVeiculo);
	}

	
	
	
	

	
	@DeleteMapping(value="/{id}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> Delete(@PathVariable long id){
		veiculoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
