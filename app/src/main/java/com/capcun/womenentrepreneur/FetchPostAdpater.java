package com.capcun.womenentrepreneur;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.capcun.womenentrepreneur.FetchUserProfile.ProfileModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchPostAdpater extends RecyclerView.Adapter<FetchPostAdpater.myviewholder> {

    List<DataLeadsNew> data;
    String name="Shinde";

    Context context;
    public FetchPostAdpater(List<DataLeadsNew> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_lead_design,parent,false);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {


        DataLeadsNew currentItem = data.get(position);

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hashtags = currentItem.getHashtag(); // Assuming getHashtag() returns comma-separated hashtags

                ArrayList<String> hashtagList = new ArrayList<>();
                String[] hashtagsArray = hashtags.split(",");
                Collections.addAll(hashtagList, hashtagsArray);


                for (String hashtag : hashtagList) {
                    // Assuming FeedGeneration.findSectorByHashtag method takes a single hashtag parameter
                    String s = FeedGeneration.findSectorByHashtag(hashtag);
                    Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
                }
            }
        });





        String user_id="6";
        Call<String> call2 = ApiControlllerEmployee
                .getInstance()
                .fetchingPost()
                .fetchFollow(user_id);

        call2.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();

                if (s!=null) {
                    // Split the comma-separated string into an array
                    String[] followingArray = s.split(",");

                    // Check if currentItem.getSender_id() is in the array
                    for (String id : followingArray) {
                        if (id.equals(currentItem.getSend_user_id())) {
                            holder.connect.setText("Following");
                            break;  // Exit the loop once a match is found
                        }
                    }
                }
                else
                    Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        // Check for null before setting each attribute
        if (currentItem != null) {
            holder.name.setText(currentItem.getUser_name() != null ? currentItem.getUser_name() : "");
            holder.time.setText(currentItem.getCreated_at() != null ? currentItem.getCreated_at() : "");
            holder.role.setText(currentItem.getJob_title() != null ? currentItem.getJob_title() : "");
            holder.title.setText(currentItem.getTitle() != null ? currentItem.getTitle() : "");
            holder.post.setText(currentItem.getContent_text() != null ? currentItem.getContent_text() : "");
            holder.hash.setText(currentItem.getHashtag() != null ? currentItem.getHashtag() : "");



            String imageUrl = currentItem.getContent_images(); // Replace this with your image URL

            // Load image with Picasso
            Picasso.get().load(imageUrl).into(holder.post_img);

            holder.like_count.setText(currentItem.getLikes() != null ? currentItem.getLikes() : "");
//            holder.post_img.setImageResource(currentItem.getImageResource() != null ? currentItem.getImageResource() : R.drawable.default_image);

            String type2 = currentItem.getUser_type();

            if (type2 != null) {
                switch (type2) {
                    case "entrepreneur":
                        holder.user_img.setImageResource(R.drawable.entrapreneur);
                        break;
                    case "investor": holder.user_img.setImageResource(R.drawable.investor);
                        break;
                    case "mentor":
                        holder.user_img.setImageResource(R.drawable.mentor);
                        break;
                    default:
                        holder.user_img.setImageResource(R.drawable.student);
                        break;
                }
            }
        }

        holder.connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_id="6";
                Call<String> call2 = ApiControlllerEmployee
                        .getInstance()
                        .fetchingPost()
                        .doFollow(user_id,currentItem.getSend_user_id());

                call2.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String s = response.body();

                        if(s.equals("success"))
                        {
                            Toast.makeText(context, "You started following "+currentItem.getUser_name(), Toast.LENGTH_SHORT).show();
                            holder.connect.setText("Following");

                        }
                        else
                            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setFilteredList(List<DataLeadsNew> filteredList) {

        this.data = filteredList;
        notifyDataSetChanged();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name,time,role,type,post,title,hash;
        LinearLayout lead_card;
        ImageView user_img,post_img;
        Button connect;

        TextView like_count;

        LinearLayout like;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            lead_card = itemView.findViewById(R.id.layout);

            name = itemView.findViewById(R.id.username);
            role = itemView.findViewById(R.id.user_headline);
            type = itemView.findViewById(R.id.time_stamp);
            title = itemView.findViewById(R.id.title);
            post = itemView.findViewById(R.id.text_1);
            time = itemView.findViewById(R.id.time_stamp);
            user_img = itemView.findViewById(R.id.button_image);

            post_img = itemView.findViewById(R.id.post_img);

            like_count = itemView.findViewById(R.id.likesTxt);

            hash = itemView.findViewById(R.id.hash);

            connect = itemView.findViewById(R.id.connect);

            like = itemView.findViewById(R.id.btn_like);


        }
    }
}
