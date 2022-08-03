package com.example.tdd.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd.model.Pet;
import com.example.tdd.repository.PetRepository;

@Service
public class PetService2 {
	
	@Autowired
	PetRepository rep;
	
	public Collection<Pet> findAllPets(){
		return rep.findAll();
	}
	
	public Pet findPetById(Integer cod) {
		return rep.findById(cod).orElse(null);
	}
	
	public Pet save(Pet p) {
		return rep.save(new Pet(null, p.getNome(), p.getDono()));
	}
	
	public void delete(Integer petId) {
		rep.deleteById(petId);
	}

}
