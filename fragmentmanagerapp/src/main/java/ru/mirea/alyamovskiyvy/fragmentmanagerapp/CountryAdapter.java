package ru.mirea.alyamovskiyvy.fragmentmanagerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    LayoutInflater layoutInflater;
    List<String> countries;
    ShareViewModel viewModel;
    public CountryAdapter(Context context, ShareViewModel viewModel) {
        layoutInflater = LayoutInflater.from(context);
        this.countries = viewModel.getCountries();
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.fragment_item, parent, false);
        return new CountryViewHolder(view, viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
