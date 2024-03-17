package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.core.service.MovieService;
import ro.ubb.catalog.web.converter.MovieConverter;
import ro.ubb.catalog.web.dto.ClientDto;
import ro.ubb.catalog.web.dto.MovieDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class MovieController {
    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Set<MovieDto> getMovies() {
        List<Movie> movies = movieService.getAllMovies();
        Set<MovieDto> movieDtos = movieConverter.convertModelsToDtos(movies);
        return movieDtos;
    }


    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    MovieDto saveStudent(@RequestBody MovieDto dto) {
        return movieConverter.convertModelToDto(
                movieService.addMovie(
                        movieConverter.convertDtoToModel(dto)
                )
        );
    }

//    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
//    MovieDto updateMovie(@PathVariable Long id, @RequestBody MovieDto dto) {
//
//        return movieConverter.convertModelToDto(
//                movieService.updateMovie(
//                        movieConverter.convertDtoToModel(dto)
//                ));
//    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.PUT)
    public MovieDto updateMovie(
            @PathVariable final Long movieId,
            @RequestBody final MovieDto movieDto) {
        log.trace("updateMovie: movieId={}, movieDtoMap={}", movieId, movieDto);

        Movie movie = new Movie();
        // Setarea proprietăților obiectului movie
        movie.setId(movieId);
        movie.setTitle(movieDto.getTitle());
        movie.setYear(movieDto.getYear());
        movie.setGenre(movieDto.getGenre());
        movie.setRentalPrice(movieDto.getRentalPrice());


        // Apelarea metodei updateMovie din MovieService
        Movie updatedMovie = movieService.updateMovie(movie);

        // Convertirea obiectului Movie la MovieDto
        MovieDto result = movieConverter.convertModelToDto(updatedMovie);

        log.trace("updateMovie: result={}", result);
        //returnează MovieDto
        return result;
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
