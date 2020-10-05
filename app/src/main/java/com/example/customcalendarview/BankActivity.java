package com.example.customcalendarview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class BankActivity extends AppCompatActivity {

    private TextInputEditText nameET,balanceET;
    private RadioGroup typeGruop;
    private int accountType =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        nameET = findViewById(R.id.accNameInput);
        balanceET = findViewById(R.id.balanceInput);
        typeGruop = findViewById(R.id.typeRadioGroup);
        typeGruop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               accountType = group.indexOfChild(findViewById(checkedId));
                //Toast.makeText(BankActivity.this,""+accountType,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openNewAccount(View view) {

        String name = nameET.getText().toString();
        double balance = Double.parseDouble(balanceET.getText().toString());
        BankAccount bankAccount = null;
        switch (accountType){
            case 0:
                bankAccount = new SavingAccount(name,"SA-000001",accountType,balance);
                break;
                case 1:
                bankAccount = new CheckingAccount(name,"CA-000001",accountType,balance);
                break;
        }
        Intent intent = new Intent(BankActivity.this,AccountDetailsActivity.class);
        intent.putExtra("bank",bankAccount);
        startActivity(intent);

    }
}
