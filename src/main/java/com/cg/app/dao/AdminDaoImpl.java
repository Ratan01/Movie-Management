package com.cg.app.dao;

import java.util.ArrayList;
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
		Theatre theatre = manager.find(Theatre.class, theatreId);
		Show show = manager.find(Show.class, showId);
		
		if (theatre == null || show == null) {
			System.out.println("Theatre not found!!");
			return false;
		} else {
			show.setTheatre(theatre);
			return true;
		}
	}

	@Override
	public Admin validateAdminLogin(String username, String userPass) throws UserException {
		Query query = manager.createQuery("FROM Admin WHERE adminName = :first AND adminPassword = :second");
		query.setParameter("first", username);
		query.setParameter("second", userPass);

		List<Admin> adminList = query.getResultList();

		if (adminList.isEmpty()) {
			throw new UserException("Admin Doesn't exist");
		}
		return adminList.get(0);
	}

	@Override
	public Admin save(Admin admin) {
		Query query = manager.createQuery("FROM Admin");
		List<Admin> adminList = query.getResultList();

		if (adminList.isEmpty()) {
			manager.persist(admin);
			System.out.println("Admin has been added successfully");
			return admin;
		}
		System.out.println("Admin already exists in database");
		return null;
	}

	@Override
	public Admin find(Integer adminId) {
		Admin admin = manager.find(Admin.class, adminId);
		if (admin == null) {
			System.out.println("Admin not found!!");
			return null;
		} else {
			return admin;
		}
	}
	
	@Override
	public List<Admin> findAll(){
		Query query = manager.createQuery("FROM Admin");
		List<Admin> adminList = query.getResultList();

		if (adminList.isEmpty()) {
			System.out.println("No admins in the database.");
			return null;
		} else {
			return adminList;
		}
	}
	
	@Override
	public boolean addMovieToTheatre(Integer movieId, Integer showId, Integer theatreId) {
		Theatre theatre = manager.find(Theatre.class, theatreId);
		Show show = manager.find(Show.class, showId);
		Movie movie = manager.find(Movie.class, movieId);

		if (theatre == null || show == null) {
			System.out.println("Theatre/Show not found!!");
			return false;
		} else {
			show.setMovie(movie);
			theatre.getMovieList().add(movie);
			movie.getTheatre().add(theatre);
			return true;
		}
	}

	@Override
	public Admin remove(Integer adminId) {
		Admin admin = manager.find(Admin.class, adminId);
		flag = 1;
		System.out.println("Admin has been removed");
		return admin;
	}

	@Override
	public List<Movie> getMovies() {
		Query query = manager.createQuery("From Movie where showStatus = :first");
		query.setParameter("first",0);
		List<Movie> movieList=query.getResultList();
		return movieList;
	}

	@Override
	public List<String> getTheatreByMovieId(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie != null) {
			List<Theatre> theatresList = movie.getTheatre();
			List<String> nameIdList = new ArrayList<String>();
			theatresList.forEach(theatre -> {
				nameIdList.add(theatre.getTheatreId() + " " + theatre.getTheatreName());
			});
			return nameIdList;
		}
		return null;
	}

	@Override
	public Date getReleaseDate(Integer movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie == null) {
			System.out.println("Movie not found!!");
			return null;
		} else {
			return movie.getMovieReleaseDate();
		}
	}

	@Override
	public Boolean setShowStatus(Integer movieId) {
		Movie movie = manager.find(Movie.class,movieId);
		manager.getTransaction().begin();
		movie.setShowStatus(1);
		manager.getTransaction().commit();
		
		return true;	
	}

}
