package com.example.customcalendarview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ml; //


    CustomCalendarView customCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customCalendarView = (CustomCalendarView) findViewById(R.id.custom_calendar_view);


        ml = findViewById(R.id.activity_custom_calendar); //
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
