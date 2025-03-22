package ru.mirea.alyamovskiyvy.data.storage;


import ru.mirea.alyamovskiyvy.data.storage.models.Movie;

public interface MovieStorage {
    public Movie get();
    public boolean save(Movie movie);
}
