package com.agafonova.javajokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private TextView mJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        mJokes = findViewById(R.id.tv_jokes);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        if (getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            String jokeText = extras.getString(Intent.EXTRA_TEXT);

            if (jokeText != null) {
                mJokes.setText(jokeText);
            }
        }
        else {
            return;
        }
    }
}
