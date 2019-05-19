package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText usernameTxt, passwordTxt;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameTxt = (EditText) findViewById(R.id.username);
        passwordTxt = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        sharedPreferences = this.getSharedPreferences("remember", MainActivity.MODE_PRIVATE);
        if (sharedPreferences.getString("remember", "").isEmpty()) {
            btnLogin.setClickable(true);
        } else {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("remember", "berhasil");
                editor.commit();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });
    }
}