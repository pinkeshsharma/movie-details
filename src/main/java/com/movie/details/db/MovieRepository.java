package com.movie.details.db;

import com.movie.details.db.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByTitle(String title);
    List<Movie> findByReleaseYear(int releaseYear);
    Optional<Movie> findById(String id);
    void deleteById(String id);
}
