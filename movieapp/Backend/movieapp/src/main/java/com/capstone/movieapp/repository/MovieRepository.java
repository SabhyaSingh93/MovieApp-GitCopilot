package com.capstone.movieapp.repository;

/*
 * create a repositiry interface for artical which implemnts mongodb repository
 * use @Repository annotation to specify the repository
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.capstone.movieapp.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

}
