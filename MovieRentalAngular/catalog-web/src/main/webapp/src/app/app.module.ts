import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";

import { ClientsComponent } from './clients/clients.component';
import { ClientListComponent } from './clients/client-list/client-list.component';
import {ClientService} from "./clients/shared/client.service";
import { ClientNewComponent } from './clients/client-new/client-new.component';
import { ClientUpdateComponent } from './clients/client-update/client-update.component';
import { MoviesComponent } from './movies/movies.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import {MovieService} from "./movies/shared/movie.service";
import { MovieNewComponent } from './movies/movie-new/movie-new.component';
import { MovieUpdateComponent } from './movies/movie-update/movie-update.component';


@NgModule({
  declarations: [
    AppComponent,

    ClientsComponent,
    ClientListComponent,
    ClientNewComponent,
    ClientUpdateComponent,
    MoviesComponent,
    MovieListComponent,
    MovieNewComponent,
    MovieUpdateComponent,




  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [ClientService,MovieService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
