package com.johnnyhanly.muteplanner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ScheduleFragment extends Fragment {
    View view;
    DBHelper myDB;
    Button bViewData;
    Button bAddData;
    FloatingActionButton mAdd;
    EditText editTitle, editHour, editMinute, editMeridian;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view= inflater.inflate(R.layout.fragment_schedule,container,false);

bViewData= (Button)view.findViewById(R.id.showData);

editTitle=(EditText)view.findViewById(R.id.editTitle);
editHour=(EditText)view.findViewById(R.id.editHour);
editMinute= (EditText)view.findViewById(R.id.editMinute);
editMeridian= (EditText)view.findViewById(R.id.editMeridian);
bAddData= (Button)view.findViewById(R.id.addData);
myDB= new DBHelper(getActivity());

AddData();



        return view;
    }
   public void AddData(){

        bAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted= myDB.insertData(editTitle.getText().toString(),
                        editHour.getText().toString(),editMinute.getText().toString(),editMeridian.getText().toString() );

                if(inserted= true){
                    Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void ViewData(){



    }
}
