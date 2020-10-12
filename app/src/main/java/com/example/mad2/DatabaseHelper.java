package com.example.mad2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static final String DATABASE_NAME = "Fitness.db";
    public  static final String TABLE_NAME = "user_table";
    public  static final String COL_1 = "ID";
    public  static final String COL_2 = "NAME";
    public  static final String COL_3 = "EMAIL";
    public  static final String COL_4 = "AGE";




    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null , 1);
        SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,AGE INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion , int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //insert data

    public boolean insertData(String name , String email, String age){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,age);

       long result =  db.insert(TABLE_NAME,null,contentValues);
       if (result== -1)
           return false;
       else
           return  true;
    }

    //getdata  from db

    public Cursor ViewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null );
        return  res;
    }


    public boolean updateData(String name , String email, String age){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,age);
        db.update(TABLE_NAME,contentValues,"name = ?",new String[]{name});
        return true;

    }
}
