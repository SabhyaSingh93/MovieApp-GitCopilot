package com.capstone.movieapp.service;

/*
 * create interface for the MovieService with following methods: getAllMovies, getMovieById which return Optionl movie, saveMovie, deleteMovieById
 * for saveMovie method, use MovieRepository to save the Movie and throw MovieAlreadyExistsException if the id already exists
 * 
 */
import java.util.List;
import java.util.Optional;

import com.capstone.movieapp.exceptions.MovielAlreadyExistsException;
import com.capstone.movieapp.model.Movie;
import com.capstone.movieapp.model.MovieList;

/**
 * The MovieService interface provides methods to interact with movies.
 */
public interface MovieService {

    /**
     * Retrieves all movies.
     *
     * @return a list of all movies
     */
    public List<Movie> getAllMovies();

    /**
     * Retrieves an movie by its ID.
     *
     * @param id the ID of the movie
     * @return an optional containing the movie, or an empty optional if not found
     */
    public Optional<Movie> getMovieById(String id);

    /**
     * Saves an movie.
     *
     * @param movie the movie to be saved
     * @return the saved movie
     * @throws MovieAlreadyExistsException if the article already exists
     */
    public Movie saveMovie(Movie movie) throws MovielAlreadyExistsException;

    /**
     * Deletes an movie by its ID.
     *
     * @param id the ID of the movie to be deleted
     */
    public void deleteMovieById(String id);

    
    /**
     * Searches the latest movies from the API by keyword.
     *
     * @param keyword the keyword to search for
     * @return a list of movies matching the keyword
     */
    public MovieList searchLatestMovies(String keyword);

    public MovieList fetchAllMovies();
}
