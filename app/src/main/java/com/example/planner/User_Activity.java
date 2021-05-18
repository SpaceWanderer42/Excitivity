package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;

public class User_Activity extends AppCompatActivity implements View.OnClickListener {
    public CardView card1;
    public CardView card2;
    public CardView card3;
    public CardView card4;
    public CardView card5;
    public CardView card6;
    public CardView card7;

    public String baseString = "user_activity";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(User_Activity.this, ProgramsActivity.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        card1 = (CardView) findViewById(R.id.user_activity1);
        card1.setOnClickListener(this);
        card2 = (CardView) findViewById(R.id.user_activity2);
        card2.setOnClickListener(this);
        card3 = (CardView) findViewById(R.id.user_activity3);
        card3.setOnClickListener(this);
        card4 = (CardView) findViewById(R.id.user_activity4);
        card4.setOnClickListener(this);
        card5 = (CardView) findViewById(R.id.user_activity5);
        card5.setOnClickListener(this);
        card6 = (CardView) findViewById(R.id.user_activity6);
        card6.setOnClickListener(this);
        card7 = (CardView) findViewById(R.id.user_activity7);
        card7.setOnClickListener(this);
        SharedPreferences datasaver = getSharedPreferences("tasks", MODE_PRIVATE);
        if(datasaver.getString("user1","").equals("1")) {
            card1.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("user2","").equals("1")) {
            card2.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("user3","").equals("1")) {
            card3.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("user4","").equals("1")) {
            card4.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("user5","").equals("1")) {
            card5.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("user6","").equals("1")) {
            card6.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("user7","").equals("1")) {
            card7.setCardBackgroundColor(0xFF77dd77);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Display_Task.class);
        switch (v.getId()) {
            case R.id.user_activity1:
                intent.putExtra("activity", "user1");
                break;
            case R.id.user_activity2:
                intent.putExtra("activity", "user2");
                break;
            case R.id.user_activity3:
                intent.putExtra("activity", "user3");
                break;
            case R.id.user_activity4:
                intent.putExtra("activity", "user4");
                break;
            case R.id.user_activity5:
                intent.putExtra("activity", "user5");
                break;
            case R.id.user_activity6:
                intent.putExtra("activity", "user6");
                break;
            case R.id.user_activity7:
                intent.putExtra("activity", "user7");
                break;
        }
        startActivity(intent);
        finish();
    }
}