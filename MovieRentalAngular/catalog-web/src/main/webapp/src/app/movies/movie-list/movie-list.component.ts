import { Component, OnInit } from '@angular/core';
import {MovieService} from "../shared/movie.service";
import {Movie} from "../shared/movie.model";
import {Router} from "@angular/router";


@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  movies: Movie[] = []
  constructor(private movieService: MovieService,private router: Router) { }

  ngOnInit(): void {
    this.movieService.getAllMovies()
      .subscribe(d => this.movies = d)
  }

  deleteMovie(movie: Movie) {
    this.movieService.deleteMovie(movie.id)
      .subscribe(_ => console.log("movie deleted"))
    this.movies = this.movies.filter(d => d.id !== movie.id)
  }

  goToUpdateMovie(movieId: number): void {
    console.log("goToUpdateMovie clicked")
    this.router.navigate(['/movie/update', movieId]);
  }

}
