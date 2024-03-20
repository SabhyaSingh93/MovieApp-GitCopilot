import { TestBed, ComponentFixture } from '@angular/core/testing';
import { of } from 'rxjs';
import { FavoriteMoviesComponent } from './favorite-movies.component';
import { HomeService } from 'src/app/services/home.service';

describe('FavoriteMoviesComponent', () => {
  let component: FavoriteMoviesComponent;
  let fixture: ComponentFixture<FavoriteMoviesComponent>;
  let homeService: HomeService;
  let getFavoriteMoviesSpy: jasmine.Spy;
  let deleteFavoriteMovieSpy: jasmine.Spy;

  beforeEach(() => {
    const homeServiceSpy = jasmine.createSpyObj('HomeService', ['getFavoriteMovies', 'deleteFavoriteMovie']);
    getFavoriteMoviesSpy = homeServiceSpy.getFavoriteMovies.and.returnValue(of([]));
    deleteFavoriteMovieSpy = homeServiceSpy.deleteFavoriteArticle.and.returnValue(of(''));

    TestBed.configureTestingModule({
      declarations: [FavoriteMoviesComponent],
      providers: [
        { provide: HomeService, useValue: homeServiceSpy }
      ]
    });

    fixture = TestBed.createComponent(FavoriteMoviesComponent);
    component = fixture.componentInstance;
    homeService = TestBed.inject(HomeService);
  });

  it('should get favorite movie on init', () => {
    const favoriteMovies = [{ id: 1, title: 'Test Article' }];
    getFavoriteMoviesSpy.and.returnValue(of(favoriteMovies));

    component.ngOnInit();

    expect(homeService.getFavoriteMovies).toHaveBeenCalled();
    expect(component.FavoriteMovies).toEqual(favoriteMovies);
  });

  it('should delete favorite article', () => {
    const favoriteMovies = [{ id: 1, title: 'Test Article' }];
    deleteFavoriteMovieSpy.and.returnValue(of(favoriteMovies));
    component.ngOnInit();
    component.deleteMovie(favoriteMovies[0]);
    expect(homeService.deleteFavoriteMovie).toHaveBeenCalled();
  });

  it('should show details', () => {
    const article: any = { id: 1, title: 'Test Article' };
    component.showDetails(article);
    expect(component.selectedMovie).toEqual(article);
  });

  it('should close details', () => {
    component.closeDetails();
    expect(component.selectedMovie).toBeNull();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});