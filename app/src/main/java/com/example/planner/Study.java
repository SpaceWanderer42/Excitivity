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

public class Study extends AppCompatActivity implements View.OnClickListener {
    public CardView card1;
    public CardView card2;
    public CardView card3;
    public CardView card4;
    public CardView card5;
    public CardView card6;
    public CardView card7;

    public String baseString = "study";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Study.this, ProgramsActivity.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        card1 = (CardView) findViewById(R.id.Study1);
        card1.setOnClickListener(this);
        card2 = (CardView) findViewById(R.id.Study2);
        card2.setOnClickListener(this);
        card3 = (CardView) findViewById(R.id.Study3);
        card3.setOnClickListener(this);
        card4 = (CardView) findViewById(R.id.Study4);
        card4.setOnClickListener(this);
        card5 = (CardView) findViewById(R.id.Study5);
        card5.setOnClickListener(this);
        card6 = (CardView) findViewById(R.id.Study6);
        card6.setOnClickListener(this);
        card7 = (CardView) findViewById(R.id.Study7);
        card7.setOnClickListener(this);
        SharedPreferences datasaver = getSharedPreferences("tasks", MODE_PRIVATE);
        if(datasaver.getString("study1","").equals("1")) {
            card1.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("study2","").equals("1")) {
            card2.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("study3","").equals("1")) {
            card3.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("study4","").equals("1")) {
            card4.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("study5","").equals("1")) {
            card5.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("study6","").equals("1")) {
            card6.setCardBackgroundColor(0xFF77dd77);
        }
        if(datasaver.getString("study7","").equals("1")) {
            card7.setCardBackgroundColor(0xFF77dd77);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Display_Task.class);
        switch (v.getId()) {
            case R.id.Study1:
                intent.putExtra("activity", "study1");
                break;
            case R.id.Study2:
                intent.putExtra("activity", "study2");
                break;
            case R.id.Study3:
                intent.putExtra("activity", "study3");
                break;
            case R.id.Study4:
                intent.putExtra("activity", "study4");
                break;
            case R.id.Study5:
                intent.putExtra("activity", "study5");
                break;
            case R.id.Study6:
                intent.putExtra("activity", "study6");
                break;
            case R.id.Study7:
                intent.putExtra("activity", "study7");
                break;
        }
        startActivity(intent);
        finish();
    }
}