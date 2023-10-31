package com.example.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Db extends SQLiteOpenHelper {
    public static  final  int DATABASE_VERSION = 1;
    public static  final  String DATABASE_NAME = "usDB";
    public static  final  String DATABASE_TABLE = "users";

    public static  final  String KEY_ID = "_id";
    public static  final  String KEY_NAME = "name";
    public static  final  String KEY_MAIL = "mail";


    public Db( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DATABASE_TABLE + "(" + KEY_ID + " integer primary key," + KEY_NAME + " text,"
                + KEY_MAIL + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
