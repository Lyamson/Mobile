package ru.mirea.alyamovskiyvy.domain.repository;

import ru.mirea.alyamovskiyvy.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
