package com.cg.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.app.entities.Movie;
import com.cg.app.entities.Show;
import com.cg.app.entities.Theatre;
import com.cg.app.services.AdminService;
import com.cg.app.services.AdminServiceImpl;
import com.cg.app.services.CustomerService;
import com.cg.app.services.CustomerServiceImpl;
import com.cg.app.services.MovieService;
import com.cg.app.services.MovieServiceImpl;
import com.cg.app.services.ShowService;
import com.cg.app.services.ShowServiceImpl;
import com.cg.app.services.TheatreService;
import com.cg.app.services.TheatreServiceImpl;

@Controller
public class MainController {
	@Autowired
	TheatreService theatreService = new TheatreServiceImpl();
	
	@Autowired
	AdminService adminService = new AdminServiceImpl();
	
	@Autowired
	ShowService showService = new ShowServiceImpl();
	
	@Autowired
	MovieService movieService = new MovieServiceImpl();
	
	@Autowired
	CustomerService customerService = new CustomerServiceImpl();
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "HomePage";
	}
	
	@RequestMapping(value = "/addMoviePage", method = RequestMethod.GET)
	public String addMoviePage(@ModelAttribute("myMovieForm") Movie movie, Map<String, Object> model) {
		List<String> myLanguageList = new ArrayList<String>();
		List<String> myGenreList = new ArrayList<String>();
		
		myGenreList.add("Sci-Fi"); 
		myGenreList.add("Drama"); 
		myGenreList.add("Thriller"); 
		myGenreList.add("Comedy");
		myGenreList.add("Romance");
		
		myLanguageList.add("Hindi"); 
		myLanguageList.add("English"); 
		myLanguageList.add("Marathi"); 
		myLanguageList.add("Bengali");
		
		model.put("languageDataItem", myLanguageList);
		model.put("genreDataItem", myGenreList);
		
		return "AddMoviePage";
	}
	
	@RequestMapping(value = "/addShowPage", method = RequestMethod.GET)
	public String addShowPage(@ModelAttribute("myShowForm") Show show, Map<String, Object> model) {
		
		List<Movie> myMovieList = movieService.findAll();
		List<Theatre> myTheatreList = theatreService.findAll();
		
		model.put("movieDataItem", myMovieList);
		model.put("theatreDataItem", myTheatreList);
		
		return "AddShowPage";
	}
	
	@RequestMapping(value = "/addTheatrePage", method = RequestMethod.GET)
	public String addTheatrePage(@ModelAttribute("myTheatreForm") Theatre theatre, Map<String, Object> model) {
		List<String> myCityList = new ArrayList<String>();
		myCityList.add("Mumbai"); 
		myCityList.add("Bangalore"); 
		myCityList.add("Pune");
		myCityList.add("Hyderabad"); 
		myCityList.add("Chennai"); 
		myCityList.add("Kolkata");
		
		model.put("cityDataItem", myCityList);	
		return "AddTheatrePage";
	}
	
	@RequestMapping(value = "/addTheatreToDatabase", method = RequestMethod.POST)
	public ModelAndView addTheatre(@ModelAttribute("myTheatreForm") Theatre theatre,  BindingResult result) {
		theatreService.save(theatre);
		List<Theatre> myTheatreList=theatreService.findAll();
		return new ModelAndView("ShowTheatrePage","theatreData", myTheatreList);
	}
	
	@RequestMapping(value = "/addShowToDatabase", method = RequestMethod.POST)
	public ModelAndView addShow(@ModelAttribute("myShowForm") Show show,  BindingResult result) {
		showService.save(show);
		List<Show> myShowList=showService.findAll();
		return new ModelAndView("ShowShowPage","showData", myShowList);
	}
	
	@RequestMapping(value = "/addMovieToDatabase", method = RequestMethod.POST)
	public ModelAndView addMovie(@ModelAttribute("myMovieForm") Movie movie,  BindingResult result) {
		movieService.save(movie);
		List<Movie> myMovieList=movieService.findAll();
		return new ModelAndView("ShowMoviePage","movieData", myMovieList);
	}
}
