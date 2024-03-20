package com.capstone.movieapp.controller;

/*
 * create a controller for the favorite with following methods:  getFavoriteMovies, saveFavoriteMovie, deleteFavoriteMovie using loggers from MovieService
 * use restcontroller annotation and autowire the MovieService and use the methods to get the favorite movies, save the favorite movies and delete the favorite movies
 * use @GetMapping and @postMapping and @DeleteMapping annotation to specify the url for the methods
 * use route /api/v1/favorite for the methods
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.movieapp.exceptions.MovielAlreadyExistsException;
import com.capstone.movieapp.model.Movie;
import com.capstone.movieapp.service.MovieService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The FavoriteController class handles the API endpoints related to favorite
 * movies.
 * It provides methods to fetch, save, and delete favorite artmoviesicles.
 */
@RestController
@RequestMapping("/api/v1/favorite-movies")
public class FavoriteController {

    private static final Logger logger = LogManager.getLogger(FavoriteController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getFavoriteMovies() {
        logger.info("Fetching all favorite movies");
        List<Movie> favoriteMovies = movieService.getAllMovies();
        return ResponseEntity.ok(favoriteMovies);
    }

    @PostMapping
    public ResponseEntity<Movie> saveFavoriteMovie(@RequestBody Movie movie) {
        try {
            Movie savedMovie = movieService.saveMovie(movie);
            logger.info("Movie with id: {} saved as favorite", movie.getId());
            return ResponseEntity.ok(savedMovie);
        } catch (MovielAlreadyExistsException exception) {
            logger.error("Movie with id: {}  already saved as favorite", movie.getId());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFavoriteMovie(@PathVariable String id) {
        movieService.deleteMovieById(id);
        logger.info("Movie with id: {} deleted from favorite", id);
        return ResponseEntity.ok("Movie with id: " + id + " deleted from favorite");
    }
}
