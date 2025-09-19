package com.movie.details.dto;

import com.movie.details.db.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {
    int responseCode;
    String id;
    List<Movie> movies;

    public ServiceResponse(int responseCode, String id) {
        this.responseCode = responseCode;
        this.id = id;
    }

    public ServiceResponse(int responseCode, List<Movie> movies) {
        this.responseCode = responseCode;
        this.movies = movies;
    }
}
