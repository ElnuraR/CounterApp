package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.counter.R;

public class MainActivity extends AppCompatActivity {

    static final String GAME_STATE_KEY = "state";

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recovering the instance state
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(GAME_STATE_KEY);
            displayCounter(count);
        }
    }

    public void displayCounter(int count) {
        TextView counter = findViewById(R.id.counter);
        String strCounter = counter.getText().toString();

        strCounter = String.format("%04d",count);
        counter.setText(strCounter);
    }

    public void increment(View view) {
        count++;
        displayCounter(count);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(GAME_STATE_KEY, count);
    }
}