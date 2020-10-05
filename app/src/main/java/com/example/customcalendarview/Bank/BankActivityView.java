package com.example.customcalendarview.Bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.customcalendarview.BankActivity;
import com.example.customcalendarview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BankActivityView extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addbutton;

    DbHelper myDB;
    ArrayList<String> name,amount;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_view);

        recyclerView = findViewById(R.id.recyclerView);
        addbutton = findViewById(R.id.floatingAddButton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankActivityView.this,AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new DbHelper(BankActivityView.this);

        name = new ArrayList<>();
        amount = new ArrayList<>();

        displayData();

        customAdapter = new CustomAdapter(BankActivityView.this,name,amount);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BankActivityView.this));
    }

    void displayData(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                amount.add(cursor.getString(1));
            }
        }
    }
}
