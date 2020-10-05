package com.example.customcalendarview.Money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.customcalendarview.R;

import java.util.ArrayList;

public class view extends AppCompatActivity {

    private LinearLayout ml; //


    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        SQLiteDatabase db = openOrCreateDatabase("SliteDb", Context.MODE_PRIVATE,null);

        lst1 = findViewById(R.id.lst1);
        final Cursor c = db.rawQuery("select * from records",null);
        int id = c.getColumnIndex("id");
        int name = c.getColumnIndex("name");
        int course = c.getColumnIndex("course");
        int fee = c.getColumnIndex("fee");
        titles.clear();


        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final  ArrayList<transaction> stud = new ArrayList<transaction>();


        if(c.moveToFirst())
        {
            do{

                transaction stu = new transaction();
                stu.id = c.getString(id);
                stu.name = c.getString(name);
                stu.course = c.getString(course);
                stu.fee = c.getString(fee);

                stud.add(stu);


                titles.add(c.getString(id) + " \t " + c.getString(name) + " \t "  + c.getString(course) + " \t "  + c.getString(fee) );




            } while(c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();



        }

        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String aa = titles.get(position).toString();

                transaction stu = stud.get(position);
                Intent i = new Intent(getApplicationContext(),edit.class);

                i.putExtra("id",stu.id);
                i.putExtra("name",stu.name);
                i.putExtra("course",stu.course);
                i.putExtra("fee",stu.fee);
                startActivity(i);




            }
        });




        ml = findViewById(R.id.money_view_details); //
        Load_setting();



    }


    private void Load_setting(){ //

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean chk_night = sp.getBoolean("NIGHT",false);

        if (chk_night){
            ml.setBackgroundColor(Color.parseColor("#222222"));
        }else {
            ml.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        String orien = sp.getString("ORIENTATION","false");
        if ("1".equals(orien)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);

        }
        else if("2".equals(orien)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
        else if("3".equals(orien)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }

    }

    @Override //
    protected void onResume() {
        Load_setting();
        super.onResume();
    }



}
