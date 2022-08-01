package com.example.tdd.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.tdd.service.PessoaService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class PessoaControllerTest {

	@Autowired
	private PessoaController pessoaController;

	@MockBean
	private PessoaService pessoaService;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(pessoaController);
	}

	@Test
	public void returnSuccess_whenFindAllPeople() {
		RestAssuredMockMvc.given().accept(ContentType.JSON).when().get("/pessoa/listar").then()
				.status(HttpStatus.FOUND);
	}

	@Test
	public void returnSuccess_whenFindPeopleById() {
		RestAssuredMockMvc.given().accept(ContentType.JSON).when().get("/pessoa/listarPorId?cod=1").then()
				.status(HttpStatus.FOUND);
	}

}
