package com.movie.details.service;

import com.movie.details.db.MovieRepository;
import com.movie.details.db.entity.Movie;
import com.movie.details.dto.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setReleaseYear(movieRequest.getReleaseYear());
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getByReleaseYear(int releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }

    public Optional<Movie> getById(String id) {
        return movieRepository.findById(id);
    }

    public Movie updateMovie(String id, MovieRequest movieRequest) {
        Optional<Movie> movie = getById(id);
        if (movie.isPresent()) {
            movie.get().setTitle(movieRequest.getTitle());
            movie.get().setReleaseYear(movieRequest.getReleaseYear());
            movieRepository.save(movie.get());
        } else {
            movie = Optional.of(new Movie());
            movie.get().setTitle(movieRequest.getTitle());
            movie.get().setReleaseYear(movieRequest.getReleaseYear());
            movieRepository.save(movie.get());
        }
        return movie.get();
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
