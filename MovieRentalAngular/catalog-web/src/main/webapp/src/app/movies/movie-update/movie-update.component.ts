import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import { MovieService } from '../shared/movie.service';
import { Movie } from '../shared/movie.model';
import { Location } from '@angular/common';
import {switchMap} from "rxjs";
import {Client} from "../../clients/shared/client.model";
import {ClientService} from "../../clients/shared/client.service";

@Component({
  selector: 'app-movie-update',
  templateUrl: './movie-update.component.html',
  styleUrls: ['./movie-update.component.css']
})
export class MovieUpdateComponent implements OnInit {
  @Input() movie!: Movie;
  constructor(private movieService: MovieService,
              private route: ActivatedRoute,
              private router: Router,
              private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.movieService.getMovie(+params['id'])))
      .subscribe(movie => this.movie = movie ?? <Movie>{});
  }

  goBack(): void {
    this.location.back();
  }

  saveMovie(): void {
    this.movieService.update(this.movie)
      .subscribe(_ => {
        console.log('Movie saved successfully');
        this.goBack();
      });
  }

}
