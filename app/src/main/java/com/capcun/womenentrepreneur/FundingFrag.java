package com.capcun.womenentrepreneur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FundingFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FundingFrag extends Fragment {

    RecyclerView upcomingrecycler;
    List<InvestorModel> data;
    List<InvestorModel> data_list;
    private MentorAdapter pageInfoAdapter;
    LinearLayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FundingFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FundingFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static FundingFrag newInstance(String param1, String param2) {
        FundingFrag fragment = new FundingFrag();
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
//        return inflater.inflate(R.layout.fragment_funding, container, false);
        View view = inflater.inflate(R.layout.fragment_funding, container, false);
        rretriveInvestor(view);

        return view;
    }


    public void rretriveInvestor(View view)
    {
        upcomingrecycler = view.findViewById(R.id.mentorlist);
        layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.VERTICAL);
        upcomingrecycler.setLayoutManager(layoutManager);

//        fetchUserInfo();
        data_list = new ArrayList<>();
        Call<List<InvestorModel>> call = ApiControlllerEmployee
                .getInstance()
                .fetchAdIDApi()
                .fetchinvestor("6");

        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<List<InvestorModel>>() {
            @Override
            public void onResponse(Call<List<InvestorModel>> call, Response<List<InvestorModel>> response) {

                List<InvestorModel> data = response.body();
//                Toast.makeText(getContext(), ""+data, Toast.LENGTH_SHORT).show();


//                Toast.makeText(AllAdAccountList.this, ""+data.size(), Toast.LENGTH_SHORT).show();
                if(data!=null)
                {
//                    Toast.makeText(getContext(), ""+data.size(), Toast.LENGTH_SHORT).show();
                    data_list.addAll(data);


                    pageInfoAdapter = new MentorAdapter(data_list, getContext());
                    upcomingrecycler.setAdapter(pageInfoAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<InvestorModel>> call, Throwable t) {
//                progressDialog.dismiss();

                Toast.makeText(getContext(),"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
            }
        });

    }
}