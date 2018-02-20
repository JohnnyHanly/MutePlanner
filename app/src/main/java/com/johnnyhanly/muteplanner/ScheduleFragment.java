package com.johnnyhanly.muteplanner;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
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
    Button bUpdateData;
    Button bDeleteData;
    FloatingActionButton mAdd;
    EditText editTitle, editHour, editMinute, editMeridian, editID;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schedule, container, false);

        bViewData = (Button) view.findViewById(R.id.showData);
        editID= (EditText) view.findViewById(R.id.editID);
        editTitle = (EditText) view.findViewById(R.id.editTitle);
        editHour = (EditText) view.findViewById(R.id.editHour);
        editMinute = (EditText) view.findViewById(R.id.editMinute);
        editMeridian = (EditText) view.findViewById(R.id.editMeridian);
        bAddData = (Button) view.findViewById(R.id.addData);
        bUpdateData= (Button)view.findViewById(R.id.updateData);
        bDeleteData= (Button)view.findViewById(R.id.deleteData);
        myDB = new DBHelper(getActivity());

        AddData();
        ViewData();
        UpdateData();
        DeleteData();
        return view;
    }

    public void AddData() {

        bAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDB.insertData(editTitle.getText().toString(),
                        editHour.getText().toString(), editMinute.getText().toString(), editMeridian.getText().toString());

                if (inserted = true) {
                    Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ViewData() {
        bViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDB.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("Title :" + res.getString(1) + "\n");
                    buffer.append("Hours :" + res.getString(2) + "\n");
                    buffer.append("Min :" + res.getString(3) + "\n");
                    buffer.append("Meridian :" + res.getString(4) + "\n\n");


                }
                showMessage("Data", buffer.toString());
            }

            public void showMessage(String title, String Message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(Message);
                builder.show();
            }
        });

    }
    public void UpdateData(){
bUpdateData.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean isUpdated= myDB.updateData(editID.getText().toString(),editTitle.getText().toString(),
                editHour.getText().toString(),editMinute.getText().toString(), editMeridian.getText().toString());
        if (isUpdated = true) {
            Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Data not Updated", Toast.LENGTH_SHORT).show();
        }
    }
});

    }
    public void DeleteData(){
        bDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows= myDB.deleteData(editID.getText().toString());
                if (deletedRows >0){
                    Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Data not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
