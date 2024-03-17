import { Component, OnInit } from '@angular/core';
import { MovieService } from "../shared/movie.service";
import { Movie } from "../shared/movie.model";
import { Location } from "@angular/common";

@Component({
  selector: 'app-movie-new',
  templateUrl: './movie-new.component.html',
  styleUrls: ['./movie-new.component.css']
})
export class MovieNewComponent implements OnInit {

  constructor(private movieService: MovieService,
              private location: Location) { }

  ngOnInit(): void {
  }

  saveMovie(title: string, year: string, genre: string, rentalPrice: string) {
    console.log("save button clicked");

    const movie: Movie = {
      id: 0,
      title,
      year:Number(year),
      genre,
      rentalPrice:Number(rentalPrice),
    };

    this.movieService.saveMovie(movie)
      .subscribe(d => console.log("saved: ", d));
    this.location.back();
  }

  protected readonly Number = Number;
}
