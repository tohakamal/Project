package com.example.customcalendarview.bankutiles;

import android.app.AlertDialog;
import android.content.Context;

public final class BankUtils {
    public static class AccountType{
        public static final String SAVING ="Savings Account";
        public static final String CHECKING ="Checking Account";

    }
    public static AlertDialog showMessage(Context context,String msg){
      AlertDialog.Builder builder = new AlertDialog.Builder(context);
      builder.setTitle("Deposit Successful");
      builder.setMessage(msg);
      builder.setNegativeButton("OK",null);
      return builder.create();
    }
}
