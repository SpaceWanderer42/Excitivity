package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Display_Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_task);
        Button done = findViewById(R.id.button_done);
        TextView text = findViewById(R.id.Display_Task);
        Intent curr_intent = getIntent();
        String activity = curr_intent.getStringExtra("activity");
        switch (activity) {
            case "cooking1":
                text.setText("Try a new recipe");
                break;
            case "cooking2":
                text.setText("Prepare a meal inspired by a TV show or movie");
                break;
            case "cooking3":
                text.setText("Cook from a Pinterest recipe");
                break;
            case "cooking4":
                text.setText("Create your own smoothie");
                break;
            case "cooking5":
                text.setText("Bake a cake/your favorite treat");
                break;
            case "cooking6":
                text.setText("Cook a recipe from another country");
                break;
            case "cooking7":
                text.setText("Try to recreate your favorite drink");
                break;
        }
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity.startsWith("cooking")) {
                    SharedPreferences data = getSharedPreferences("tasks",MODE_PRIVATE);
                    SharedPreferences.Editor datasaver = data.edit();
                    datasaver.putString(activity, String.valueOf(1));
                    datasaver.commit();
                    Intent intent = new Intent(Display_Task.this, Cooking.class);
                    intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);;
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}