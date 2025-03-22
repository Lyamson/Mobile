package ru.mirea.alyamovskiyvy.listviewapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    private List<History> histories;
    private Context context;

    public HistoryRecyclerViewAdapter(List<History> histories) {
        this.histories = histories;
    }
    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View recyclerViewItem = LayoutInflater.from(context)
                .inflate(R.layout.history_item_view, parent, false);
        return new HistoryViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History history = histories.get(position);
        String pkgName = context.getPackageName();

        int resID = context.getResources()
                .getIdentifier(history.getHistoryImageName(), "mipmap", pkgName);
        holder.getHistoryImageView().setImageResource(resID);
        holder.getHistoryNameView().setText(history.getHistoryName());
        holder.getHistoryDescriptionView().setText(history.getDescription());
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }
}
