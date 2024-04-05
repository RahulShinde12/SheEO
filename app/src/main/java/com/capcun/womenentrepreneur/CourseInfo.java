package com.capcun.womenentrepreneur;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CourseInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String price = intent.getStringExtra("price");

        TextView nammes = findViewById(R.id.name);
        TextView descr = findViewById(R.id.desc);
        TextView prices = findViewById(R.id.price);


        nammes.setText(name);
        descr.setText(desc);
        prices.setText(price);


        TextView enroll = findViewById(R.id.enroll);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CourseInfo.this, ""+name+ " enroll successfully", Toast.LENGTH_SHORT).show();
                finish();


            }
        });






    }
}