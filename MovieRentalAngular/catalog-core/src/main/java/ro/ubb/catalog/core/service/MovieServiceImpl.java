package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.core.repository.ClientRepository;
import ro.ubb.catalog.core.repository.MovieRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService{
    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    @Override
    public Movie addMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }


    @Transactional
    @Override
    public Movie updateMovie(Movie movie) {
        Movie movieToUpdate = this.movieRepository.findById(movie.getId())
                .orElse(new Movie());

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setYear(movie.getYear());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setRentalPrice(movie.getRentalPrice());


        return movieToUpdate;
    }

    @Override
    public void deleteMovie(Long id) {
        this.movieRepository.deleteById(id);
    }
}
