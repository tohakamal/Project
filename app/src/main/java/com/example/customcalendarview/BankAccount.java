package com.example.customcalendarview;

import java.io.Serializable;

public abstract class BankAccount implements Serializable {
    private String accountName;
    private String accountNumber;
    private int accountType;
    private double balance;

    public BankAccount(String accountName, String accountNumber, int accountType, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
    public abstract String withdraw(double amount);
    public final String deposit(double amount){
        setBalance(getBalance()+amount);
        return "Your account has been credited with amount"+amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}

