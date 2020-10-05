package com.example.customcalendarview;

public class CheckingAccount extends BankAccount {

    private static double serviceCharge = 3000.0;
    private static double upperLimit = 200000.0;
    public CheckingAccount(String accountName, String accountNumber, int accountType, double balance) {
        super(accountName, accountNumber, accountType, balance);
    }

    @Override
    public String withdraw(double amount) {
      if(amount<=upperLimit){
          super.setBalance(super.getBalance()-amount);
          return "Your account has been debited with amount"+amount;
      }
        return "Upper limit exceeded";
    }

  

    public static double getServiceCharge() {
        return serviceCharge;
    }

    public static void setServiceCharge(double serviceCharge) {
        CheckingAccount.serviceCharge = serviceCharge;
    }

    public static double getUpperLimit() {
        return upperLimit;
    }

    public static void setUpperLimit(double upperLimit) {
        CheckingAccount.upperLimit = upperLimit;
    }
}
