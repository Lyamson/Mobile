package ru.mirea.alyamovskiyvy.domain.usecases;

import ru.mirea.alyamovskiyvy.domain.models.Movie;
import ru.mirea.alyamovskiyvy.domain.repository.MovieRepository;

public class SaveFilmToFavouriteUseCase {
    private MovieRepository movieRepository;

    public SaveFilmToFavouriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie) {
        return movieRepository.saveMovie(movie);
    }
}
