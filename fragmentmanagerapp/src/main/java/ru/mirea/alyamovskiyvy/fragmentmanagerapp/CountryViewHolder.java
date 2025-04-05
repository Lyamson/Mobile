package ru.mirea.alyamovskiyvy.fragmentmanagerapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    TextView countryTextView;
    ShareViewModel viewModel;
    public CountryViewHolder(@NonNull View itemView, ShareViewModel viewModel) {
        super(itemView);
        countryTextView = itemView.findViewById(R.id.content);
        this.viewModel = viewModel;
    }

    public void bind(String country) {
        countryTextView.setText(country);
        countryTextView.setOnClickListener(v -> {
            viewModel.setSelectedItem(((TextView)v).getText().toString());
        });
    }
}
