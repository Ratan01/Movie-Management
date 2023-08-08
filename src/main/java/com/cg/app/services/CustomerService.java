package com.cg.app.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.cg.app.entities.Booking;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Movie;
import com.cg.app.exceptions.UserException;

public interface CustomerService {
	public Customer addCustomer(Customer customer) throws UserException;
	public Boolean validateCustomerLogin(String userName, String userPass) throws UserException;
	public List<Movie> getMovies();
	public List<String> getTheatreByMovieId(Integer movieId);
	public List<String> getShows(Integer movieId, Integer theatreSelected);
	public BigInteger getUserId(String userName);
	public Boolean addBooking(Booking booking) throws Exception;
	public List<String> viewBookings(BigInteger userID);
	public Boolean cancelBooking(BigInteger booking_id);
	public BigInteger getBookingId(BigInteger userId);
	public Date getReleaseDate(Integer movieId);
	public Integer getAvailableSeats(Integer showSelected);
	public Boolean updateSeats(Integer showSelected, Integer seatsLeft, Integer seatsBooked);
}
