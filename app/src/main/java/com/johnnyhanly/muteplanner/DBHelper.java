package com.johnnyhanly.muteplanner;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Johnny Hanly on 2/17/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME= "Alarm.db";
    public static final String TABLE_NAME= "alarm_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "Title";
    public static final String COL_3= "Hours1";
    public static final String COL_4= "Min1";
    public static final String COL_5= "Hours2";
    public static final String COL_6= "Min2";
    public static final String COL_7= "Meridian1";
    public static final String COL_8= "Meridian2";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT, HOURS1 INTEGER, MIN1 INTEGER,HOURS2 INTEGER, MIN2 INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }
    public  boolean insertData(String title, Integer hours1, Integer min1, Integer hours2, Integer min2){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(COL_2,title);
        contentValues.put(COL_3,hours1);
        contentValues.put(COL_4,min1);
        contentValues.put(COL_5,hours2);
        contentValues.put(COL_6,min2);
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
    public boolean updateData(String ID,String title, Integer hours1, Integer min1, Integer hours2, Integer min2){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1,ID);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,hours1);
        contentValues.put(COL_4,min1);
        contentValues.put(COL_5,hours2);
        contentValues.put(COL_6,min2);

        db.update(TABLE_NAME,contentValues,"ID = ?",new String[]{ID});
        return true;

    }
    public Integer deleteData(String ID){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID= ?",new String[] {ID});



    }
}
