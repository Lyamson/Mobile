package ru.mirea.alyamovskiyvy.movieproject.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.alyamovskiyvy.domain.models.Movie;
import ru.mirea.alyamovskiyvy.domain.repository.MovieRepository;
import ru.mirea.alyamovskiyvy.domain.usecases.GetFavouriteFilmUseCase;
import ru.mirea.alyamovskiyvy.domain.usecases.SaveFilmToFavouriteUseCase;

public class MainViewModel extends ViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();
    private MovieRepository movieRepository;
    private MutableLiveData<String> favMovie = new MutableLiveData<>();

    public MainViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    protected void onCleared() {
        Log.d(TAG, "MainViewModel Cleared");
        super.onCleared();
    }

    public void setText(Movie movie) {
        Boolean result = new SaveFilmToFavouriteUseCase(movieRepository).execute(movie);
        favMovie.setValue(result.toString());
    }

    public void getText() {
        Movie movie = new GetFavouriteFilmUseCase(movieRepository).execute();
        favMovie.setValue(String.format("My favourite movie is %s", movie.getName()));
    }

    public MutableLiveData<String> getFavMovie() {
        return favMovie;
    }
}
