package com.capcun.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;


import com.capcun.womenentrepreneur.databinding.ActivityPitchShortsBinding;

import java.util.ArrayList;

public class Pitch_Shorts extends AppCompatActivity {

    ActivityPitchShortsBinding binding;
    ArrayList<ShortsModel> arrayList = new ArrayList<>();
    ShortsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityPitchShortsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        getSupportActionBar().hide();
//        this.getTheme().applyStyle(R.style.FullScreen,false);

         arrayList.add(new ShortsModel("android.resource://" + getPackageName() + "/" + R.raw.a, R.drawable.student,"Rahul Shinde","gndsgkndgskbjsdgbksdnfnksdfsdk"));
        arrayList.add(new ShortsModel("android.resource://" + getPackageName() + "/" + R.raw.b, R.drawable.investor,"Keshav Jaiwal","glnrgjeorjforegonorngongnngo"));
        arrayList.add(new ShortsModel("android.resource://" + getPackageName() + "/" + R.raw.c, R.drawable.student,"Rahul Shinde","glnflgndkgnkdfngkjdfgkvjndfklgnkdnfkgnkngknkfdngknkrntkgnerkndgkn"));

        adapter = new ShortsAdapter(Pitch_Shorts.this,arrayList);
        binding.viewPager2.setAdapter(adapter);
    }
}