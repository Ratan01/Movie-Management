package com.cg.app.services;

import java.util.List;

import com.cg.app.entities.Movie;

public interface MovieService {
	public Movie save(Movie novie);
	public List<Movie> findAll();
	public Movie find(Integer movieId);
	public Movie remove(Integer movieId);
}
