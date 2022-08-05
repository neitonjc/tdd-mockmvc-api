package com.example.tdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PET")
public class Pet {
	@Id
	@Column(name="COD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	@Column(name="NOME")
	private String nome;
	
	@ManyToOne
    @JoinColumn(name="COD_PESSOA", nullable=false)
	private Pessoa dono;

	public Pet(Integer cod, String nome, Pessoa dono) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.dono = dono;
	}

	public Pet() {
		super();
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

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
}
