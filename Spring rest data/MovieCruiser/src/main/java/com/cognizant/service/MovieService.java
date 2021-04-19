package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.Movie;
/**
 * @author Ramesh
 *
 */
@Service
public interface MovieService {

	List<Movie> getMovieListAdmin();

	List<Movie> getMovieListCustomer();

	Movie getMovie(int movieId);

	String modifyMovie(Movie movie);

	Movie AddMovieList(Movie movie);

}
