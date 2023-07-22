package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";
    public database(Context context){
        super(context, "Signup.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDb){
        myDb.execSQL("create Table users(username TEXT primary key, password TEXT)");
        myDb.execSQL("create Table balance(bl TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDb, int i, int i1){
        myDb.execSQL("drop Table if exists users");
        myDb.execSQL("drop Table if exists balances");
        onCreate(myDb);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDb.insert("users", null, contentValues);
        if (result==-1) return false;
        else return true;
    }

    public void insertbalance(String bl){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("balance", bl);
        myDb.insert("balances", null, contentValues);
        myDb.close();

    }

    public ArrayList<String> getlist()
    {
        SQLiteDatabase myDb = getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursor = myDb.rawQuery("select * from balance", null);
        if(cursor.moveToFirst()){
            do{
                arrayList.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        myDb.close();
        return arrayList;
    }

    public String getbalance(){
        SQLiteDatabase myDb = this.getReadableDatabase();
        String sum;
        Cursor cursor = myDb.rawQuery("select * from balance", null);
        if(cursor.moveToFirst()){
            sum = String.valueOf(cursor.getInt(0));
        }
        else {
            sum = "0";
        }
        cursor.close();
        myDb.close();
        return sum;
    }

    public int updatepassword(String username, String password){
        SQLiteDatabase myDb = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        return  myDb.update("users",  contentValues, "username = ?", new String[]{username});

    }

    public Boolean checkusername(String username){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from users where username = ?", new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }
        else return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount()>0){
            return true;
        }
        else return false;
    }
}


