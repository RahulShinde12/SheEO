package com.capcun.womenentrepreneur;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.capcun.womenentrepreneur.FetchUserProfile.FetchProfile;
import com.capcun.womenentrepreneur.FetchUserProfile.ProfileModel;
import com.capcun.womenentrepreneur.fetchPosts.FetchPostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Messages extends AppCompatActivity {


    LinearLayoutManager layoutManager;
    FetchFollowingAdpater fetchLeadAdpater;
    final String sharedPreferencesFileTitle = "sheeo";

    List<ProfileModel> data_list = new ArrayList<>();
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTheme(R.style.StatusBarTheme);
        }
        setContentView(R.layout.activity_messages);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        }



        recycler = findViewById(R.id.user_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);


        String user_id="6";
        Call<List<FetchProfile2>> call2 = ApiControlllerEmployee
                .getInstance()
                .fetchingPost()
                .fetchFollowing(user_id);

        call2.enqueue(new Callback<List<FetchProfile2>>() {
            @Override
            public void onResponse(Call<List<FetchProfile2>> call, Response<List<FetchProfile2>> response) {
                List<FetchProfile2> data = response.body();
//                        Toast.makeText(Dashboard.this, "Yes1", Toast.LENGTH_SHORT).show();

                if (data != null) {
                    for (FetchProfile2 lead : data) {
//                                Toast.makeText(Dashboard.this, "Yes2", Toast.LENGTH_SHORT).show();


                        data_list.add(0, new ProfileModel(lead.user_id, lead.user_name, lead.first_name, lead.last_name, lead.user_type));
                    }

                    fetchLeadAdpater = new FetchFollowingAdpater(data_list, Messages.this);
                    recycler.setAdapter(fetchLeadAdpater);

                }
            }




            @Override
            public void onFailure(Call<List<FetchProfile2>> call, Throwable t){

                }
            });
    }
}