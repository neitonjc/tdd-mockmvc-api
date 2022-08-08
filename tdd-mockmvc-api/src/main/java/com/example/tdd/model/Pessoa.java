package com.example.tdd.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
public class Pessoa {
	
	@Id
	@Column(name="COD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@OneToMany(mappedBy = "dono")
	private Collection<Pet> pets;

	public Pessoa() {
		super();
	}

	public Pessoa(Integer cod, String nome, String email, Genero genero, Collection<Pet> pets) {
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
