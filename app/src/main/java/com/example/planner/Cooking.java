package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
        cooking1 = (CardView) findViewById(R.id.Cooking1);
        cooking1.setOnClickListener(this);
        cooking2 = (CardView) findViewById(R.id.Cooking2);
        cooking2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Display_Task.class);
        switch (v.getId()) {
            case R.id.Cooking1:
                intent.putExtra("activity", "cooking1");
                break;
            case R.id.Cooking2:
            default:
                intent.putExtra("activity", "cooking2");

                break;
        }
        startActivity(intent);
    }
}