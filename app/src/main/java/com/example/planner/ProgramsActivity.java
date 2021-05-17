package com.example.planner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class ProgramsActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView cooking;
    public CardView workout;
    public CardView self_care;
    public CardView study;

    @Override
    protected void onResume() {
        super.onResume();
        setActivitiesCompleted();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Cooking:
                intent = new Intent(this, Cooking.class);
                break;
            case R.id.Workout:
                intent = new Intent(this, Workout.class);
                break;
            case R.id.Self_Care:
                intent = new Intent(this, Self_Care.class);
                break;
            case R.id.Study:
                intent = new Intent(this, Study.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        TextView welcome = findViewById(R.id.Welcome);
        SharedPreferences datasaver = getSharedPreferences("user_data", MODE_PRIVATE);
        String username = datasaver.getString("user", "");
        welcome.setText("Welcome back, " + username + "!");

        setActivitiesCompleted();

        cooking = (CardView) findViewById(R.id.Cooking);
        cooking.setOnClickListener(this);

        workout = (CardView) findViewById(R.id.Workout);
        workout.setOnClickListener(this);

        self_care = (CardView) findViewById(R.id.Self_Care);
        self_care.setOnClickListener(this);

        study = (CardView) findViewById(R.id.Study);
        study.setOnClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ProgramsActivity.this, CreateActivity.class);
            startActivity(intent);
        });

    }

    public void openProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void setActivitiesCompleted() {
        int activitesNo = 0;
        TextView score = findViewById(R.id.Score);
        score.setText(String.valueOf(activitesNo));
        SharedPreferences dataSaver = getSharedPreferences("tasks", MODE_PRIVATE);
        ArrayList<String> baseActivities = new ArrayList<>(Arrays.asList("cooking", "study", "workout", "self_care"));
        for (String baseActivity:
             baseActivities) {
            for (int i = 1; i <= 7; i++) {
                String activityCode = baseActivity + i;
                if (dataSaver.getString(activityCode, "").equals("1"))
                    activitesNo++;
            }
        }
        score.setText(String.valueOf(activitesNo));
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivityForResult(myIntent, 0);
        //int id = item.getItemId();
        //if (id == android.R.id.home){
            //finish();
        //}
        //return true;
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionMenu(Menu menu) {
        return true;
    }
*/
}