package com.example.mydairy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataBaseHelper extends SQLiteOpenHelper {



    public DataBaseHelper(Context context) {
        super(context, "noteDatebase", null, 1);
    }
    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE notes (id INT PRIMARY KEY AUTOINCREMENT," +
                " date TEXT  ," +
                "note TEXT " +
                ")";
        db.execSQL(table);
    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        // Log the version upgrade.
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");
        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        _db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");

        // Create a new one.
        onCreate(_db);
    }



    public boolean addNote(notesDataObject note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", note.getDate());

        values.put("note", note.getNoteData());
        // insert
        try{
            db.insert("notes",null, values);
            db.close();
            return true;

        }catch(Exception e){
            return false;
        }

    }

    public List<notesDataObject> getNotes(){
        List<notesDataObject> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] s = {"date","note"};

        Cursor cursor = db.query("notes",s,null,null,null,null,null);

        while(cursor.moveToNext()) {
            String date = cursor.getString(cursor.getColumnIndex("date"));
            String note = cursor.getString(cursor.getColumnIndex("note"));
            notesDataObject temp = new notesDataObject(date, note);
            list.add(temp);
        }

        Collections.reverse(list);
        return list;
    }

}
