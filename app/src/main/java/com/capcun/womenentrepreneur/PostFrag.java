package com.capcun.womenentrepreneur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.capcun.womenentrepreneur.fetchPosts.FetchPostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostFrag extends Fragment {


    LinearLayoutManager layoutManager;
    FetchPostAdpater fetchLeadAdpater;
    final String sharedPreferencesFileTitle = "sheeo";

    List<DataLeadsNew> data_list = new ArrayList<>();
    RecyclerView recycler;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PostFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static PostFrag newInstance(String param1, String param2) {
        PostFrag fragment = new PostFrag();
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
//        return inflater.inflate(R.layout.fragment_post, container, false);

        View view = inflater.inflate(R.layout.fragment_post, container, false);


        recycler = view.findViewById(R.id.recycler_for_post);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);


        Call<List<FetchPostModel>> call2 = ApiControlllerEmployee
                .getInstance()
                .fetchingPost()
                .fetchPost();


//            Toast.makeText(this, "Hiii", Toast.LENGTH_SHORT).show();
        call2.enqueue(new Callback<List<FetchPostModel>>() {
            @Override
            public void onResponse(Call<List<FetchPostModel>> call, Response<List<FetchPostModel>> response) {

                List<FetchPostModel> data = response.body();
//                        Toast.makeText(Dashboard.this, "Yes1", Toast.LENGTH_SHORT).show();

                if (data != null) {
                    for (FetchPostModel lead : data) {
//                                Toast.makeText(Dashboard.this, "Yes2", Toast.LENGTH_SHORT).show();


                        data_list.add(0, new DataLeadsNew(lead.getPost_id(), lead.getSender_user_id(), lead.getTitle(), lead.getContent_text(), lead.getContent_images(), lead.getLikes(), lead.getComments(), lead.getVisibility(), lead.getCreated_at(),lead.getHashtag(), lead.getUser_name(), lead.getJob_title(), lead.getUser_type()));
                    }

                    fetchLeadAdpater = new FetchPostAdpater(data_list, getContext());
                    recycler.setAdapter(fetchLeadAdpater);

                }

            }

            @Override
            public void onFailure(Call<List<FetchPostModel>> call, Throwable t) {

            }
        });


        return view;
    }
}