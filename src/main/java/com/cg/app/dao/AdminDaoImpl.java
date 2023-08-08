package com.cg.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Movie;
import com.cg.app.entities.Show;
import com.cg.app.entities.Theatre;
import com.cg.app.exceptions.UserException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
	@PersistenceContext
	EntityManager manager;
	
	public static int flag=0;

	@Override
	public boolean addShowToTheatre(Integer showId, Integer theatreId) {
		Theatre theatre=manager.find(Theatre.class, theatreId);
		Show show= manager.find(Show.class, showId);
		
		if(theatre==null || show==null) {
			System.out.println("Theatre not found !!");
			return false;
		}
		else {
			show.setTheatre(theatre);
			return true;
		}
	}

	@Override
	public Admin validateAdminLogin(String username, String userPass) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin save(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin find(Integer adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> findAll(){
		
	}
	@Override
	public boolean addMovieToTheatre(Integer movieId, Integer showId, Integer theatreId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin remove(Integer adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTheatreByMovieId(Integer movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getReleaseDate(Integer movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setShowStatus(Integer movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
