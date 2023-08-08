package com.cg.app.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private Integer movieId;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "movie_genre")
	private String genre;
	@Column(name = "movie_director")
	private String director;
	@Column(name = "movie_length")
	private Integer movieLength;
	@Column(name = "movie_release_date")
	private Date movieReleaseDate;
	@Column(name = "movie_language")
	private String language;
	@Column(name = "delete_flag")
	private Integer flag=0;
	@Column(name = "show_status")
	private Integer showStatus;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(joinColumns = @JoinColumn(name="movie_fk"), inverseJoinColumns = @JoinColumn(name = "theatre_fk"))
	private List<Theatre> theatre;
	@OneToMany(mappedBy = "movie")
	private List<Show> showList;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(Integer movieId, String movieName, String genre, String director, Integer movieLength,
			Date movieReleaseDate, String language, Integer flag, Integer showStatus, List<Theatre> theatre,
			List<Show> showList) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.director = director;
		this.movieLength = movieLength;
		this.movieReleaseDate = movieReleaseDate;
		this.language = language;
		this.flag = flag;
		this.showStatus = showStatus;
		this.theatre = theatre;
		this.showList = showList;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}
	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getShowStatus() {
		return showStatus;
	}
	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}
	public List<Theatre> getTheatre() {
		return theatre;
	}
	public void setTheatre(List<Theatre> theatre) {
		this.theatre = theatre;
	}
	public List<Show> getShowList() {
		return showList;
	}
	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", director=" + director
				+ ", movieLength=" + movieLength + ", movieReleaseDate=" + movieReleaseDate + ", language=" + language
				+ ", flag=" + flag + ", showStatus=" + showStatus + ", theatre=" + theatre + ", showList=" + showList
				+ "]";
	}
	
}
