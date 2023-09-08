package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView score;

    Button count;

    EditText komen;

    int TVscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.TVscore);
        count = findViewById(R.id.BTcount);
        komen = findViewById(R.id.ETkomen);

        count.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String currentScore = score.getText().toString();
        int currentScoreInt = Integer.valueOf(currentScore);
        
        TVscore = currentScoreInt +1;
        score.setText(String.valueOf(TVscore));

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(score.getText()));
    }

    @Override
    public void onRestoreInstanceState (Bundle mySavedState) {
        super.onRestoreInstanceState(mySavedState);
        if (mySavedState != null) {
            String count = mySavedState.getString("count");
            if (count != null) score.setText(count);
        }
    }
}