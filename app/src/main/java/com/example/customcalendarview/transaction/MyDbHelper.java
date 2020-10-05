package com.example.customcalendarview.transaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ Constants.TABLE_NAME);
        onCreate(db);
    }

    public long insertRecord(String name,
                             String image,
                             String amount,
                             String date,
                             String details,
                             String addedTime,
                             String updateTime){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_NAME, name);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_AMOUNT, amount);
        values.put(Constants.C_DOB, date);
        values.put(Constants.C_DETAILS, details);
        values.put(Constants.C_ADDED_TIMESTAMP, addedTime);
        values.put(Constants.C_UPDATE_TIMESTAMP, updateTime);

        long id = db.insert(Constants.TABLE_NAME,null,values);
        db.close();
        return id;

    }

    public ArrayList<ModelRecord> getAllRecords(String orderBy) {

        ArrayList<ModelRecord> recordsList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){


            do {
                ModelRecord modelRecord = new ModelRecord(
                        ""+cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_NAME)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_AMOUNT)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_DOB)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_DETAILS)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_ADDED_TIMESTAMP)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATE_TIMESTAMP)));

                recordsList.add(modelRecord);
            }while (cursor.moveToNext());
        }
        db.close();
        return recordsList;
    }


    public ArrayList<ModelRecord> searchRecords(String query){

        ArrayList<ModelRecord> recordsList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.C_NAME + " LIKE '%" + query + "%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){


            do {
                ModelRecord modelRecord = new ModelRecord(
                        ""+cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_NAME)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_AMOUNT)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_DOB)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_DETAILS)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_ADDED_TIMESTAMP)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATE_TIMESTAMP)));

                recordsList.add(modelRecord);
            }while (cursor.moveToNext());
        }
        db.close();
        return recordsList;
    }

    public int getRecordsCount(){
        String countQuery = "SELECT * FROM " +  Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();

        cursor.close();

        return count;
    }
}
