package com.example.tdd.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
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

import com.example.tdd.dto.PessoaDTO;
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
		return new ResponseEntity<>(service.findPeopleById(cod), HttpStatus.FOUND);
	}
	
	@PostMapping(path="/incluir")
	public ResponseEntity<PessoaDTO> incluir(@RequestBody @Valid PessoaDTO pDto){
		Pessoa p = new Pessoa();
		BeanUtils.copyProperties(p, pDto);
		service.save(p);
		
		return new ResponseEntity<>(pDto, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/editar")
	public ResponseEntity<Pessoa> editar(@RequestParam(required = true) Integer cod,
						 @RequestParam(required = true) @NotBlank @Valid @Email String email){
		return new ResponseEntity<>(service.updateEmail(cod, email), HttpStatus.OK);
	}
	
	@DeleteMapping("/excluir")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@RequestParam(required = true) @NotNull Integer cod){
		service.delete(cod);
	}
}
