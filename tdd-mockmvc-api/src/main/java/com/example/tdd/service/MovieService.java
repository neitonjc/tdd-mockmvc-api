package com.example.tdd.service;

import org.springframework.stereotype.Service;

import com.example.tdd.model.Movie;

@Service
public class MovieService {
	
	public Movie getMovie(Long id) {
		if (id > 10)
			return null;
		
		return new Movie(id, "O Poderoso Chefão", "Filme foda");
	}

}
