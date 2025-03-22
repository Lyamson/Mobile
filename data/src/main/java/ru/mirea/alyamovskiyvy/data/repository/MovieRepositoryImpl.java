package ru.mirea.alyamovskiyvy.data.repository;

import java.time.LocalDate;

import ru.mirea.alyamovskiyvy.data.storage.models.Movie;
import ru.mirea.alyamovskiyvy.data.storage.MovieStorage;
import ru.mirea.alyamovskiyvy.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
    private MovieStorage movieStorage;
    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    public boolean saveMovie(ru.mirea.alyamovskiyvy.domain.models.Movie movie) {
        return movieStorage.save(mapToStorage(movie));
    }

    public ru.mirea.alyamovskiyvy.domain.models.Movie getMovie() {
        return mapToDomain(movieStorage.get());
    }

    private Movie mapToStorage(ru.mirea.alyamovskiyvy.domain.models.Movie movie) {
        return new Movie(
                movie.getId(),
                movie.getName(),
                String.valueOf(LocalDate.now())
        );
    }

    private ru.mirea.alyamovskiyvy.domain.models.Movie mapToDomain(Movie movie) {
        return new ru.mirea.alyamovskiyvy.domain.models.Movie(
                movie.getId(),
                movie.getName()
        );
    }
}
