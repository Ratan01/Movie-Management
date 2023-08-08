package com.cg.app.entities;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "customer")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private BigInteger customerId;
	@Column(name="username")
	private String customerName;
	@Column(name="Password")
	private String customerPassword;
	@Column(name="phone_number")
	private String contactNumber;
	@OneToMany(mappedBy = "customer")
	private List<Booking> bookings;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(BigInteger customerId, String customerName, String customerPassword, String contactNumber,
			List<Booking> bookings) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.contactNumber = contactNumber;
		this.bookings = bookings;
	}
	public BigInteger getCustomerId() {
		return customerId;
	}
	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", contactNumber=" + contactNumber + ", bookings=" + bookings + "]";
	}
	
}
