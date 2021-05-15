package com.example.planner.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planner.ProgramsActivity;
import com.example.planner.R;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView welcomer = findViewById(R.id.welcomer);
        Button buton;
        buton= findViewById(R.id.login_buton);
        EditText inpass = findViewById(R.id.passwordinput);
        SharedPreferences datasaver = getSharedPreferences("user_data", MODE_PRIVATE);
        String username = datasaver.getString("user","");
        String password = datasaver.getString("pass","");
        TextView error = findViewById(R.id.Erorr);
        welcomer.setText("  Welcome, " + username + "!");
        buton.setOnClickListener(v ->{
            String aux;
            aux= inpass.getText().toString();
            if(aux.equals(password)){
                Intent intent = new Intent(LogInActivity.this, ProgramsActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                if (!aux.equals("")){
                    error.setText("Password is incorrect!");
                Handler handler = new Handler();
                handler.postDelayed(() -> error.setText(""), 5000);
             }
            }
        });
    }
    @Override
    public void onBackPressed(){}
}