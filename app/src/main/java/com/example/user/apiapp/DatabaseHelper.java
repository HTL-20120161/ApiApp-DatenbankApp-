package com.example.user.apiapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 28.02.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String Database_name = "Alkohol.db";
    public static final String Table_first = "Gin";
    public static final String Table_secound = "Rum";
    public static final String Eintrag_1 = "ID";
    public static final String Eintrag_2 = "NAME";
    public static final String Eintrag_3 = "PREIS";



    public DatabaseHelper(Context context) {
        super(context, Database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists "+Table_first+";");
        db.execSQL("create table if not exists " + Table_first + "(" + Eintrag_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PREIS TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table IF exits "+Table_first);
        onCreate(db);

    }

    public boolean InsertTable_first(String name, String preis)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Eintrag_2,name);
        contentValues.put(Eintrag_3, preis);

        long result = db.insert(Table_first,null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean InsertTable_secound(String name, String preis)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Eintrag_2,name);
        contentValues.put(Eintrag_3,preis);

        long result = db.insert(Table_secound,null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }



    public Cursor getTableDataTable_first()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_first+";",null);
        return res;

    }
    public Cursor getTableDataTable_secound()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_secound+";",null);
        return res;

    }

    public Integer LöschenTable_first(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_first,"ID = ?",new String[] {id});

    }
    public Integer LöschenTable_secound(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_secound,"ID = ?",new String[] {id});

    }



}
