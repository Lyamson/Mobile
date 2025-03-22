package ru.mirea.alyamovskiyvy.listviewapp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    private ImageView historyImageView;
    private TextView historyNameView;
    private TextView historyDescriptionView;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        historyImageView = itemView.findViewById(R.id.imageView);
        historyNameView = itemView.findViewById(R.id.textViewHistoryName);
        historyDescriptionView = itemView.findViewById(R.id.textViewDescription);
    }

    public ImageView getHistoryImageView() {
        return historyImageView;
    }

    public TextView getHistoryNameView() {
        return historyNameView;
    }

    public TextView getHistoryDescriptionView() {
        return historyDescriptionView;
    }
}
