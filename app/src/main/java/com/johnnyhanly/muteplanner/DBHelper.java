package com.johnnyhanly.muteplanner;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Johnny Hanly on 2/17/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME= "Alarms.db";
    public static final String TABLE_NAME= "alarm_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "Title";
    public static final String COL_3= "Hours";
    public static final String COL_4= "Min";
    public static final String COL_5= "Meridian";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT, HOURS TEXT, MIN TEXT,MERIDIAN TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }
    public  boolean insertData(String title, String hours, String min, String meridian){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(COL_2,title);
        contentValues.put(COL_3,hours);
        contentValues.put(COL_4,min);
        contentValues.put(COL_5,meridian);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result ==-1){
            return false;
        }else {
            return true;
        }

    }
    public Cursor getAllData() {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor result= db.rawQuery("select * from "+TABLE_NAME,null);
        return result;


    }
}
