import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { IMovie } from 'src/app/models/movie.interface';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
/**
 * Represents the MoviesComponent class.
 */
export class MoviesComponent implements OnInit {
  selectedMovie: IMovie | null = null;
  movies: IMovie[] = [];

  constructor(private homeService: HomeService, private logger: NGXLogger) { }

  /**
   * Initializes the component and retrieves the movies.
   */
  ngOnInit(): void {
    this.getMovies();
  }

  /**
   * Retrieves the latest movies from the server.
   */
  getMovies() {
    this.homeService.getMovies().subscribe((response: { movies: IMovie[] }) => {
      this.movies = response.movies || [];
      this.logger.debug('Movies received:', this.movies);
    });
  }
  
  /**
   * Sets the selected movie to show its details.
   * @param movie - The movie to show details for.
   */
  showDetails(movie: IMovie) {
    this.selectedMovie = movie;
  }

  /**
   * Closes the details of the selected article.
   */
  closeDetails() {
    this.selectedMovie = null;
  }

  /**
   * Searches for movies based on the provided keyword.
   * If the keyword is empty, retrieves all movies.
   * @param keyword - The keyword to search for.
   */
  searchMovies(keyword: string) {
    if (keyword && keyword !== '') {
      this.logger.debug('Searching movies with keyword:', keyword);
      this.homeService.searchLatestMovies(keyword).subscribe((response: { movies: IMovie[] }) => {
        this.movies = response.movies || [];
        this.logger.debug('movies received:', this.movies);
      });
    } else {
      this.logger.debug('Keyword is empty, getting all movies');
      this.getMovies();
    }
  }

  /**
   * Adds the specified selectedMovie to favorites.
   * @param movie - The article to add to favorites.
   */
  favoriteMovie(movie: IMovie) {
    this.logger.debug('Adding movie to favorites:', movie);
    this.homeService.getFavoriteMovies().subscribe((response: IMovie[]) => {
      const favoriteMovie: IMovie[] = response || [];
      movie.id = favoriteMovie.length + 1;
      this.homeService.addFavoriteMovie(movie).subscribe((response: { movie: IMovie }) => {
        // add alert to show success message
        alert('movie added to favorites');
        this.logger.debug('movie added to favorites:', response.movie);
      });
    });
  }
}
