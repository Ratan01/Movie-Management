package com.cg.app.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.entities.Booking;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Movie;
import com.cg.app.entities.Show;
import com.cg.app.entities.Theatre;
import com.cg.app.exceptions.UserException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager manager;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
	
	@Transactional
	public Customer addCustomer(Customer customer) {
		Query query = manager.createQuery("From Customer where customerName = :first or contactNumber = :second");
		query.setParameter("first", customer.getCustomerName());
		query.setParameter("second", customer.getContactNumber());
		List<Customer> customerList = query.getResultList();
		if (customerList.isEmpty()) {
			manager.persist(customer);
			return customer;
		}
		System.out.println("Phone number or the username is already Registered");
		System.out.println("Couldn't Register");
		return null;
	}

	public Boolean validateCustomerLogin(String userName, String userPass) throws UserException {
		Query query = manager.createQuery("From Customer where customerName = :first and customerPassword = :second");
		query.setParameter("first", userName);
		query.setParameter("second", userPass);
		List<Customer> customerList = query.getResultList();
		if (customerList.isEmpty()) {
			return false;
		}
		return true;
	}

	public List<Movie> getMovies() {
		Date today = new Date();
		Query query = manager.createQuery("From Movie where showStatus = :first");
		query.setParameter("first",0);
		List<Movie> movieList = query.getResultList();
		return movieList;
	}

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

	public List<String> getShows(Integer movieId, Integer theatreId) {
		Theatre theatre = manager.find(Theatre.class, theatreId);
		if (theatre != null) {
			List<Show> showsList = theatre.getShowsList();

			List<String> timings = new ArrayList<String>();
			showsList.forEach(show -> {
				if (show.getMovie().getMovieId() == movieId) {
					timings.add(show.getShowId() + " : " + sdf.format(show.getShow_date()) + " : "
							+ sdf1.format(show.getShow_timings()) + " seats available : " + show.getAvailableSeats());
				}
			});
			return timings;
		}
		return null;
	}

	public BigInteger getUserId(String userName) {
		Query query = manager.createQuery("From Customer where customerName = :first");
		query.setParameter("first", userName);
		List<Customer> customer = query.getResultList();
		return customer.get(0).getCustomerId();
	}
	
	@Transactional
	public Boolean addBooking(Booking booking) throws Exception {
		manager.persist(booking);
		return true;
	}

	public List<String> viewBookings(BigInteger userID) {
		Customer customer = manager.find(Customer.class, userID);
		if (customer != null) {
			List<Booking> bookingsList = customer.getBookings();
			List<String> bookingIds = new ArrayList<String>();
			bookingsList.forEach(booking -> {
				bookingIds.add(booking.getBookingId() + " : "
						+ sdf1.format(booking.getShow().getShow_timings()) + " : "
								+ booking.getShow().getTheatre().getTheatreName() + " : "
								+ booking.getShow().getMovie().getMovieName());
			});
			return bookingIds;
		}
		return null;
	}
	
	@Transactional
	public Boolean cancelBooking(BigInteger bookingid) {
		Booking booking = manager.find(Booking.class, bookingid);
		booking.setFlag(1);
		return true;
	}
	
	public BigInteger getBookingId(BigInteger userId) {
		Customer customer = manager.find(Customer.class, userId);
		if (customer != null) {
			List<Booking> bookingsList = customer.getBookings();
			List<String> bookingIds = new ArrayList<String>();
			bookingsList.forEach(booking -> {
				bookingIds.add(booking.getBookingId() + " " + booking.getShow());
			});
			return bookingsList.get(bookingsList.size() - 1).getBookingId();
		}
		return null;
	}
	
	public Date getReleaseDate(Integer movieID) {
		Movie movie = manager.find(Movie.class, movieID);
		if (movie == null) {
			System.out.println("Movie not found!!");
			return null;
		} else {
			return movie.getMovieReleaseDate();
		}
	}
	
	public Integer getAvailableSeats(Integer showSelected) {
		Show show = manager.find(Show.class, showSelected);
		if (show == null) {
			System.out.println("Show not found!!");
			return null;
		} else {
			return show.getAvailableSeats();
		}

	}

	@Transactional
	public Boolean updateSeats(Integer showSelected, Integer availableSeats, Integer bookedSeats) {		
		Show show = manager.find(Show.class, showSelected);
		show.setAvailableSeats(availableSeats - bookedSeats);
		return true;
	}
}
