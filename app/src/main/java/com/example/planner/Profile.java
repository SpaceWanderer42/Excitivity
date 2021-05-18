package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Profile extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        setActivitiesCompleted();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setActivitiesCompleted();
    }

    public void openCalendar(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
}