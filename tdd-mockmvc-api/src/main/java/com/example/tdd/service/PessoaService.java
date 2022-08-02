package com.example.tdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd.model.Pessoa;
import com.example.tdd.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository rep;
	
	public List<Pessoa> findAllPeople(){
		return rep.findAll();
	}
	
	public Pessoa findPeopleById(Integer cod) {
		return rep.findById(cod).orElse(null);
	}
	
	public Pessoa save(Pessoa p) {
		return rep.save(p);
	}
	
	public Pessoa updateEmail(Integer peopleId, String email) {
		Pessoa p = rep.findById(peopleId).get();
		p.setEmail(email);
		rep.save(p);
		return rep.save(p);
	}
	
	public void delete(Integer peopleId) {
		rep.deleteById(peopleId);
	}

}
