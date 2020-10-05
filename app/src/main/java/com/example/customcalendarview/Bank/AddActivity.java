package com.example.customcalendarview.Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.customcalendarview.R;

public class AddActivity extends AppCompatActivity {
    EditText nameInput,amountInput;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameInput = findViewById(R.id.editname);
        amountInput = findViewById(R.id.editAmount);
        addButton = findViewById(R.id.addbutton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper myDB = new DbHelper(AddActivity.this);
                myDB.add(nameInput.getText().toString().trim(),
                        Integer.valueOf(amountInput.getText().toString().trim()));
            }
        });
    }
}
