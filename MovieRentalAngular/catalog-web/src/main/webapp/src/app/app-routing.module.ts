import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { ClientsComponent } from './clients/clients.component';
import { ClientNewComponent } from './clients/client-new/client-new.component';
import { ClientUpdateComponent } from './clients/client-update/client-update.component';
import {MoviesComponent} from "./movies/movies.component";
import {MovieNewComponent} from "./movies/movie-new/movie-new.component";
import {MovieUpdateComponent} from "./movies/movie-update/movie-update.component";

const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },


  {path: 'clients', component: ClientsComponent},
  {path: 'client/new', component: ClientNewComponent},
  {path: 'client/update', component: ClientUpdateComponent},
  { path: 'client/update/:id', component: ClientUpdateComponent },

  {path: 'movies', component: MoviesComponent},
  {path: 'movie/new', component: MovieNewComponent},
  {path: 'movie/update', component: MovieUpdateComponent},
  { path: 'movie/update/:id', component: MovieUpdateComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
