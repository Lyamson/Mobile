package ru.mirea.alyamovskiyvy.fragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    private static final String TAG = BlankFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Log.d(TAG, "onCreateView");
        TextView textView = view.findViewById(R.id.numTextView);
        textView.setText(String.valueOf(requireArguments().getInt("num")));
        return view;
    }
}