package com.johnnyhanly.muteplanner;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlarmSelectActivity extends AppCompatActivity {
    View view;
    Button bSave;
    Button bCancel;
    DBHelper myDB;
    CheckBox sunCheck;
    CheckBox monCheck;
    CheckBox tueCheck;
    CheckBox wedCheck;
    CheckBox thuCheck;
    CheckBox friCheck;
    CheckBox satCheck;

    EditText enterTitle;
    TimePicker timePicker1;
    TimePicker timePicker2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_select);
        bSave = (Button) findViewById(R.id.saveAlarm);
        sunCheck = (CheckBox) findViewById(R.id.sundayButton);
        monCheck = (CheckBox) findViewById(R.id.mondayButton);
        tueCheck = (CheckBox) findViewById(R.id.tuesdayButton);
        wedCheck = (CheckBox) findViewById(R.id.wednesdayButton);
        thuCheck = (CheckBox) findViewById(R.id.thursdayButton);
        friCheck = (CheckBox) findViewById(R.id.fridayButton);
        satCheck = (CheckBox) findViewById(R.id.saturdayButton);
        myDB = new DBHelper(getApplicationContext());
        enterTitle= (EditText)findViewById(R.id.enterTitle);
        timePicker1= (TimePicker)findViewById(R.id.timePicker1);
        timePicker2= (TimePicker) findViewById(R.id.timePicker2);






        bSave.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                boolean inserted= myDB.insertData(enterTitle.getText().toString(),timePicker1.getHour(),timePicker1.getMinute(),timePicker2.getHour(),timePicker2.getMinute());

                if (inserted==true){
                    Toast.makeText(AlarmSelectActivity.this,"data ins",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AlarmSelectActivity.this,"data not",Toast.LENGTH_LONG).show();

                }

                ViewData();
                }
            });
        }


    public void ViewData() {

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
            buffer.append("Hours :" + res.getString(4) + "\n");
            buffer.append("Min :" + res.getString(5) + "\n\n");

        }
        showMessage("Data",buffer.toString());
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void DayChecker(View view) {
        int id = view.getId();
        ArrayList<Integer> daysOfWeek= new ArrayList<Integer>();
        StringBuffer result = new StringBuffer();
        switch (id) {
            case R.id.sundayButton:
                if (sunCheck.isChecked()) {
                    daysOfWeek.add(1);
                    result.append("Sun :").append(sunCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.mondayButton:
                if (monCheck.isChecked()) {
                    daysOfWeek.add(2);
                    result.append("Mon :").append(monCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.tuesdayButton:
                if (tueCheck.isChecked()) {
                    result.append("Tue :").append(tueCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.wednesdayButton:
                if (wedCheck.isChecked()) {
                    result.append("Wed :").append(wedCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.thursdayButton:
                if (thuCheck.isChecked()) {
                    result.append("Thur :").append(thuCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.fridayButton:
                if (friCheck.isChecked()) {
                    result.append("Fri :").append(friCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.saturdayButton:
                if (satCheck.isChecked()) {
                    result.append("Sat :").append(satCheck.isChecked());
                    Toast.makeText(AlarmSelectActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
                break;


        }
        //Toast.makeText(AlarmSelectActivity.this,arrayListadder(daysOfWeek),Toast.LENGTH_LONG).show();

    }

}
