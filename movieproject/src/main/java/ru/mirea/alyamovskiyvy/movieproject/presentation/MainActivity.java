package ru.mirea.alyamovskiyvy.movieproject.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.alyamovskiyvy.data.repository.MovieRepositoryImpl;
import ru.mirea.alyamovskiyvy.data.storage.MovieStorage;
import ru.mirea.alyamovskiyvy.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.alyamovskiyvy.domain.models.Movie;
import ru.mirea.alyamovskiyvy.domain.repository.MovieRepository;
import ru.mirea.alyamovskiyvy.domain.usecases.GetFavouriteFilmUseCase;
import ru.mirea.alyamovskiyvy.domain.usecases.SaveFilmToFavouriteUseCase;
import ru.mirea.alyamovskiyvy.movieproject.R;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextFavMovie);
        TextView textView = findViewById(R.id.textViewFavMovie);

        Log.d(TAG, "MainActivity Created");
        mainViewModel = new ViewModelProvider(
                this,
                new ViewModelFactory(this)
        ).get(MainViewModel.class);

        mainViewModel.getFavMovie().observe(
                this,
                newText -> textView.setText(newText)
        );

        findViewById(R.id.buttonSaveFavMovie).setOnClickListener(view -> {
            mainViewModel.setText(new Movie(0, text.getText().toString()));
        });

        findViewById(R.id.buttonShowFavMovie).setOnClickListener(view -> {
            mainViewModel.getText();
        });
    }
}