package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Movie;
import com.cognizant.service.MovieService;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Ramesh
 *
 */
@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {


	
	@Autowired
	MovieService movieService;
	

	/**
	 * 
	 * ADD movies Using Post
	 */
	/*
	 * {
        
        "title": "MCA",
        "boxOffice": "Ready",
        "active": "YES",
        "dateOfLaunch": "2021-04-17",
        "genre": "Drama",
        "hasTeaser": "No"
    }
	 */
	//localhost:8081/movies/add-movie
	//
	/*
	 * insert into movie
	 * (mo_id,mo_active,mo_box_office,mo_date_of_launch,mo_genre,mo_has_teaser,
	 * mo_title) -> values(2,"YES","Ready","2012-10-2","Drama","Yes","Billa");
	 */
	@PostMapping("/add-movie")
	public Movie editMenuItem(@RequestBody Movie movie) {
		log.info("Start");
		movieService.AddMovieList(movie);
		log.debug("Added Movie {}",movie);
		log.info("End");
		return movie;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @return all the movies as a list
	 */
	//localhost:8081/movies/admin
	@GetMapping("/admin")
	public List<Movie> getMovieListAdmin()
	{
		log.info("start list admin");
		List<Movie> movieListAdmin = movieService.getMovieListAdmin();
		log.debug("Movies {}",movieListAdmin);
		log.info("Ended");
		return movieListAdmin;
	}
	/**
	 * 
	 * @return all movies the has already released
	 */
	//localhost:8081/movies/customer
	@GetMapping("/customer")
	public List<Movie> getMovieListCustomer()
	{
		log.info("start customer movie list");
		List<Movie> l=movieService.getMovieListCustomer();
		log.debug("Movies {}",l);
		log.info("Ended");;
		return l;
	}
	/**
	 * 
	 * @param movieId
	 * @return the movie with the given Id
	 */
	//localhost:8081/movies/1
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable int movieId)
	{
		log.info("start get movie by id customer");
		Movie movie = movieService.getMovie(movieId);
		log.debug("Movie {}",movie);
		log.info("Ended");
		return movie;
	}
	/**
	 * 
	 * @param movie
	 * @return success / failure message after editing the movie
	 */
	/*
	 * {
        "id": 1,
        "title": "Billa",
        "boxOffice": "Ready",
        "active": "YES",
        "dateOfLaunch": "2012-10-01",
        "genre": "Drama",
        "hasTeaser": "No"
    }
	 */
	//localhost:8081/movies/1
	@PutMapping("/{id}")
	public String modifyMovie(@RequestBody Movie movie, @PathVariable int id)
	{
		log.info("start edit movie ");
		String modifyMovie = movieService.modifyMovie(movie);
		log.debug(modifyMovie);
		log.info("modifyMovie");
		return modifyMovie;
	}
}