package com.cg.app.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.CustomerDao;
import com.cg.app.entities.Booking;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Movie;
import com.cg.app.exceptions.UserException;

import jakarta.transaction.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public Customer addCustomer(Customer customer) throws UserException {
		if (Validate.validate_customer(customer)) {
			return customerDao.addCustomer(customer);
		}
		return null;
	}

	public Boolean validateCustomerLogin(String userName, String userPass) throws UserException {
		return customerDao.validateCustomerLogin(userName, userPass);
	}

	public List<Movie> getMovies() {
		return customerDao.getMovies();
	}

	public List<String> getTheatreByMovieId(Integer movieId) {

		return customerDao.getTheatreByMovieId(movieId);
	}

	public List<String> getShows(Integer movieId, Integer theatreSelected) {
		return customerDao.getShows(movieId, theatreSelected);
	}

	public BigInteger getUserId(String userName) {

		return customerDao.getUserId(userName);
	}

	public Boolean addBooking(Booking booking) throws Exception {
		if (Validate.validate_booking(booking)) {
			return customerDao.addBooking(booking);
		}
		return false;
	}

	public List<String> viewBookings(BigInteger userID) {
		return customerDao.viewBookings(userID);
	}

	public Boolean cancelBooking(BigInteger bookingid) {
		return customerDao.cancelBooking(bookingid);
	}

	public BigInteger getBookingId(BigInteger userId) {
		return customerDao.getBookingId(userId);
	}

	public Date getReleaseDate(Integer movieId) {
		return customerDao.getReleaseDate(movieId);
	}

	public Integer getAvailableSeats(Integer showSelected) {
		return customerDao.getAvailableSeats(showSelected);
	}

	public Boolean updateSeats(Integer showSelected, Integer seatsAvailable, Integer bookedSeats) {
		return customerDao.updateSeats(showSelected, seatsAvailable, bookedSeats);

	}

}
