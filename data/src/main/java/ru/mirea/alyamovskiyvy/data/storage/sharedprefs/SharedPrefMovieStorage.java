package ru.mirea.alyamovskiyvy.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.time.LocalDate;

import ru.mirea.alyamovskiyvy.data.storage.models.Movie;
import ru.mirea.alyamovskiyvy.data.storage.MovieStorage;

public class SharedPrefMovieStorage implements MovieStorage {
    private static final String PREFS_NAME = "MoviePrefs";
    private static final String MOVIE_TITLE_KEY = "movie_title";
    private static final String MOVIE_ID_KEY = "movie_id";
    private static final String MOVIE_DATE_KEY = "movie_date";
    private SharedPreferences sharedPreferences;
    public SharedPrefMovieStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Movie get() {
        return new Movie(
                sharedPreferences.getInt(MOVIE_ID_KEY, 0),
                sharedPreferences.getString(MOVIE_TITLE_KEY, "null"),
                sharedPreferences.getString(MOVIE_DATE_KEY, String.valueOf(LocalDate.now()))
        );
    }

    @Override
    public boolean save(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(MOVIE_TITLE_KEY, movie != null ? movie.getName() : "null");
        editor.putInt(MOVIE_ID_KEY, movie != null ? movie.getId() : 0);
        editor.putString(MOVIE_DATE_KEY, String.valueOf(LocalDate.now()));

        editor.apply();
        return true;
    }
}
