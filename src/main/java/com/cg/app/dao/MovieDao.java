package com.cg.app.dao;

import java.util.List;

import com.cg.app.entities.Movie;

public interface MovieDao {
	public Movie save(Movie novie);
	public List<Movie> findAll();
	public Movie find(Integer movieId);
	public Movie remove(Integer movieId);
}
