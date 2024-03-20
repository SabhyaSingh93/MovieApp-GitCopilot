package com.capstone.movieapp.model;


/*
 * Create a movie class with the following fields:
 * 
  "rank": 32,
  "title": "Oppenheimer",
  "thumbnail": "https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_UY67_CR0,0,45,67_AL_.jpg",
  "rating": "8.6",
  "id": "top32",
  "year": 2023,
  "image": "https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_QL75_UX380_CR0,0,380,562_.jpg",
  "description": "The story of American scientist, J. Robert Oppenheimer, and his role in the development of the atomic bomb.",
  "trailer": "https://www.youtube.com/watch?v=uYPbbksJxIg",
  "trailer_embed_link": "https://www.youtube.com/embed/uYPbbksJxIg",
  "director": [
    "Christopher Nolan"
  ],
  "writers": [
    "Christopher Nolan",
    "Kai Bird",
    "Martin Sherwin"
  ],
  "imdbid": "tt15398776",
  "imdb_link": "https://www.imdb.com/title/tt15398776"  
    Use @Data annotation to generate getters and setters for all fields.
    Use @NoArgsConstructor to generate a no-argument constructor.
    Use @AllArgsConstructor to generate a constructor with all fields.
    Use @document to specify the collection name as "movies".
 */

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private int rank;
    private String title;
    private String thumbnail;
    private String rating;
    private int year;
    private String image;
    private String description;
    private String trailer;
    private String trailer_embed_link;
    private List<String> director;
    private List<String> writers;
    private String imdbid;
    private String imdb_link;
}
