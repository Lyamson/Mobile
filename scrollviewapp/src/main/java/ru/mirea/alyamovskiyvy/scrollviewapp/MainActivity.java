package ru.mirea.alyamovskiyvy.scrollviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout wrapper = findViewById(R.id.wrapper);
        for (int i = 0; i < 100; i++) {
            View view = getLayoutInflater().inflate(R.layout.item, null, false);
            TextView text = (TextView) view.findViewById(R.id.textView);
            text.setText(String.format("Элемент %d", (long) Math.pow(2, i - 1)));
            wrapper.addView(view);
        }
    }
}