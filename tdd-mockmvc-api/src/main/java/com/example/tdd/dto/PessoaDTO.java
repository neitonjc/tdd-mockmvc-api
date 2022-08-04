package com.example.tdd.dto;

import java.util.Collection;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.tdd.model.Genero;
import com.example.tdd.model.Pet;

public class PessoaDTO {
	
	@NotNull
	private Integer cod;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	private Collection<Pet> pets;

	public PessoaDTO(@NotNull Integer cod, @NotNull String nome, @NotNull @Email String email, @NotNull Genero genero,
			Collection<Pet> pets) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.email = email;
		this.genero = genero;
		this.pets = pets;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Collection<Pet> getPets() {
		return pets;
	}

	public void setPets(Collection<Pet> pets) {
		this.pets = pets;
	}

	

}
