package com.capcun.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp4 extends AppCompatActivity {

    private EditText collegeNameInput, startYearInput, endYearInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTheme(R.style.StatusBarTheme);
        }
        setContentView(R.layout.activity_sign_up4);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        }


        collegeNameInput = findViewById(R.id.collegeName);
        startYearInput = findViewById(R.id.startYear);
        endYearInput = findViewById(R.id.endYear);
        continueButton = findViewById(R.id.login_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect data from inputs
                String collegeName = collegeNameInput.getText().toString().trim();
                String startYear = startYearInput.getText().toString().trim();
                String endYear = endYearInput.getText().toString().trim();

                // Data from INtent
                String email = getIntent().getStringExtra("EMAIL");
                String password = getIntent().getStringExtra("PASSWORD");
                String username = getIntent().getStringExtra("USERNAME");
                String firstName = getIntent().getStringExtra("FIRST_NAME");
                String lastName = getIntent().getStringExtra("LAST_NAME");
                String phone = getIntent().getStringExtra("PHONE");
                String country = getIntent().getStringExtra("COUNTRY");
                String jobTitle = getIntent().getStringExtra("JOB_TITLE");
                String age = getIntent().getStringExtra("AGE");
                String bio = getIntent().getStringExtra("BIO");
                String profession = getIntent().getStringExtra("PROFESSION");
                String interestSectors = getIntent().getStringExtra("INTEREST_SECTORS");

                // Check if any field is empty
                if (collegeName.isEmpty() || startYear.isEmpty() || endYear.isEmpty()) {
                    Toast.makeText(SignUp4.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create an intent to start SignUp4 activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);



//                startActivity(intent);


            }
        });
    }


}