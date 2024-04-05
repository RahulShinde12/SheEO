package com.capcun.womenentrepreneur;

import android.content.Context;
import android.graphics.ColorSpace;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.capcun.womenentrepreneur.databinding.ReelDgBinding;

import java.util.ArrayList;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.VideoHolder> {

    Context context;
    ArrayList<ShortsModel> modelArrayList = new ArrayList<>();
    Boolean isplaying = false;

    public ShortsAdapter(Context context, ArrayList<ShortsModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;

    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reel_dg,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {

        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
        holder.binding.userName.setText(modelArrayList.get(position).getName());
        holder.binding.userImage.setImageResource(modelArrayList.get(position).getProfile());

        holder.binding.caption.setText(modelArrayList.get(position).getDesc());
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                isplaying=true;
            }
        });

        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                isplaying=true;
            }
        });

        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isplaying) {
                    holder.binding.videoView.pause();
                    isplaying=false;
                }
                else
                {holder.binding.videoView.resume();
                isplaying=true;}

            }
        });
    }
    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{

        ReelDgBinding binding;

        public VideoHolder(@NonNull View itemView)
        {
            super(itemView);
            binding = ReelDgBinding.bind(itemView);
        }
    }
}
