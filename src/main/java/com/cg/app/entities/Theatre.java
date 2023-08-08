package com.cg.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theatre_id")
	private Integer theatreId;
	@Column(name = "theatre_name")
	private String theatreName;
	@Column(name = "theatre_city")
	private String cityName;
	@Column(name = "city_pincode")
	private Integer cityPincode;
	@ManyToMany(mappedBy = "theatre", cascade=CascadeType.PERSIST)
	private List<Movie> movieList;
	@OneToMany(mappedBy = "theatre")
	private List<Show> showsList;
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Theatre(Integer theatreId, String theatreName, String cityName, Integer cityPincode, List<Movie> movieList,
			List<Show> showsList) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.cityName = cityName;
		this.cityPincode = cityPincode;
		this.movieList = movieList;
		this.showsList = showsList;
	}
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getCityPincode() {
		return cityPincode;
	}
	public void setCityPincode(Integer cityPincode) {
		this.cityPincode = cityPincode;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	public List<Show> getShowsList() {
		return showsList;
	}
	public void setShowsList(List<Show> showsList) {
		this.showsList = showsList;
	}
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", cityName=" + cityName
				+ ", cityPincode=" + cityPincode + ", movieList=" + movieList + ", showsList=" + showsList + "]";
	}
	
}
