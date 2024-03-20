import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { NGXLogger } from 'ngx-logger';
// Remove the duplicate import statement for 'environment'

@Injectable({
  providedIn: 'root'
})
export class HomeService {
 
  private apiUrl: string = environment.apiUrl; // Replace with your actual API URL

  constructor(private http: HttpClient, private logger: NGXLogger) { }

  /**
   * Retrieves the favorite movie.
   * @returns An Observable that emits the favorite movie.
   */
  getFavoriteMovies(): Observable<any> {
    this.logger.info('Getting favorite movies');
    return this.http.get(`${this.apiUrl}favorite-movies`);
  }
  /**
   * Retrieves the latest movies.
   * @returns An Observable that emits the latest movies.
   */
  getMovies(): Observable<any> {
    this.logger.info('Getting latest movies');
    return this.http.get(`${this.apiUrl}movie/getAllMovies`);
  }


  /**
   * Adds a favorite movie.
   * @param movie - The movie to be added as a movie.
   * @returns An Observable that emits the response from the API.
   */
  addFavoriteMovie(movie: any): Observable<any> {
    this.logger.info('Adding favorite movie', movie);
    return this.http.post(`${this.apiUrl}favorite-movies`, movie);
  }

  /**
   * Deletes a favorite movie.
   * @param movieId - The ID of the movie to be deleted.
   * @returns An Observable that emits the response from the API.
   */
  deleteFavoriteMovie(movieId: number): Observable<any> {
    this.logger.info('Deleting favorite movie', movieId);
    return this.http.delete(`${this.apiUrl}favorite-movies/${movieId}`, { responseType: 'text' });
  }



  /**
   * Searches for the latest movie based on a keyword.
   * @param keyword - The keyword to search for.
   * @returns An Observable that emits the search results.
   */
  searchLatestMovies(keyword: string): Observable<any> {
    this.logger.info('Searching latest movie', keyword);
    return this.http.post(`${this.apiUrl}movies/search`, keyword);
  }
}