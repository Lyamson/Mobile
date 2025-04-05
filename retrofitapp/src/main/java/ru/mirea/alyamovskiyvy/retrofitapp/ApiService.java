package ru.mirea.alyamovskiyvy.retrofitapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @GET("todos?limit=0")
    Call<GetResponse> getTodos();
    @PUT("todos/{id}")
    Call<Todo> updateTodo(@Path("id") int id, @Body Todo updatedTodo);
}
