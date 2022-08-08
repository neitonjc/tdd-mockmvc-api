package com.example.tdd.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.tdd.model.Genero;

public class PessoaDTO {
	
	private Integer cod;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)	
	private Genero genero;



	public PessoaDTO(Integer cod, @NotNull String nome, @NotNull @Email String email,
			@NotNull Genero genero) {
		this.cod = cod;
		this.nome = nome;
		this.email = email;
		this.genero = genero;
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

}
