package com.example.customcalendarview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customcalendarview.bankutiles.BankUtils;

public class AccountDetailsActivity extends AppCompatActivity {

    private TextView nameTV,accNumberTV,balanceTV,typeTV,rateTV,serviceChargeTV;
    private TableRow rateRow,serviceChargeRow;
    private BankAccount bankAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        nameTV=findViewById(R.id.row_accountName);
        accNumberTV=findViewById(R.id.row_accountNumber);
        balanceTV=findViewById(R.id.row_accountBalance);
        typeTV=findViewById(R.id.row_accountType);
        rateTV=findViewById(R.id.row_interestRate);
        serviceChargeTV=findViewById(R.id.row_serviceCharge);
        rateRow=findViewById(R.id.rateRow);
        serviceChargeRow=findViewById(R.id.serviceRow);
        Intent intent = getIntent();
        bankAccount =(BankAccount) intent.getSerializableExtra("bank");
        if (bankAccount !=null){
            //Toast.makeText(this, bankAccount.getAccountName(), Toast.LENGTH_SHORT).show();
            showInfo(bankAccount);
        }
    }

    private void showInfo(BankAccount bankAccount) {
      nameTV.setText(bankAccount.getAccountName());
      accNumberTV.setText(bankAccount.getAccountNumber());
      balanceTV.setText(String.valueOf(bankAccount.getBalance()));
      if (bankAccount.getAccountType()==0){
          typeTV.setText(BankUtils.AccountType.SAVING);
          rateRow.setVisibility(View.VISIBLE);
          rateTV.setText(String.valueOf(SavingAccount.getInterestRate()));
          serviceChargeRow.setVisibility(View.GONE);
      }
      else if(bankAccount.getAccountType()==1){
          typeTV.setText(BankUtils.AccountType.CHECKING);
          serviceChargeTV.setText(String.valueOf(CheckingAccount.getServiceCharge()));
      }
    }

    public void depositAmount(View view) {
        showDepositDialog();
    }

    private void showDepositDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deposit");
        final EditText editText = new EditText(this);
        editText.setHint("Enter Deposit Amount");
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);
        builder.setPositiveButton("Deposit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                double amount = Double.parseDouble(editText.getText().toString());
                depositNewAmount(amount);
            }
        });
        builder.setNegativeButton("Cancel",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void depositNewAmount(double amount) {
        final String msq =  bankAccount.deposit(amount);
        balanceTV.setText(String.valueOf(bankAccount.getBalance()));
        BankUtils.showMessage(this,msq).show();
    }

    public void withdrawAmount(View view) {
    }
}
