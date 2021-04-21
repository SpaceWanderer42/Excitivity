package com.example.planner.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.planner.MainActivity;
import com.example.planner.R;

public class PasswordInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_input);
        TextView welcomer = findViewById(R.id.welcomer);
        Button buton;
        buton= findViewById(R.id.login_buton);
        EditText inpass = findViewById(R.id.passwordinput);
        SharedPreferences datasaver = getSharedPreferences("user_data", MODE_PRIVATE);
        String username = datasaver.getString("user","");
        String password = datasaver.getString("pass","");
        welcomer.setText("  Welcome, " + username);
        buton.setOnClickListener(v ->{
            String aux;
            aux= inpass.getText().toString();
            if(aux.equals(password)){
                Intent intent = new Intent(PasswordInput.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){}
}