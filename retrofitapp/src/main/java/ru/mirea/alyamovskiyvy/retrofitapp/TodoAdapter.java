package ru.mirea.alyamovskiyvy.retrofitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder>{
    private LayoutInflater layoutInflater;
    private List<Todo> todos;
    public TodoAdapter(Context context, List<Todo> todoList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
    }
    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
      viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view, (OnTodoCheckedChangeListener) layoutInflater.getContext());
    }
    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.bind(todo);
    }
    @Override
    public int getItemCount() {
        return todos.size();
    }
}
