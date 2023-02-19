package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1="create table user(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username,String email,String password){
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);

        SQLiteDatabase dbase=getWritableDatabase();
        dbase.insert("users",null,contentValues);
        dbase.close();

    }

    public int login(String username,String password){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;

        SQLiteDatabase dbase =getReadableDatabase();
        Cursor cursor =dbase.rawQuery("select * from users where username=? and password=?",str);
        if (cursor.moveToFirst()){
            result=1;
        }

        return result;
    }



}
