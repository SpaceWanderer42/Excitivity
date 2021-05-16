package com.example.planner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class Workout extends AppCompatActivity implements View.OnClickListener {
    public CardView card1;
    public CardView card2;
    public CardView card3;
    public CardView card4;
    public CardView card5;
    public CardView card6;
    public CardView card7;

    public String baseString = "workout";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Workout.this, ProgramsActivity.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        card1 = (CardView) findViewById(R.id.Workout1);
        card1.setOnClickListener(this);
        card2 = (CardView) findViewById(R.id.Workout2);
        card2.setOnClickListener(this);
        card3 = (CardView) findViewById(R.id.Workout3);
        card3.setOnClickListener(this);
        card4 = (CardView) findViewById(R.id.Workout4);
        card4.setOnClickListener(this);
        card5 = (CardView) findViewById(R.id.Workout5);
        card5.setOnClickListener(this);
        card6 = (CardView) findViewById(R.id.Workout6);
        card6.setOnClickListener(this);
        card7 = (CardView) findViewById(R.id.Workout7);
        card7.setOnClickListener(this);
        SharedPreferences datasaver = getSharedPreferences("tasks", MODE_PRIVATE);
        if(datasaver.getString("workout1","").equals("1")) {
            card1.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("workout2","").equals("1")) {
            card2.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("workout3","").equals("1")) {
            card3.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("workout4","").equals("1")) {
            card4.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("workout5","").equals("1")) {
            card5.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("workout6","").equals("1")) {
            card6.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("workout7","").equals("1")) {
            card7.setCardBackgroundColor(0xFF77dd77);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Display_Task.class);
        switch (v.getId()) {
            case R.id.Workout1:
                intent.putExtra("activity", "workout1");
                break;
            case R.id.Workout2:
                intent.putExtra("activity", "workout2");
                break;
            case R.id.Workout3:
                intent.putExtra("activity", "workout3");
                break;
            case R.id.Workout4:
                intent.putExtra("activity", "workout4");
                break;
            case R.id.Workout5:
                intent.putExtra("activity", "workout5");
                break;
            case R.id.Workout6:
                intent.putExtra("activity", "workout6");
                break;
            case R.id.Workout7:
                intent.putExtra("activity", "workout7");
                break;
        }
        startActivity(intent);
        finish();
    }
}