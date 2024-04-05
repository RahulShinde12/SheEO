package com.capcun.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUp1 extends AppCompatActivity {

    EditText email, password, username;
    TextView sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTheme(R.style.StatusBarTheme);
        }
        setContentView(R.layout.activity_sign_up1);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        }


        Button login_button = findViewById(R.id.login_button);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        sign = findViewById(R.id.sign_in);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp1.this,Login.class);
                startActivity(intent);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from fields
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                String userName = username.getText().toString();

                // Create an intent to start SignUp2 activity
                Intent intent = new Intent(getApplicationContext(), SignUp2.class);


                intent.putExtra("EMAIL", userEmail);
                intent.putExtra("PASSWORD", userPassword);
                intent.putExtra("USERNAME", userName);

                // Start the activity
                startActivity(intent);
            }
        });
    }
}