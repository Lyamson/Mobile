package ru.mirea.alyamovskiyvy.domain.usecases;

import ru.mirea.alyamovskiyvy.domain.repository.MovieRepository;
import ru.mirea.alyamovskiyvy.domain.models.Movie;

public class GetFavouriteFilmUseCase {
    private MovieRepository movieRepository;

    public GetFavouriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute() {
        return movieRepository.getMovie();
    }
}
