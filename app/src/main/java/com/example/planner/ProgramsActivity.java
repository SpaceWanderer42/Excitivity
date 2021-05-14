package com.example.planner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProgramsActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView cooking;

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Cooking:
            default:
                intent = new Intent(this, cooking.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
        TextView welcome = findViewById(R.id.Welcome);
        SharedPreferences datasaver = getSharedPreferences("user_data", MODE_PRIVATE);
        String username = datasaver.getString("user","");
        welcome.setText("Welcome back, " + username + "!");
        cooking = (CardView) findViewById(R.id.Cooking);
        cooking.setOnClickListener(this);
        //getActionBar().setDisplayHomeAsUpEnabled(true);


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