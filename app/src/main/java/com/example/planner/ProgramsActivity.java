package com.example.planner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ProgramsActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button3);
        button3 = (Button) findViewById(R.id.button4);
        button4 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                openCooking();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openSport();
            }

        });
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                openStudy();
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                openPhotography();
            }
        });

    }
    public void openCooking(){

        Intent intent = new Intent (this, Cooking.class);
        startActivity(intent);
    }
    public void openSport(){

        Intent intent = new Intent (this, Sport.class);
        startActivity(intent);
    }
    public void openStudy(){

        Intent intent = new Intent (this, Study.class);
        startActivity(intent);
    }
    public void openPhotography(){

        Intent intent = new Intent (this, Photography.class);
        startActivity(intent);
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