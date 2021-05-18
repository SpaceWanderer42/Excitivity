package com.example.planner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ArrayList<EditText> inputs = new ArrayList<>(Arrays.asList(findViewById(R.id.Input1),
                findViewById(R.id.Input2),
                findViewById(R.id.Input3),
                findViewById(R.id.Input4),
                findViewById(R.id.Input5),
                findViewById(R.id.Input6),
                findViewById(R.id.Input7),
                findViewById(R.id.Input8)));
        Button button = findViewById(R.id.button_done);
        SharedPreferences sharedPreferences = getSharedPreferences("user_activity", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        button.setOnClickListener(v -> {
            boolean valid = true;
            for (EditText input : inputs) {
                String inputString = input.getText().toString();
                if (inputString.equals(""))
                    valid = false;
            }
            if (valid) {
                for (int i = 0; i < inputs.size(); i++) {
                    String inputString = inputs.get(i).getText().toString();
                    String saveString = "input" + i;
                    editor.putString(saveString, inputString);
                    editor.apply();
                }
                Intent intent = new Intent(CreateActivity.this, ProgramsActivity.class);
                startActivity(intent);
                finish();
            } else {
                TextView error = findViewById(R.id.Erorr);
                error.setText("Please complete all fields!");
                Handler handler = new Handler();
                handler.postDelayed(() -> error.setText(""), 5000);
            }
        });

    }
}