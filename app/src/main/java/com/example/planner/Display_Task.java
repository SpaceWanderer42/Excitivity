package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Display_Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_task);
        TextView text = findViewById(R.id.Display_Task);
        Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        switch (activity) {
            case "cooking1":
                text.setText("Try a new recipe! :)");
                break;
            case "cooking2":
                text.setText("Make a homemade bread!");
                break;
        }
    }
}