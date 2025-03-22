package ru.mirea.alyamovskiyvy.listviewapp2;

import androidx.annotation.NonNull;

public class History {
    private String historyName;
    private String historyImageName;
    private String description;

    public History(String historyName, String historyImageName, String description) {
        this.historyName = historyName;
        this.historyImageName = historyImageName;
        this.description = description;
    }

    public String getHistoryName() {
        return historyName;
    }

    public String getHistoryImageName() {
        return historyImageName;
    }

    public String getDescription() {
        return description;
    }

    @NonNull
    @Override
    public String toString() {
        return historyName + " (Population: " + description + ")";
    }
}
