package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;
import android.util.Log;

public class ZarzadzajDanymi
{
    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_SURNAME = "surname";
    public static final String TABLE_ROW_PESEL = "PESEL";
    public static final String TABLE_ROW_ADDRESS = "_id";
    public static final String TABLE_ROW_PHONE = "_id";

    public static final String DB_NAME = "personal_data_db";
    public static final int DB_VERSION = 1;

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper
    {
        public CustomSQLiteOpenHelper(Context context)
        {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            String newTableQueryString = "create table "
                    + TABLE_ROW_ID + " (integer primary key autoincrement not null,"
                    + TABLE_ROW_NAME
                    + TABLE_ROW_SURNAME
                    + TABLE_ROW_PESEL
                    + TABLE_ROW_ADDRESS
                    + TABLE_ROW_PHONE;
            db.execSQL(newTableQueryString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {

        }
    }

    public ZarzadzajDanymi(Context context)
    {
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }
    public void insert(String name, String surname, String pesel, String address, String phone)
    {
        String query = "INSERT INTO" + TABLE_ROW_NAME + TABLE_ROW_SURNAME
                + TABLE_ROW_PESEL + TABLE_ROW_ADDRESS + TABLE_ROW_PHONE
                + "VALUE (" +
                name + ", " + surname + ", " + pesel + ", " + address + ", " + phone + ");";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }
}