import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FavoriteMoviesComponent } from './favorite-movies.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/utility/shared.module';



@NgModule({
  declarations: [
    FavoriteMoviesComponent
  ],
  imports: [
    CommonModule,
    // add shared module
    SharedModule,
    // add router module
    RouterModule.forChild([
      {
        path: '',
        component: FavoriteMoviesComponent
      }
    ])
  ]
})
export class FavoriteMoviesModule { }
