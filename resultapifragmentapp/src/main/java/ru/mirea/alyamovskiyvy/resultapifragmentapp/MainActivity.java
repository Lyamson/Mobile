package ru.mirea.alyamovskiyvy.resultapifragmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().setFragmentResultListener(
                "requestKey",
                this,
                (requestKey, bundle) -> {
                    String result = bundle.getString("key");
                    Log.d(BottomSheetFragment.class.getSimpleName(), "Im MainActivity" + result);
                }
        );
    }

    @Override
    public void sendResult(String message) {
        Log.d(MainActivity.class.getSimpleName(), "message: " + message);
    }
}