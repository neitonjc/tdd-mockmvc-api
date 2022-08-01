package com.example.tdd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd.model.Pessoa;
import com.example.tdd.service.PessoaService;

@RestController
@RequestMapping({"/pessoa"})
public class PessoaController {
	
	@Autowired
	PessoaService service;
	
	@GetMapping(path="/listar")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Pessoa> listar(){
		return service.findAllPeople();
	}
	
	@GetMapping(path="/listarPorId")
	public ResponseEntity<Pessoa> listarPorId(@RequestParam(required = true) Integer cod){
		return new ResponseEntity<Pessoa>(service.findPeopleById(cod), HttpStatus.FOUND);
	}
	
	@PostMapping(path="/incluir")
	public ResponseEntity<Pessoa> incluir(@RequestBody @Valid Pessoa pessoa){
		return new ResponseEntity<Pessoa>(service.save(pessoa), HttpStatus.CREATED);
	}
	
	@PutMapping(path="/editar")
	public ResponseEntity<Pessoa> editar(@RequestParam(required = true) Integer cod,
						 @RequestParam(required = true) @Valid String email){
		return new ResponseEntity<Pessoa>(service.updateEmail(cod, email), HttpStatus.OK);
	}
	
	@DeleteMapping("/excluir")
	public void excluir(@RequestParam(required = true) Integer cod){
		service.delete(cod);
	}
}
