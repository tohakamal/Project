package com.example.customcalendarview.transaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;

import com.example.customcalendarview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TranscationActivity extends AppCompatActivity {

    private LinearLayout ml; //

    private FloatingActionButton addRecordBtn;
    private RecyclerView recordsRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcation);

        addRecordBtn = findViewById(R.id.addRecordBtn);

        recordsRv = findViewById(R.id.recordRv);

        addRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity( new Intent(TranscationActivity.this,addUpdateRecordActivity.class));
            }
        });


        ml = findViewById(R.id.money_view); //
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
