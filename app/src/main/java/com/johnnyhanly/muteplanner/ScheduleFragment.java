package com.johnnyhanly.muteplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ScheduleFragment extends Fragment {
    View view;
    //DBHelper myDB;
    ListView alarmList;
    Button bViewData;
    Button bAddData;
    Button bUpdateData;
    Button bDeleteData;
    FloatingActionButton mAdd;
    EditText editTitle, editHour, editMinute, editMeridian, editID;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schedule, container, false);
        mAdd = (FloatingActionButton) view.findViewById(R.id.addButton);
/*
        bViewData = (Button) view.findViewById(R.id.showData);
        editID= (EditText) view.findViewById(R.id.editID);
        editTitle = (EditText) view.findViewById(R.id.editTitle);
        editHour = (EditText) view.findViewById(R.id.editHour);
        editMinute = (EditText) view.findViewById(R.id.editMinute);
        editMeridian = (EditText) view.findViewById(R.id.editMeridian);

        bAddData = (Button) view.findViewById(R.id.addData);
        bUpdateData= (Button)view.findViewById(R.id.updateData);
        bDeleteData= (Button)view.findViewById(R.id.deleteData);


*/
        alarmList = (ListView) view.findViewById(R.id.list_of_alarms);
        //myDB = new DBHelper(getActivity());
        String[] fruits = new String[]{
                "Cape Gooseberry",
                "Capuli cherry"
        };
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits)
        );
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, fruits_list);

        alarmList.setAdapter(arrayAdapter);

        alarmList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if ((position == 0)) {
                    Intent i = new Intent(getActivity(), AlarmSelectActivity.class);
                    startActivity(i);

                }
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AlarmSelectActivity.class);
                startActivity(i);
            }
        });







/*
        AddData();
        ViewData();
        UpdateData();
        DeleteData();

*/


        return view;
    }



/*
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
    */
    }

