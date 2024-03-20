import { Component, OnInit } from '@angular/core';
import { IMovie } from 'src/app/models/movie.interface';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-favorite-movies',
  templateUrl: './favorite-movies.component.html',
  styleUrls: ['./favorite-movies.component.scss']
})
/**
 * Represents the Favorite Movies component.
 */
export class FavoriteMoviesComponent implements OnInit {
  selectedMovie: IMovie| null = null;
  FavoriteMovies: any[] = [];
  

  constructor(
    // use the HomeService to fetch favorite movies
    private homeService: HomeService
  ) { }

  ngOnInit(): void {
    this.getFavoriteMovies();
  }

  /**
   * Handles the event when an movie is selected to show details.
   * @param movie - The selected movie.
   */
  showDetails(movie: IMovie) {
    this.selectedMovie = movie;
  }

  /**
   * Handles the event when the selected movie details are closed.
   */
  closeDetails() {
    this.selectedMovie = null;
  }

  /**
   * Fetches the favorite movies from the server.
   * Assigns the fetched movies to the favoriteMovies array.
   */
  getFavoriteMovies(): void {
    // Code to fetch FavoriteMovies from the server
    // Assign the fetched movies to the favrouite movie array
    this.homeService.getFavoriteMovies().subscribe((response: any) => {
      this.FavoriteMovies = response || [];
    });
  }

  /**
   * Deletes the specified Movie from the favoriteMovie array.
   * Displays an alert message to inform the user that the Movie has been deleted.
   * @param Movie - The Movie to be deleted.
   */
  deleteMovie(movie: any): void {
    // Code to delete the article from the FavoriteMovies array
    // Display an alert message to inform the user that the Movie has been deleted
    this.homeService.deleteFavoriteMovie(movie.id).subscribe((response: any) => {
      this.getFavoriteMovies();
      alert('Movie removed from favorites');
    });
  }

}
