package com.example.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tdd.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{
	

}
