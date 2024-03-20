import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; // Import RouterModule from @angular/router
import { HomeComponent } from './home.component';
import { SharedModule } from './../../utility/shared.module';
import { HeaderComponent } from './components/header/header.component'; // Import SharedModule from the correct file

@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    SharedModule, // Add SharedModule to the imports array
    RouterModule.forChild([
      {
        path: 'home',
        component: HomeComponent,
        // lazload movies module, favorite movies module
        children: [
          // ...

          // ...

          {
            path: 'movies',
            loadChildren: () => import('./../home/modules/movies/movies.module').then(m => m.MoviesModule)
          },
          {
            path: 'favorite-movies',
            loadChildren: () => import('./../home/modules/favorite-movies/favorite-movies.module').then(m => m.FavoriteMoviesModule)
          },
          // redirect to movies module
          {
            path: 'movies',
            redirectTo: 'movies',
            pathMatch: 'full'
          }
        ]

      },

    ])
  ]
})
export class HomeModule { }
