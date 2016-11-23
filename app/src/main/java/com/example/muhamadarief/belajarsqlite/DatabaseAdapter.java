package com.example.muhamadarief.belajarsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Muhamad Arief on 23/11/2016.
 */

public class DatabaseAdapter {
    SQLiteDatabase db;
    DataHelper dataHelper;

    public DatabaseAdapter(Context context){
        dataHelper = new DataHelper(context);
    }

    public void open(){
        db = dataHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long tambahData(String nama, String nim){
        ContentValues cv = new ContentValues();
        cv.put(dataHelper.COLUMN_NAMA, nama);
        cv.put(dataHelper.COLUMN_NIM, nim);

        return db.insert(dataHelper.TABLE_NAME, "", cv);
    }


    public ArrayList<Biodata> getAllBiodata(){
    ArrayList<Biodata> biodata = new ArrayList<>();
    String[] columns = new String[]{
            dataHelper.COLUMN_ID,
            dataHelper.COLUMN_NAMA,
            dataHelper.COLUMN_NIM };

    Cursor cursor = db.query(dataHelper.TABLE_NAME, columns, null, null, null, null, null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                String id = cursor.getString(cursor.getColumnIndex(dataHelper.COLUMN_ID));
                String nama = cursor.getString(cursor.getColumnIndex(dataHelper.COLUMN_NAMA));
                String nim = cursor.getString(cursor.getColumnIndex(dataHelper.COLUMN_NIM));

                Biodata bio = new Biodata(id, nama, nim);
                biodata.add(bio);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return biodata;
    }

    public void delete(String id){
      db.delete(dataHelper.TABLE_NAME, dataHelper.COLUMN_ID + "=" + id, null);
    }

    public void update(String id, String nama, String nim){
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        // New value for one column
        ContentValues cv = new ContentValues();
        cv.put(dataHelper.COLUMN_NAMA, nama);
        cv.put(dataHelper.COLUMN_NIM, nim);

        // Which row to update, based on the title
        String selection = dataHelper.COLUMN_ID + "=?";
        String[] selectionArgs = { "" +id };

        db.update(
                dataHelper.TABLE_NAME,
                cv,
                selection,
                selectionArgs);
    }



}
