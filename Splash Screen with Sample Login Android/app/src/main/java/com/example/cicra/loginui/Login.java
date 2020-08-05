package com.example.cicra.loginui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText uname,pw;
    com.rilixtech.materialfancybutton.MaterialFancyButton login, reset;
    CheckBox stay;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private Boolean saveLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



//initialize----------------------------------------------------------------------------------------
        uname = findViewById(R.id.un);
        pw = findViewById(R.id.pw);
        stay = findViewById(R.id.stay);
        login = findViewById(R.id.login);
        reset = findViewById(R.id.reset);
// set data using shredPreference-------------------------------------------------------------------

        pref = getSharedPreferences("login.conf", MODE_PRIVATE);
        editor = pref.edit();

        saveLogin = pref.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            uname.setText(pref.getString("username", ""));
            pw.setText(pref.getString("password", ""));
            stay.setChecked(true);
        }

//reset button--------------------------------------------------------------------------------------


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname.setText("");
                pw.setText("");
            }
        });


//login button--------------------------------------------------------------------------------------

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}
