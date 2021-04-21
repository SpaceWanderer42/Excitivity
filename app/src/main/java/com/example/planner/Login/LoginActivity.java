package com.example.planner.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planner.MainActivity;
import com.example.planner.R;

import android.os.Bundle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    String password,username;
    public boolean checkPasswordConstraints(String proposedPass){
        boolean isokay = true;
        Pattern pattern = Pattern.compile(".*\\s.*");
        Matcher matcher = pattern.matcher(proposedPass);
        boolean foundspace = matcher.find();
        if(foundspace == true){
            isokay = false;
            //error message, password contains empty spaces.
        }
        if(proposedPass.length()<= 6){//at least 6 characters for
            isokay = false;
        }
        Pattern pattern2 = Pattern.compile(".*[0-9]+.*");//regex matching any character that appear 0 or more time then a digit that appear at least once then any character zero or more times
        Matcher matcher2 = pattern2.matcher(proposedPass);//must contain at least one digit
        boolean founddigit = matcher2.find();
        if(founddigit == false){
            isokay = false;
        }
        return isokay;
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
                    datasaver.putString("user",inuser);
                    datasaver.putString("pass",inpass);
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
}
//SharedPreferences.Editor editor = pref.edit();
// editor.putBoolean("firststart", false);
//editor.commit();