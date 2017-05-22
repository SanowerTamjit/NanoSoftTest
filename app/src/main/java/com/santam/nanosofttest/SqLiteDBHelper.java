package com.santam.nanosofttest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Tamjit on 22/05/2017.
 */

public class SqLiteDBHelper extends SQLiteOpenHelper{

    private static final String TAG = "DBHelper";
    private static final String TABLE_NAME = "person";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "age";
    private static final String COL4 = "dob";
    private static final String COL5 = "latitude";
    private static final String COL6 = "longiitude";

    public SqLiteDBHelper(Context context) {
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_NAME +" ("+COL1+" TEXT PRIMARY KEY, " + COL2 +" TEXT, " + COL3 + " INTEGER " +
                ", " + COL4 + " TEXT , " + COL5 + " TEXT , " + COL6 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String createTable = "DROP IF TABLE EXISTS "+TABLE_NAME ;
        db.execSQL(createTable);
    }
    public boolean AddData (String id, String name, int Age, String dob, String latitude, String longitude){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,Age);
        contentValues.put(COL4,dob);
        contentValues.put(COL5,latitude);
        contentValues.put(COL6,longitude);
        Log.d(TAG,"Data Adding " + name + " to "+ TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return  true;

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor viewDataByID(String id , String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " +TABLE_NAME+ " WHERE " +COL1+" = '"+id+"' AND " + COL2 + " = '"+name+"' ";
        Cursor data2 = db.rawQuery(query, null);
        Log.d(TAG, "Data View: query: " + query);

        return data2;
    }
    public Cursor forGetLocation(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT "+COL5+","+COL6+" FROM " +TABLE_NAME+ " WHERE " +COL1+" = '"+id+"' ";
        Cursor data2 = db.rawQuery(query, null);
        Log.d(TAG, "Data View: query: " + query);

        return data2;
    }
}
