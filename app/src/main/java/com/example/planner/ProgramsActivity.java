package com.example.planner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.planner.Login.LogInActivity;

public class ProgramsActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView cooking;

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Cooking:
            default:
                intent = new Intent(this, Cooking.class);
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
        String username = datasaver.getString("user", "");
        welcome.setText("Welcome back, " + username + "!");

        cooking = (CardView) findViewById(R.id.Cooking);
        cooking.setOnClickListener(this);

    }

    public void openCalendar(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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