package com.cg.app.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.cg.app.entities.Booking;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Movie;
import com.cg.app.exceptions.UserException;

public interface CustomerDao {
	public Customer addCustomer(Customer customer);
	public Boolean validateCustomerLogin(String userName, String userPass) throws UserException;
	public List<Movie> getMovies();
	public List<String> getTheatreByMovieId(Integer movieId);
	public List<String> getShows(Integer theatreSelected, Integer theatreSelected2);
	public BigInteger getUserId(String userName);
	public Boolean addBooking(Booking booking) throws Exception;
	public List<String> viewBookings(BigInteger userID);
	public Boolean cancelBooking(BigInteger bookingid);
	public BigInteger getBookingId(BigInteger userId);
	public Date getReleaseDate(Integer movieId);
	public Integer getAvailableSeats(Integer showSelected);
	public Boolean updateSeats(Integer showSelected, Integer availableSeats, Integer bookedSeats);
}
