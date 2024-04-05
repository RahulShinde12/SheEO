package com.capcun.womenentrepreneur;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.capcun.womenentrepreneur.FetchUserProfile.ProfileModel;

import java.util.List;

public class FetchFollowingAdpater extends RecyclerView.Adapter<FetchFollowingAdpater.myviewholder> {

    List<ProfileModel> data;
    String name="Shinde";

    Context context;
    public FetchFollowingAdpater(List<ProfileModel> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public FetchFollowingAdpater.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_useritem,parent,false);
        return new myviewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FetchFollowingAdpater.myviewholder holder, int position) {

        ProfileModel currentItem = data.get(position);
        holder.name.setText(currentItem.getFirst_name()+currentItem.getLast_name());
        String type2 = currentItem.getUser_type();

        if (type2 != null) {
            switch (type2) {
                case "entrepreneur":
                   holder.user_img.setImageResource(R.drawable.entrapreneur);
                    break;
                case "investor":
                    holder.user_img.setImageResource(R.drawable.investor);
                    break;
                case "mentor":
                    holder.user_img.setImageResource(R.drawable.mentor);
                    break;
                default:
                    holder.user_img.setImageResource(R.drawable.student);
                    break;
            }
        }
     holder.lead_card.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(context,ChatWindow.class);
             intent.putExtra("name",data.get(position).getFirst_name()+data.get(position).getLast_name());
             intent.putExtra("rev",data.get(position).getUser_id());
             context.startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView name,msg;
        RelativeLayout lead_card;
        ImageView user_img;



        public myviewholder(@NonNull View itemView) {
            super(itemView);
            lead_card = itemView.findViewById(R.id.item_click_parent);

            name = itemView.findViewById(R.id.item_text);

            user_img = itemView.findViewById(R.id.item_image);




        }
    }
}
