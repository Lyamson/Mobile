package ru.mirea.alyamovskiyvy.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnTodoCheckedChangeListener{
    public static final String TAG = "MainActivity";
    public static final String BASE_URL = "https://dummyjson.com/";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private	TodoAdapter	todoAdapter;
    private	ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
        Call<GetResponse> call = apiService.getTodos();
        call.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Todo> todos = response.body().getTodos();
                    todoAdapter = new TodoAdapter(MainActivity.this, todos);
                    recyclerView.setAdapter(todoAdapter);
                }
                else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable throwable) {
                Log.e(TAG, "onFailure: " + throwable.getMessage());
            }
        });
    }

    @Override
    public void onTodoCheckedChanged(int todoId, boolean isCompleted) {
        Todo todo = new Todo();
        todo.setCompleted(isCompleted);
        Call<Todo> call = apiService.updateTodo(todoId, todo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Todo updated: " + response.body().getCompleted());
                }
                else {
                    Log.e(TAG, "Todo update error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable throwable) {
                Log.e(TAG, "Todo update failure: " + throwable.getMessage());
            }
        });
    }
}

