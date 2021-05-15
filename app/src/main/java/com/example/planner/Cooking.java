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

public class Cooking extends AppCompatActivity implements View.OnClickListener {
    public CardView cooking1;
    public CardView cooking2;
    public CardView cooking3;
    public CardView cooking4;
    public CardView cooking5;
    public CardView cooking6;
    public CardView cooking7;
    public CardView cooking8;
    public CardView cooking9;
    public CardView cooking10;
    public CardView cooking11;
    public CardView cooking12;
    public CardView cooking13;
    public CardView cooking14;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Cooking.this, ProgramsActivity.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
        cooking1 = (CardView) findViewById(R.id.Cooking1);
        cooking1.setOnClickListener(this);
        cooking2 = (CardView) findViewById(R.id.Cooking2);
        cooking2.setOnClickListener(this);
        SharedPreferences datasaver = getSharedPreferences("tasks", MODE_PRIVATE);
        if(datasaver.getString("cooking1","").equals("1")) {
            cooking1.setCardBackgroundColor(0xff328ca8);
        }
        if(datasaver.getString("cooking2","").equals("1")) {
            cooking2.setCardBackgroundColor(0xff328ca8);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        /*<meta-data
        android:name="android.support.PARENT_ACTIVITY"
        android:value="MainActivity" />*/

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Display_Task.class);
        switch (v.getId()) {
            case R.id.Cooking1:
                intent.putExtra("activity", "cooking1");
                break;
            case R.id.Cooking2:
                intent.putExtra("activity", "cooking2");
                break;
            case R.id.Cooking3:
                intent.putExtra("activity", "cooking3");
                break;
            case R.id.Cooking4:
                intent.putExtra("activity", "cooking4");
                break;
            case R.id.Cooking5:
                intent.putExtra("activity", "cooking5");
                break;
            case R.id.Cooking6:
                intent.putExtra("activity", "cooking6");
                break;
            case R.id.Cooking7:
                intent.putExtra("activity", "cooking7");
                break;
        }
        startActivity(intent);
        finish();
    }
}