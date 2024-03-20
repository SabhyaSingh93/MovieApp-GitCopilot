package com.capstone.movieapp.controller;

/*
 * create a controller for the movies with following methods:   searchLatestMovies using loggers from MovieServices
 * use restcontroller annotation and autowire the MovieService and use the methods  search the latest movies
 * use @GetMapping and @postMapping annotation to specify the url for the methods
 * use route /api/v1/movies for the methods
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.movieapp.model.Movie;
import com.capstone.movieapp.model.MovieList;
import com.capstone.movieapp.service.MovieService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Controller class for handling API requests related to movies.
 */
@RestController
@RequestMapping("/api/v1/movie")
public class MoviesController {

    private static final Logger logger = LogManager.getLogger(MoviesController.class);

    @Autowired
    private MovieService movieService;

    /**
     * Retrieves all  movies.
     *
     * @return ResponseEntity containing the list of  movies
     */
 @GetMapping("/getAllMovies")
    public ResponseEntity<MovieList> getAllMovies() {
        logger.info("Fetching all favorite movies");
        MovieList movies = movieService.fetchAllMovies();
        return ResponseEntity.ok(movies);
    }

   
    /**
     * Searches for the latest movies based on a keyword.
     *
     * @param keyword the keyword to search for
     * @return ResponseEntity containing the search results
     */
    @PostMapping("/search")
    public ResponseEntity<MovieList> searchLatestMovies(@RequestBody String keyword) {
        logger.info("Searching the latest movies by keyword: {}", keyword);
        MovieList latestMovies = movieService.searchLatestMovies(keyword);
        return ResponseEntity.ok(latestMovies);
    }
}
