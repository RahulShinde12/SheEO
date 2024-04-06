package com.capcun.womenentrepreneur;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mentor extends AppCompatActivity {
    RecyclerView upcomingrecycler;
    List<InvestorModel> data;
    List<InvestorModel> data_list;
    private MentorAdapter pageInfoAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        rretriveInvestor();
        fetchUserInfo();
//        pageInfoAdapter = new MentorAdapter(data_list, this);
//        upcomingrecycler.setAdapter(pageInfoAdapter);


    }


    public void rretriveInvestor()
    {
        upcomingrecycler = findViewById(R.id.mentorlist);
        layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.VERTICAL);
        upcomingrecycler.setLayoutManager(layoutManager);

//        fetchUserInfo();
        data_list = new ArrayList<>();
//        Call<List<InvestorModel>> call = ApiControlllerEmployee
//                .getInstance()
//                .fethAllID()
//                .fetchinvestor("6");
//        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
//        call.enqueue(new Callback<List<InvestorModel>>() {
//            @Override
//            public void onResponse(Call<List<InvestorModel>> call, Response<List<InvestorModel>> response) {
//
//                List<InvestorModel> data = response.body();
////                Toast.makeText(getContext(), ""+data, Toast.LENGTH_SHORT).show();
//
//
////                Toast.makeText(AllAdAccountList.this, ""+data.size(), Toast.LENGTH_SHORT).show();
//                if(data!=null)
//                {
////                    Toast.makeText(getContext(), ""+data.size(), Toast.LENGTH_SHORT).show();
//                    data_list.addAll(data);
//
//
//                    pageInfoAdapter = new MentorAdapter(data_list, Dashboard.this);
//                    upcomingrecycler.setAdapter(pageInfoAdapter);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<InvestorModel>> call, Throwable t) {
////                progressDialog.dismiss();
//
//                Toast.makeText(Dashboard.this,"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
//            }
//        });

    }


    public void fetchUserInfo()
    {

        Call<List<InvestorModel>> call = ApiControlllerEmployee
                .getInstance()
                .fetchAdIDApi()
                .getusers("6");
        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<List<InvestorModel>>() {
            @Override
            public void onResponse(Call<List<InvestorModel>> call, Response<List<InvestorModel>> response) {

                data = response.body();
//                Toast.makeText(getContext(), ""+data, Toast.LENGTH_SHORT).show();


//                Toast.makeText(AllAdAccountList.this, ""+data.size(), Toast.LENGTH_SHORT).show();
                if(data!=null)
                {
//                    Toast.makeText(getContext(), ""+data.size(), Toast.LENGTH_SHORT).show();
//                    data_list.addAll(data);

//                    Toast.makeText(Dashboard.this,"Doness !"+data.size(),Toast.LENGTH_LONG).show();

                    getcurrentuserdata();

                }

            }

            @Override
            public void onFailure(Call<List<InvestorModel>> call, Throwable t) {
//                progressDialog.dismiss();

//                Toast.makeText(getContext(),"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
            }
        });






















    }

    public void getcurrentuserdata()
    {

        Call<InvestorModel> call = ApiControlllerEmployee
                .getInstance()
                .fetchAdIDApi()
                .getuserssingle("6");
        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<InvestorModel>() {
            @Override
            public void onResponse(Call<InvestorModel> call, Response<InvestorModel> response) {

                InvestorModel datas = response.body();
//                Toast.makeText(getContext(), ""+data, Toast.LENGTH_SHORT).show();


//                Toast.makeText(AllAdAccountList.this, ""+data.size(), Toast.LENGTH_SHORT).show();
                if(datas!=null)
                {
//                    Toast.makeText(getContext(), ""+data.size(), Toast.LENGTH_SHORT).show();
//                    data_list.addAll(data);


//                    JSONArray jsonArray = convertModelListToJsonArray(data);


                    Toast.makeText(Mentor.this, ""+datas.getUser_type(), Toast.LENGTH_SHORT).show();

                    List<InvestorModel> filtorMentors = MentorMapping.findMentors(6,datas.getInterested_domain(),datas.getInterested_subdomain(),datas.getBio(),data);

                    if(data!=null)
                    {

                        data_list.addAll(filtorMentors);
                    }
//                        for(Integer i : filtorMentors)
//                        {
//                            InvestorModel mentorList = MentorMapping.getUserById(jsonArray, i+"");
//                            Log.d("Vasudev", "onResponse: "+mentorList);
//
//                            data_list.add(mentorList);
//
////                            data_list.addAll(data);


                    pageInfoAdapter = new MentorAdapter(data_list, Mentor.this);
                    upcomingrecycler.setAdapter(pageInfoAdapter);
//                        }


                    Toast.makeText(Mentor.this,"Doness !",Toast.LENGTH_LONG).show();



                }

            }

            @Override
            public void onFailure(Call<InvestorModel> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(Dashboard.this, "Something error", Toast.LENGTH_SHORT).show();

//                Toast.makeText(getContext(),"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
            }
        });



    }


    public static JSONArray convertModelListToJsonArray(List<InvestorModel> modelList) {
        JSONArray jsonArray = new JSONArray();

        for (InvestorModel model : modelList) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("user_id", model.getUser_id());
                jsonObject.put("user_name", model.getUser_name());
                jsonObject.put("email", model.getEmail());
                jsonObject.put("email_status", model.getEmail_status());
                jsonObject.put("password", model.getPassword());
                jsonObject.put("profile_img", model.getProfile_img());
                jsonObject.put("phone", model.getPhone());
                jsonObject.put("first_name", model.getFirst_name());
                jsonObject.put("last_name", model.getLast_name());
                jsonObject.put("country", model.getCountry());
                jsonObject.put("region", model.getRegion());
                jsonObject.put("job_title", model.getJob_title());
                jsonObject.put("school_college_university", model.getSchool_college_university());
                jsonObject.put("start_year", model.getStart_year());
                jsonObject.put("end_year", model.getEnd_year());
                jsonObject.put("age", model.getAge());
                jsonObject.put("bio", model.getBio());
                jsonObject.put("registration_date", model.getRegistration_date());
                jsonObject.put("meetup_registered", model.getMeetup_registered());
                jsonObject.put("user_type", model.getUser_type());
                jsonObject.put("following", model.getFollowing());
                jsonObject.put("interested_domain", model.getInterested_domain());
                jsonObject.put("interested_subdomain", model.getInterested_subdomain());
                jsonObject.put("feed_interest", model.getFeed_interest());

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }









}