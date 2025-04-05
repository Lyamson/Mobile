package ru.mirea.alyamovskiyvy.retrofitapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textViewTitle;
    CheckBox checkBoxCompleted;
    OnTodoCheckedChangeListener listener;
    Todo todo;
    public TodoViewHolder(@NonNull View itemView, OnTodoCheckedChangeListener listener) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        checkBoxCompleted = itemView.findViewById(R.id.checkBoxCompleted);
        imageView = itemView.findViewById(R.id.todoImage);
        this.listener = listener;
    }

    public void bind(Todo todo) {
        this.todo = todo;
        Picasso.get()
            .load("https://dummyjson.com/image/350x200/?text=" + todo.getId())
            .error(R.drawable.error)
            .placeholder(R.drawable.loading)
            .resize(61, 35)
            .centerCrop()
            .into(imageView);
        textViewTitle.setText(todo.getTodo());
        checkBoxCompleted.setChecked(todo.getCompleted());
        checkBoxCompleted.setOnCheckedChangeListener((buttonView, isChecked) ->
        {
            if (todo != null) {
                listener.onTodoCheckedChanged(todo.getId(), checkBoxCompleted.isChecked());
            }
        });
    }
}
