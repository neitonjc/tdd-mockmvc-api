package com.example.tdd.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.tdd.model.Movie;
import com.example.tdd.service.MovieService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class MovieControllerTest {
	
	@Autowired
	private MovieController movieController;
	
	@MockBean
	private MovieService movieService;
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(movieController);
	}
	
	@Test
	public void returnSuccess_whenGetMovie() {
		
		when(movieService.getMovie(1L))
			.thenReturn(new Movie(1l, "O Poderoso Chefão", ""));
		
		RestAssuredMockMvc.given()
				.accept(ContentType.JSON)
			.when()
				.get("/movies/{id}", 1L)
			.then()
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void returnNotFound_whenGetMovie() {
		when(movieService.getMovie(11L))
			.thenReturn(null);
		
		RestAssuredMockMvc.given()
		.accept(ContentType.JSON)
	.when()
		.get("/movies/{id}", 11L)
	.then()
		.statusCode(HttpStatus.NOT_FOUND.value());
		
	}

}
