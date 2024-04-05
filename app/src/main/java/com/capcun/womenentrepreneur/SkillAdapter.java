package com.capcun.womenentrepreneur;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.LeadData>{

    List<SkillAssessmentModel> dataholder2;


//    List<EVStation> evStations = new ArrayList<>();
//    private FirebaseFirestore firebaseFirestore;
    Context context;
    final String sharedPreferencesFileTitle = "ecoview";
    public SkillAdapter(List<SkillAssessmentModel> dataholder2, Context context) {
        this.dataholder2 = dataholder2;
        this.context = context;

    }



    public void setFilteredList(List<SkillAssessmentModel> filteredList) {
        Log.println(Log.DEBUG,"debug", "Finally"+filteredList);
        this.dataholder2 = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public LeadData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        init();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.skillcard,parent,false);
        return new LeadData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadData holder, int position) {

        holder.name.setText(dataholder2.get(position).getName());
        holder.des.setText(dataholder2.get(position).getDesc());
        holder.day.setText(dataholder2.get(position).price+ " day left");





        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent = new Intent(context, CourseInfo.class);
                        intent.putExtra("name",dataholder2.get(position).getName());
                intent.putExtra("desc",dataholder2.get(position).getDesc());

                intent.putExtra("price",dataholder2.get(position).getDay_left());


                context.startActivity(intent);

            }
        });

//            holder.medName.setText(dataholder2.get(position).getName());
//            holder.datetime.setText(dataholder2.get(position).getDate()+dataholder2.get(position).getTime());


    }

    private String getAddress(double lati,double longi) {

        String add = "";

        try {
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(context, Locale.getDefault());

            addresses = geocoder.getFromLocation(lati, longi, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

            add = addresses.get(0).getAddressLine(0);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return add;
    }

    @Override
    public int getItemCount() {
        return dataholder2.size();
    }


    class LeadData extends RecyclerView.ViewHolder
    {
        TextView medName;
        TextView datetime;
        LinearLayout card;
        TextView name,des,day;




        public LeadData(@NonNull View itemView)
        {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            name = itemView.findViewById(R.id.name);
            des = itemView.findViewById(R.id.desc);
            day = itemView.findViewById(R.id.dayleft);

//            medName = itemView.findViewById(R.id.med_name);
//            datetime = itemView.findViewById(R.id.datetime);


        }
    }
    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }


//    public void showBottomSheetDialog(String tag)
//    {
//
//        final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(
//                context,R.style.BottomSheetDialogTheme
//        );
//
//
//        View bottomSheetView = LayoutInflater.from(context)
//                .inflate(
//                        R.layout.layout_bottom_sheet, (LinearLayout)findViewById(R.id.bottomsheetcontainer)
//                );
////        Owner allowner = mp.get(tag);
//
//
////
//        TextView stationname = bottomSheetView.findViewById(R.id.stationname);
//        TextView price,remainingEnergy,address;
////        Toast.makeText(this, ""+allowner.getPrice(), Toast.LENGTH_SHORT).show();
//        price = bottomSheetView.findViewById(R.id.price);
//        remainingEnergy = bottomSheetView.findViewById(R.id.remainingenergy);
//        address = bottomSheetView.findViewById(R.id.address);
////        Toast.makeText(this, ""+ Integer.toHexString(System.identityHashCode(allowner.getOwner_location())), Toast.LENGTH_SHORT).show();
////        price.setText(allowner.getPrice()+"");
////        remainingEnergy.setText(allowner.get);
////        address.setText(getAddress());
////        stationname.setText(allowner.getOwner_name());
//
//
//
//
//
//        Button direction= bottomSheetView.findViewById(R.id.btnUpdate);
//        Button book = bottomSheetView.findViewById(R.id.book);
//
//
//
//
//        bottomSheetDialog1.setContentView(bottomSheetView);
//        bottomSheetDialog1.show();
//    }




}
