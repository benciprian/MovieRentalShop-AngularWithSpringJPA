import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Movie} from "./movie.model";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Client} from "../../clients/shared/client.model";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private url = "http://localhost:8080/api/movies";

  constructor(private httpClient: HttpClient) { }

  getAllMovies(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(this.url);
  }

  saveMovie(movie: Movie): Observable<Movie> {
    return this.httpClient.post<Movie>(this.url, movie)
  }

  getMovie(id: number): Observable<Movie | undefined> {
    return this.getAllMovies()
      .pipe(
        map(movies => movies.find(movie => movie.id === id))
      );
  }

  update(movie: Movie): Observable<Movie> {
    const url = `${this.url}/${movie.id}`;
    return this.httpClient
      .put<Movie>(url, movie);
  }

  deleteMovie(id: number): Observable<any> {
    const url = `${this.url}/${id}`
    return this.httpClient.delete(url)
  }
}
