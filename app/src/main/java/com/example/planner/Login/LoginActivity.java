package com.example.planner.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planner.MainActivity;
import com.example.planner.R;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    String password,username;
    public boolean checkPasswordConstraints(String proposedPass){
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = "";
        username = "";
        Button signin;
        EditText user,pass,copass;
        signin = findViewById(R.id.signup);
        user = findViewById(R.id.username);
        pass= findViewById(R.id.password);
        copass = findViewById(R.id.password_confirm);
        signin.setOnClickListener(v -> {
            String inuser = user.getText().toString();
            String inpass = pass.getText().toString();
            String incopass = copass.getText().toString();
            if(incopass.equals(inpass))
            {

                if(checkPasswordConstraints(inpass) && (inpass.equals("")==false) && (inuser.equals("")==false)){
                    SharedPreferences pref = getSharedPreferences("preference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("firststart", false);
                    editor.commit();
                    SharedPreferences data = getSharedPreferences("user_data",MODE_PRIVATE);
                    SharedPreferences.Editor datasaver = data.edit();
                    datasaver.putString("pass/user",inpass + "/" +inuser);
                    datasaver.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    //intent.putExtra("User", usernameEditText.getText().toString()+"");
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){}//don't go back if the back button is pressed
    public void SaveData(){}
}
//SharedPreferences.Editor editor = pref.edit();
// editor.putBoolean("firststart", false);
//editor.commit();