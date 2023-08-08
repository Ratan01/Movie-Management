package com.cg.app.dao;

import java.util.Date;
import java.util.List;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Movie;
import com.cg.app.exceptions.UserException;

public interface AdminDao {
	public boolean addShowToTheatre(Integer showId, Integer theatreId);
	public Admin validateAdminLogin(String  username, String userPass) throws UserException;
	public Admin save(Admin admin);
	public Admin find(Integer adminId);
	public List<Admin> findAll();
	public boolean addMovieToTheatre(Integer movieId, Integer showId, Integer theatreId);
	public Admin remove(Integer adminId);
	public List<Movie> getMovies();
	public List<String> getTheatreByMovieId(Integer movieId);
	Date getReleaseDate(Integer movieId);
	public Boolean setShowStatus(Integer movieId);
}
