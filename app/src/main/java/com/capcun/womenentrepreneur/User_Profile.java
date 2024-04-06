package com.capcun.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.capcun.womenentrepreneur.FetchUserProfile.FetchProfile;
import com.capcun.womenentrepreneur.FetchUserProfile.ProfileModel;
import com.capcun.womenentrepreneur.fetchPosts.FetchPostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User_Profile extends AppCompatActivity {

    ImageView back;
    TextView name,bio,region,college,experience,connection,mail,phone;
    Button logout,createPost,mentors;




    ImageView img;

    List<ProfileModel> data_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTheme(R.style.StatusBarTheme);
        }
        setContentView(R.layout.activity_user_profile);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        }

        createPost = findViewById(R.id.create_post);
        mentors = findViewById(R.id.mentors);

        mentors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Profile.this,Mentor.class);
                startActivity(intent);
            }
        });



        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Profile.this,CreatePost.class);
                startActivity(intent);
            }
        });
        name = findViewById(R.id.headline2);
        bio = findViewById(R.id.headlineTxt);
        region = findViewById(R.id.region);
        connection = findViewById(R.id.connections);
        experience = findViewById(R.id.exp);
        college = findViewById(R.id.edu);
        logout = findViewById(R.id.log);

        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        img = findViewById(R.id.profileImg);


        Button btn = findViewById(R.id.chatbot);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Profile.this,ChatBot.class);
                startActivity(intent);
            }
        });




        String user_id="6";

        Toast.makeText(User_Profile.this, "Yes0", Toast.LENGTH_SHORT).show();
        Call<FetchProfile> call2 = ApiControlllerEmployee
                .getInstance()
                .fetchingPost()
                .fetchData(user_id);


        call2.enqueue(new Callback<FetchProfile>() {
            @Override
            public void onResponse(Call<FetchProfile> call, Response<FetchProfile> response) {
//                Toast.makeText(User_Profile.this, "Yes1", Toast.LENGTH_SHORT).show();

                FetchProfile data = response.body();

                if (data != null) {

//                    Toast.makeText(User_Profile.this, "Yes2", Toast.LENGTH_SHORT).show();

                        //Toast.makeText(Dashboard.this, "Yes2", Toast.LENGTH_SHORT).show();
                        //data_list.add(0, new ProfileModel(data.getUser_id(),data.getUser_name(),data.getEmail(),data.getPhone(),data.getFirst_name(),data.getLast_name(),data.getCountry(),data.getRegion(),data.getJob_title(),data.getSchool_college_university(),data.getStart_year(),data.getLast_year(),data.getBio(),data.getUser_type()));

                        name.setText(data.getFirst_name()+" "+data.getLast_name());
                        bio.setText(data.getBio());
                        region.setText(data.getCountry());
                        experience.setText(data.getJob_title());
                        college.setText(data.getSchool_college_university());
                        mail.setText(data.getEmail());
                        phone.setText(data.getPhone());

                    String type2 = data.getUser_type();

                    if (type2 != null) {
                        switch (type2) {
                            case "entrepreneur":
                                 img.setImageResource(R.drawable.entrapreneur);
                                break;
                            case "investor":
                                 img.setImageResource(R.drawable.investor);
                                break;
                            case "mentor":
                                 img.setImageResource(R.drawable.mentor);
                                break;
                            default:
                                 img.setImageResource(R.drawable.student);
                                break;
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<FetchProfile> call, Throwable t) {

//                Toast.makeText(User_Profile.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });






    }
}