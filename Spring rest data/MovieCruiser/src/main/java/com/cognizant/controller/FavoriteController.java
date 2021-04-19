package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.FavoritesEmptyException;
import com.cognizant.service.FavoritesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/favorites")
@Slf4j
public class FavoriteController {
	
	@Autowired
	FavoritesService favoritesService;
	/**
	 * 
	 * @param userId
	 * @param movieId
	 * @return Success/failure message after adding favorite movie
	 */
	//localhost:8081/favorites/1/1
	@PostMapping("/{userId}/{movieId}")
	public String addFavoritesMovie(@PathVariable int userId, @PathVariable int movieId)
	{
		log.info("Add Favorite started");
		String addFavoritesMovie = favoritesService.addFavoritesMovie(userId, movieId);
		log.debug(addFavoritesMovie);
		log.info("ended");
		return addFavoritesMovie;
	}
	/**
	 * 
	 * @param userId
	 * @return List of favorite movies for user id
	 * @throws FavoritesEmptyException
	 */
	//localhost:8081/favorites/1
	@GetMapping("/{userId}")
	public List<Object> getAllFavoriteMovies(@PathVariable int userId) throws FavoritesEmptyException
	{
		log.info("Get All user Favourite movies service started");
		List<Object> allFavoriteMovies = favoritesService.getAllFavoriteMovies(userId);
		log.debug("Favorite Movies {}",allFavoriteMovies);
		log.info("Ended");
		return allFavoriteMovies;
	}
	/**
	 * 
	 * @param userId
	 * @param movieId
	 * @return success / failure message after deleting the movie
	 */
	//localhost:8081/favorites/1/1
	@DeleteMapping("/{userId}/{movieId}")
	public String deleteFavoriteMovie(@PathVariable int userId, @PathVariable int movieId)
	{
		log.info("delete service started");
		String removeFavoriteMovie = favoritesService.removeFavoriteMovie(userId, movieId);
		log.debug(removeFavoriteMovie);
		log.info("Ended");
		return removeFavoriteMovie;
	}

}