package com.example.customcalendarview.transaction;

public class Constants {
    public static final String DB_NAME = "MY_RECORD_DB";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "MY_RECORD_TABLE";
    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_IMAGE = "MY_RECORD_DB";
    public static final String C_AMOUNT = "AMOUNT";
    public static final String C_DETAILS = "DETAILS";
    public static final String C_DOB = "DATE";
    public static final String C_ADDED_TIMESTAMP = "ADDED_TIME_STAMP";
    public static final String C_UPDATE_TIMESTAMP = "UPDATE_TIME_STAMP";

    public static  final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            +C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +C_NAME + " TEXT,"
            +C_IMAGE + " TEXT,"
            +C_AMOUNT + " TEXT,"
            +C_DETAILS + " TEXT,"
            +C_DETAILS + " TEXT,"
            +C_DOB + " TEXT,"
            +C_ADDED_TIMESTAMP + " TEXT,"
            +C_UPDATE_TIMESTAMP + " TEXT,"
            +")";

}
