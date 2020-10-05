package com.example.myapplication123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Database extends SQLiteOpenHelper {

   //Database Version
    private static final int DATABASE_VERSION =1;

    //Database Name
    private static final String DATABASE_NAME = "Fitness_database";
    //Database Table Name
    private static final String TABLE_NAME = "User";
    //Table Colums
    public static final String ID = "id";
    public static final String Name = "name";
    public static final String email = "email";
    public static final String age = "age";
    private SQLiteDatabase sqLiteDatabase;

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+Name+"TEXT NOT NULL,"+email+"TEXT NOT NULL,"+age+"TEXT NOT NULL);";

    //CONSTRUCTOR
    public Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //ADD USER DATA
    public void addUser(UserModuleClass userModuleClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.Name,userModuleClass.getName());
        contentValues.put(Database.email,userModuleClass.getEmail());
        contentValues.put(Database.age,userModuleClass.getAge());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(Database.TABLE_NAME,null,contentValues);

    }

    public List<UserModuleClass>getUserList(){
        String sql = "select * from "+ TABLE_NAME;
        sqLiteDatabase =  this.getReadableDatabase();
        List<UserModuleClass> storeUser = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String age = cursor.getString(3);
                storeUser.add(new UserModuleClass(id,name,email,age));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeUser;
    }
}
