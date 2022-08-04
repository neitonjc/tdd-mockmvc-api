package com.example.tdd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.tdd.dto.PessoaDTO;
import com.example.tdd.model.Genero;
import com.example.tdd.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PessoaController.class)
class PessoaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PessoaService pessoaService;
	
	private PessoaDTO p;

	@BeforeEach
	public void setup() {
		p = new PessoaDTO(1, "Ze", "ze@ze.com", Genero.MASCULINO, Collections.emptyList());
	}

	@Test
	void returnSuccess_whenFindAllPeople() throws Exception {
		this.mockMvc.perform(get("/pessoa/listar")).andExpect(status().isFound());
	}

	@Test
	void returnFound_whenFindPeopleById() throws Exception {
		this.mockMvc.perform(get("/pessoa/listarPorId")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("cod", "1"))
			.andExpect(status().isFound());
	}
	
	@Test
	void returnCreated_whenInsert() throws Exception {
		this.mockMvc.perform(post("/pessoa/incluir")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(p)))
			.andExpect(status().isCreated());
	}
	
	@Test
	void returnBadRequest_whenInsert() throws Exception {
		p.setEmail("ze.com");
		this.mockMvc.perform(post("/pessoa/incluir")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(p)))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	void returnOk_whenUpdate() throws Exception {
		this.mockMvc.perform(put("/pessoa/editar")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("cod", "1")
				.param("email", "ze1@ze.com"))
			.andExpect(status().isOk());
	}
	
	@Test
	void returnBadRequest_whenUpdate() throws Exception {
		p.setEmail(null);
		this.mockMvc.perform(put("/pessoa/editar")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("cod", String.valueOf(p.getCod()))
				.param("email", p.getEmail()))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void returnOk_whenDelete() throws Exception {
		this.mockMvc.perform(delete("/pessoa/excluir")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("cod", "1"))
		.andExpect(status().isOk());
	}

}
