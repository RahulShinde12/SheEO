package com.capcun.womenentrepreneur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.capcun.womenentrepreneur.databinding.ActivityPitchShortsBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShortsFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShortsFrag extends Fragment {

    ActivityPitchShortsBinding binding;
    ArrayList<ShortsModel> arrayList = new ArrayList<>();
    ShortsAdapter adapter;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShortsFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShortsFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static ShortsFrag newInstance(String param1, String param2) {
        ShortsFrag fragment = new ShortsFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_shorts, container, false);
        View view = inflater.inflate(R.layout.fragment_shorts, container, false);

        // Assuming arrayList and adapter are defined in the fragment class
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.a, R.drawable.student,"Rahul Shinde","gndsgkndgskbjsdgbksdnfnksdfsdk"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.b, R.drawable.investor,"Keshav Jaiwal","glnrgjeorjforegonorngongnngo"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.c, R.drawable.student,"Rahul Shinde","glnflgndkgnkdfngkjdfgkvjndfklgnkdnfkgnkngknkfdngknkrntkgnerkndgkn"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.d, R.drawable.student,"Rahul Shinde","gndsgkndgskbjsdgbksdnfnksdfsdk"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.e, R.drawable.investor,"Keshav Jaiwal","glnrgjeorjforegonorngongnngo"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.f, R.drawable.student,"Rahul Shinde","glnflgndkgnkdfngkjdfgkvjndfklgnkdnfkgnkngknkfdngknkrntkgnerkndgkn"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.g, R.drawable.student,"Rahul Shinde","gndsgkndgskbjsdgbksdnfnksdfsdk"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.h, R.drawable.investor,"Keshav Jaiwal","glnrgjeorjforegonorngongnngo"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.i, R.drawable.student,"Rahul Shinde","glnflgndkgnkdfngkjdfgkvjndfklgnkdnfkgnkngknkfdngknkrntkgnerkndgkn"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.j, R.drawable.student,"Rahul Shinde","gndsgkndgskbjsdgbksdnfnksdfsdk"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.k, R.drawable.investor,"Keshav Jaiwal","glnrgjeorjforegonorngongnngo"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.l, R.drawable.student,"Rahul Shinde","glnflgndkgnkdfngkjdfgkvjndfklgnkdnfkgnkngknkfdngknkrntkgnerkndgkn"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.m, R.drawable.investor,"Keshav Jaiwal","glnrgjeorjforegonorngongnngo"));
        arrayList.add(new ShortsModel("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.n, R.drawable.student,"Rahul Shinde","glnflgndkgnkdfngkjdfgkvjndfklgnkdnfkgnkngknkfdngknkrntkgnerkndgkn"));

        adapter = new ShortsAdapter(requireActivity(), arrayList);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter);

        return view;
    }

}