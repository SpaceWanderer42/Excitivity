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
            case "workout1":
                text.setText("20 sit ups, 20 squats, 10 push ups, 30 sec plank");
                break;
            case "workout2":
                text.setText("15 burpees, 15 leg raises, 20 jumping jacks");
                break;
            case "workout3":
                text.setText("30 squats, 20 push ups, 25 mountain climbers");
                break;
            case "workout4":
                text.setText("35 sec plank, 25 leg raises, 25 crunches");
                break;
            case "workout5":
                text.setText("25 burpees, 35 leg raises, 40 jumping jacks, 40 sec wall sit");
                break;
            case "workout6":
                text.setText("30 mountain climbers, 35 squats, 40 sec plank");
                break;
            case "workout7":
                text.setText("Rest day");
                break;
            case "self_care1":
                text.setText("Catch up on your favourite TV show");
                break;
            case "self_care2":
                text.setText("Journal, log your emotions and experiences");
                break;
            case "self_care3":
                text.setText("Practice a hobby you really enjoy");
                break;
            case "self_care4":
                text.setText("Call your friends and family");
                break;
            case "self_care5":
                text.setText("Listen to your fav songs");
                break;
            case "self_care6":
                text.setText("Take a nap");
                break;
            case "self_care7":
                text.setText("Meditate - calm your mind anxiety");
                break;
            case "study1":
                text.setText("Have a schedule and always take notes");
                break;
            case "study2":
                text.setText("Study for 30 minutes at a time");
                break;
            case "study3":
                text.setText("Use colors and highlighters in your notes");
                break;
            case "study4":
                text.setText("Use apps or flash cards for better learning");
                break;
            case "study5":
                text.setText("Choose a quiet study place without distractions");
                break;
            case "study6":
                text.setText("Summarize concepts");
                break;
            case "study7":
                text.setText("Use mind maps to organise information");
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
                if(activity.startsWith("workout")) {
                    SharedPreferences data = getSharedPreferences("tasks",MODE_PRIVATE);
                    SharedPreferences.Editor datasaver = data.edit();
                    datasaver.putString(activity, String.valueOf(1));
                    datasaver.commit();
                    Intent intent = new Intent(Display_Task.this, Workout.class);
                    intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);;
                    startActivity(intent);
                    finish();
                }
                if(activity.startsWith("self_care")) {
                    SharedPreferences data = getSharedPreferences("tasks",MODE_PRIVATE);
                    SharedPreferences.Editor datasaver = data.edit();
                    datasaver.putString(activity, String.valueOf(1));
                    datasaver.commit();
                    Intent intent = new Intent(Display_Task.this, Self_Care.class);
                    intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);;
                    startActivity(intent);
                    finish();
                }
                if(activity.startsWith("study")) {
                    SharedPreferences data = getSharedPreferences("tasks",MODE_PRIVATE);
                    SharedPreferences.Editor datasaver = data.edit();
                    datasaver.putString(activity, String.valueOf(1));
                    datasaver.commit();
                    Intent intent = new Intent(Display_Task.this, Study.class);
                    intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);;
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}