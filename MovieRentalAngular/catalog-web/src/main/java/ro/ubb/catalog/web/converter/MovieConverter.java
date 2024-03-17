package ro.ubb.catalog.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.web.dto.ClientDto;
import ro.ubb.catalog.web.dto.MovieDto;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto>{
    private static final Logger log = LoggerFactory.getLogger(MovieConverter.class);
    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .year(dto.getYear())
                .genre(dto.getGenre())
                .rentalPrice(dto.getRentalPrice())
                .build();
        return movie;
    }
    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .year(movie.getYear())
                .genre(movie.getGenre())
                .rentalPrice(movie.getRentalPrice())
                .build();
        return movieDto;
    }

}
