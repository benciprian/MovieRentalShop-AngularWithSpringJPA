package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();


    Movie addMovie(Movie movie);

    Movie updateMovie(Movie movie);

    void deleteMovie(Long id);

}
