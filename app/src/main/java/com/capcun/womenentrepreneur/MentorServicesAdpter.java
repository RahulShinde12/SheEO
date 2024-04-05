package com.capcun.womenentrepreneur;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MentorServicesAdpter extends RecyclerView.Adapter<MentorServicesAdpter.LeadData>{

    List<MentorServicesModel> dataholder2;






    AlertDialog.Builder builder ;



    Context context;
    final String sharedPreferencesFileTitle = "ecoview";
    public  MentorServicesAdpter(List<MentorServicesModel> dataholder2, Context context) {
        this.dataholder2 = dataholder2;
        this.context = context;


    }


    public void setFilteredList(List<MentorServicesModel> filteredList) {
        Log.println(Log.DEBUG,"debug", "Finally"+filteredList);
        this.dataholder2 = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public LeadData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        init();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mentorservice  ,parent,false);
        return new LeadData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadData holder, int position) {


        holder.connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





//                String description = desc.getText().toString();



                Toast.makeText(context, "Connection request sended successfully", Toast.LENGTH_SHORT).show();

                Call<String> call = ApiControlllerEmployee
                        .getInstance()
                        .fetchAdIDApi()
                        .sendconnectiontoInvestor("id","id","");

                //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        String data = response.body();

                        Toast.makeText(context, ""+data, Toast.LENGTH_SHORT).show();
                        if(data!=null)
                        {
//                            bot.dismiss();
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

//                        bottomSheetDialog1.dismiss();

//                progressDialog.dismiss();
//                                Log.e("NetworkError", "Something went wrong: " + t.getMessage());

                        // Show a toast message indicating the failure
//                                Toast.makeText(CreatePost.this, "Something went wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                Toast.makeText(CreatePost.this,"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
                    }
                });



            }
        });


//        holder.name.setText(dataholder2.get(position).getName());
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,AllPagesStatus.class);
//                context.startActivity(intent);
//            }
//        });

    }




    @Override
    public int getItemCount() {
        return dataholder2.size();
    }


    class LeadData extends RecyclerView.ViewHolder
    {
        LinearLayout card;
        TextView name;
        TextView connect;
        public LeadData(@NonNull View itemView)
        {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            connect = itemView.findViewById(R.id.connect);
//            name = itemView.findViewById(R.id.med_name);



            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    connect = itemView.findViewById(R.id.connect);




                }
            });




        }
    }



}
