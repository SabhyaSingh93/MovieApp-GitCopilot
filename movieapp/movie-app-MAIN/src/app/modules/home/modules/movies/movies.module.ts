import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/utility/shared.module';
import { MoviesComponent } from './movies.component';



@NgModule({
  declarations: [
    MoviesComponent
  ],
  imports: [
    CommonModule,
    // add shared module
    SharedModule,
    // add router module
    RouterModule.forChild([
      {
        path: '',
        component: MoviesComponent
      }
    ])
  ]
})
export class MoviesModule { }
