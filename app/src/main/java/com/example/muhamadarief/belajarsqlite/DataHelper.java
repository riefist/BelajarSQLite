package com.example.muhamadarief.belajarsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Muhamad Arief on 23/11/2016.
 */

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "biodata.db";

    public static final String TABLE_NAME = "biodata";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_NIM = "nim";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE_SQL = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAMA + " TEXT,"
            + COLUMN_NIM + " TEXT );";

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DataHelper", "onCreate : " +CREATE_TABLE_SQL);
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
