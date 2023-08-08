package com.cg.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.entities.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository("movieDao")
public class MovieDaoImpl implements MovieDao {
	@PersistenceContext
	EntityManager manager;
	private static int flag = 1;

	@Transactional
	public Movie save(Movie movie) {
		manager.persist(movie);
		movie.setFlag(0);
		return movie;
	}

	public List<Movie> findAll() {
		Query query = manager.createQuery("FROM Movie");
		List<Movie> movieList = query.getResultList();
		if (movieList.isEmpty()) {
			System.out.println("No movies in the database.");
			return null;
		} else {
			return movieList;
		}
	}

	public Movie find(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie == null) {
			System.out.println("Movie not found!!");
			return null;
		} else {
			return movie;
		}
	}

	@Transactional
	public Movie remove(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		flag = 1;
		System.out.println("Movie has been removed");
		return movie;

	}

}
