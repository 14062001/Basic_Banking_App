package com.example.basic_banking_app.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Currency;

public class DBHelper extends SQLiteOpenHelper {
    private static final String LOGCAT ="created" ;

    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdetails(Name TEXT primary key, Contact TEXT,Email TEXT,Currbal TEXT)");
        db.execSQL("insert into Userdetails values('Mahesh',100000,'Mahesh@gmail.com',100)");
        db.execSQL("insert into Userdetails values('Mina',200000,'mina@gmail.com',200)");
        db.execSQL("insert into Userdetails values('Rohan',300000,'rohan@gmail.com',300)");
        db.execSQL("insert into Userdetails values('Vina',400000,'vina@gmail.com',100)");
        db.execSQL("insert into Userdetails values('Radhika',500000,'radhika@gmail.com',200)");
        db.execSQL("insert into Userdetails values('Rakesh',600000,'rakesh@gmail.com',300)");
        db.execSQL("insert into Userdetails values('Sudhir',700000,'sudhir@gmail.com',100)");
        db.execSQL("insert into Userdetails values('Ram',800000,'ram@gmail.com',200)");
        db.execSQL("insert into Userdetails values('Sam',900000,'sam@gmail.com',300)");
        db.execSQL("insert into Userdetails values('Radha',150000,'radha@gmail.com',300)");
        Log.d(LOGCAT,"created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Userdetails");
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails", null);
        return cursor;
    }


    public boolean insertdata(String Name,String Contact,String Email,String Currbal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name: ", Name);
        contentValues.put("Contact no: ", Contact);
        contentValues.put("Email: ", Email);
        contentValues.put("Current Balance: ",Currbal);
        Long result=db.insert("Userdeatils", null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public String getSearchedCus(String nm) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * from Userdetails where Name = ?",new String[]{nm});
        if (cursor != null)
            cursor.moveToFirst();

        String detail = "Name: "+ cursor.getString(0)+"\nContact no: "+cursor.getString(1)+"\nEmail: "+cursor.getString(2)+"\nCurrent Balance: "+ cursor.getString(3);
        return detail;
    }

    public ArrayList<String> getAllCustomer() {
        ArrayList<String> cus = new ArrayList<>();
        String selectQuery = "Select * from Userdetails";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String detail = "Name: "+ cursor.getString(0)+"\nContact no: "+cursor.getString(1)+"\nEmail: "+cursor.getString(2)+"\nCurrent Balance: "+ cursor.getString(3);
                cus.add(detail);
            } while (cursor.moveToNext());
        }

        return cus;
    }


}
