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

public class Self_Care extends AppCompatActivity implements View.OnClickListener {
    public CardView card1;
    public CardView card2;
    public CardView card3;
    public CardView card4;
    public CardView card5;
    public CardView card6;
    public CardView card7;

    public String baseString = "self_care";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Self_Care.this, ProgramsActivity.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_care);
        card1 = (CardView) findViewById(R.id.Self_Care1);
        card1.setOnClickListener(this);
        card2 = (CardView) findViewById(R.id.Self_Care2);
        card2.setOnClickListener(this);
        card3 = (CardView) findViewById(R.id.Self_Care3);
        card3.setOnClickListener(this);
        card4 = (CardView) findViewById(R.id.Self_Care4);
        card4.setOnClickListener(this);
        card5 = (CardView) findViewById(R.id.Self_Care5);
        card5.setOnClickListener(this);
        card6 = (CardView) findViewById(R.id.Self_Care6);
        card6.setOnClickListener(this);
        card7 = (CardView) findViewById(R.id.Self_Care7);
        card7.setOnClickListener(this);
        SharedPreferences datasaver = getSharedPreferences("tasks", MODE_PRIVATE);
        if(datasaver.getString("self_care1","").equals("1")) {
            card1.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("self_care2","").equals("1")) {
            card2.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("self_care3","").equals("1")) {
            card3.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("self_care4","").equals("1")) {
            card4.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("self_care5","").equals("1")) {
            card5.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("self_care6","").equals("1")) {
            card6.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("self_care7","").equals("1")) {
            card7.setCardBackgroundColor(0xFF77dd77);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Display_Task.class);
        switch (v.getId()) {
            case R.id.Self_Care1:
                intent.putExtra("activity", "self_care1");
                break;
            case R.id.Self_Care2:
                intent.putExtra("activity", "self_care2");
                break;
            case R.id.Self_Care3:
                intent.putExtra("activity", "self_care3");
                break;
            case R.id.Self_Care4:
                intent.putExtra("activity", "self_care4");
                break;
            case R.id.Self_Care5:
                intent.putExtra("activity", "self_care5");
                break;
            case R.id.Self_Care6:
                intent.putExtra("activity", "self_care6");
                break;
            case R.id.Self_Care7:
                intent.putExtra("activity", "self_care7");
                break;
        }
        startActivity(intent);
        finish();
    }
}