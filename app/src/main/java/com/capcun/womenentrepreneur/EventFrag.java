package com.capcun.womenentrepreneur;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFrag extends Fragment {


    RecyclerView newgroupsrecycler;
    LinearLayout choose;
    String datetime;

    private NewGroupsAdapter newgrousadapter;
    LinearLayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFrag newInstance(String param1, String param2) {
        EventFrag fragment = new EventFrag();
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
//        return inflater.inflate(R.layout.fragment_event, container, false);

        View view = inflater.inflate(R.layout.fragment_event, container, false);

        choose  = view.findViewById(R.id.choose);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendor();
            }
        });



        newGroups(view);
        PopularNow(view);
        return view;
    }

    private void openCalendor() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new DatePickerDialog instance
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Update selectedDateTextView when a date is selected

                        datetime =dayOfMonth + "/" + (month + 1) + "/" + year;
//                        selectedDateTextView.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);

        // Show the date picker dialog
        datePickerDialog.show();



    }

    public void newGroups(View view)
    {
        List<Meetups> data_list;
        newgroupsrecycler = view.findViewById(R.id.newgroupsrecycler);
        layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();

        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());
        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());




        newgrousadapter = new NewGroupsAdapter(data_list, getContext());
        newgroupsrecycler.setAdapter(newgrousadapter);




    }

    public void PopularNow(View view)
    {
        List<Meetups> data_list;
        RecyclerView newgroupsrecycler = view.findViewById(R.id.popularnow);
        layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();

        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());
        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());




        PopularNowAdapter newgrousadapter = new PopularNowAdapter(data_list, getContext());
        newgroupsrecycler.setAdapter(newgrousadapter);




    }


    public void newGroups1(View view)
    {

        newgroupsrecycler = view.findViewById(R.id.newgroupsrecycler);
        layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);

        List<Meetups> data_list;
        data_list = new ArrayList<>();

        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());
        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());




        newgrousadapter = new NewGroupsAdapter(data_list, getContext());
        newgroupsrecycler.setAdapter(newgrousadapter);




    }


}