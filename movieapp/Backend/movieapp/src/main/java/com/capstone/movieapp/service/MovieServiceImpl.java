package com.capstone.movieapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/*
 * create class for the MovieServiceImpl which implements the MovieService
 * use @Service annotation to specify the service
 * use @Autowired annotation to inject the MovieRepository
 * implement all the methods of the MovieService
 *
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.capstone.movieapp.exceptions.MovielAlreadyExistsException;
import com.capstone.movieapp.model.Movie;
import com.capstone.movieapp.model.MovieList;
import com.capstone.movieapp.repository.MovieRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LogManager.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Value("${API_URL}")
    private String apiUrl;

    @Value("${X-RapidAPI-Key}")
    private String apiKey;

    @Value("${X-RapidAPI-Host}")
    private String apiHost;

    /**
     * Retrieves all movies from the database.
     *
     * @return The list of all movies.
     */
    @Override
    public List<Movie> getAllMovies() {
        logger.info("Fetching all movies");
        return movieRepository.findAll();
    }

    /**
     * Retrieves an movie by its ID.
     *
     * @param id The ID of the movie.
     * @return An Optional containing the movie, or an empty Optional if not
     *         found.
     */
    @Override
    public Optional<Movie> getMovieById(String id) {
        logger.info("Fetching movie with id: {}", id);
        return movieRepository.findById(id);
    }

    /**
     * Saves an movie to the database.
     *
     * @param movie The article to be saved.
     * @return The saved movie.
     * @throws MovieAlreadyExistsException If an movie with the same ID already
     *                                     exists.
     */
    @Override
    public Movie saveMovie(Movie movie) throws MovielAlreadyExistsException {
        if (movieRepository.existsById(String.valueOf(movie.getId()))) {
            logger.error("Movie with id: {} already exists", movie.getId());
            throw new MovielAlreadyExistsException("Movie with id: " + movie.getId() + " already exists");
        }
        logger.info("Saving movie with id: {}", movie.getId());
        return movieRepository.save(movie);
    }

    /**
     * Deletes an movie from the database by its ID.
     *
     * @param id The ID of the movie to be deleted.
     */
    @Override
    public void deleteMovieById(String id) {
        logger.info("Deleting movie with id: {}", id);
        movieRepository.deleteById(id);
    }

    /**
     * Searches for the latest movies based on a keyword.
     *
     * @param keyword The keyword to search for.
     * @return An MovieList object containing the latest movies.
     */
    @Override
    public MovieList searchLatestMovies(String keyword) {
        logger.info("Searching latest articles with keyword: {}", keyword);
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "everything?q=" + keyword + "&from=2024-02-25&sortBy=publishedAt&apiKey=" + apiKey;
        logger.info("Searching latest articles from: {}", url);
        MovieList movieList = restTemplate.getForObject(url, MovieList.class);
        return movieList;
    }

    @Override
    public MovieList fetchAllMovies() {
        logger.info("Fetching all movies");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        // set accept header for MovieList Object
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", apiHost);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = apiUrl;
        logger.info("Fetching latest articles from: {}", url);
        MovieList movieList = new MovieList();
        try {
            // ResponseEntity<MovieList> response = restTemplate.exchange(url,
            // HttpMethod.GET, entity, MovieList.class);
            // System.out.println(response);
            // movieList = response.getBody();
            ResponseEntity<List<Movie>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Movie>>(){});
            List<Movie> movies = response.getBody();
            movieList.setMovies(movies);
        } catch (Exception e) {
            logger.error("Error fetching movies: {}", e.getMessage());
        }

        return movieList;
    }
}
