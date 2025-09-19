package com.movie.details.controller;

import com.movie.details.db.entity.Movie;
import com.movie.details.dto.MovieRequest;
import com.movie.details.dto.ServiceResponse;
import com.movie.details.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public ServiceResponse createMovie(@RequestBody MovieRequest movieRequest) {
        Movie movie = movieService.createMovie(movieRequest);
        return new ServiceResponse(200, List.of(movie));
    }

    @GetMapping("/getAll")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/getByTitle/{title}")
    public ServiceResponse getMovieByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.getByTitle(title);
        return new ServiceResponse(200, movies);
    }

    @GetMapping("/getById/{id}")
    public ServiceResponse getMovieById(@PathVariable String id) {
        Movie movie = movieService.getById(id).orElseThrow(() -> new RuntimeException("Movie not found"));;
        return new ServiceResponse(200, List.of(movie));
    }

    @GetMapping("/getByYear/{year}")
    public ServiceResponse getMovieByReleaseYear(@PathVariable int year) {
        List<Movie> movies = movieService.getByReleaseYear(year);
        return new ServiceResponse(200, movies);
    }

    @PutMapping("/update/{id}")
    public ServiceResponse updateMovie(@PathVariable String id, @RequestBody MovieRequest movieRequest) {
        Movie movie  = movieService.updateMovie(id, movieRequest);
        return new ServiceResponse(200, List.of(movie));
    }

    @DeleteMapping("/delete/{id}")
    public ServiceResponse deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        return new ServiceResponse(200, id);
    }
}
