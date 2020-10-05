package com.example.customcalendarview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.customcalendarview.Bank.BankActivityView;
import com.example.customcalendarview.Money.MoneyMainActivity;
import com.example.customcalendarview.todolist.ToDoMainActivity;
import com.example.customcalendarview.transaction.TranscationActivity;

public class GridView extends AppCompatActivity {

    private LinearLayout ml;
    ImageButton calendarbtn,transactionbtn,toDoListbtn,settingbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        ml = findViewById(R.id.mLaout);
        Load_setting();

        calendarbtn = findViewById(R.id.calendarBtn);
        transactionbtn = findViewById(R.id.transactionBtn);
        toDoListbtn = findViewById(R.id.toDoListBtn);
        settingbtn = findViewById(R.id.settingBtn);

        calendarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(GridView.this,MainActivity.class));
            }
        });
        transactionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridView.this, MoneyMainActivity.class));
            }
        });
        toDoListbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridView.this, ToDoMainActivity.class));
            }
        });

        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridView.this,Preference.class));
            }
        });

    }

    private  void Load_setting(){

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

    @Override
    protected void onResume() {
        Load_setting();
        super.onResume();
    }
}
