package com.example.leo.pitscout1;

/**
 * Created by leo on 1/20/17.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.database.SQLException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DBHandler extends SQLiteOpenHelper {


    // TODO THis should be put in a constant class but I could't figure out
    // how to access the private variables.
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "TestPit_db";
    // Match table name
    private static final String MATCH_TABLE = "pit_info";
    // Match Table Columns names
    private static final String KEY_ID = "_id";
    private static final String COL1 = "team_num";
    private static final String COL2 = "shoots_low";
    private static final String COL3 = "shoots_high";
    private static final String COL4 = "picks_up";
    private static final String COL5 = "loads_gears";
    private static final String COL6 = "climbs";
    private static final String COL7 = "defense_type";
    private static final String COL8 = "ball_cap";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MATCH_TABLE = "CREATE TABLE " + MATCH_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL1 + " TEXT,"
                + COL2 + " TEXT," + COL3 + " TEXT," + COL4 + " TEXT" + COL5 + " TEXT"
                + COL6 + " TEXT" + COL7 + " TEXT" + COL8 + " TEXT" + ")";
        db.execSQL(CREATE_MATCH_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + MATCH_TABLE);
// Creating tables again
        onCreate(db);
    }


    public long addPitData(PitScoutData m) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(COL1, m.getTeam_num());
        initialValues.put(COL2, m.getShoots_low());
        initialValues.put(COL3, m.getShoots_high());
        initialValues.put(COL4, m.getPicks_up());
        initialValues.put(COL5, m.getLoads_gears());
        initialValues.put(COL6, m.getClimbs());
        initialValues.put(COL7, m.getDefense_type());
        initialValues.put(COL8, m.getBall_cap());

        return db.insert(MATCH_TABLE, null, initialValues);
    }

    public long updatePitData(PitScoutData m) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(COL1, m.getTeam_num());
        initialValues.put(COL2, m.getShoots_low());
        initialValues.put(COL3, m.getShoots_high());
        initialValues.put(COL4, m.getPicks_up());
        initialValues.put(COL5, m.getLoads_gears());
        initialValues.put(COL6, m.getClimbs());
        initialValues.put(COL7, m.getDefense_type());
        initialValues.put(COL8, m.getBall_cap());

        return db.update(MATCH_TABLE, initialValues, KEY_ID + " = ?",
                new String[]{String.valueOf(m.getId())});
    }

    // Deleting a match row
    public void deletePitData(PitScoutData m) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MATCH_TABLE, KEY_ID + " = ?",
                new String[]{String.valueOf(m.getId())});
        db.close();
    }

    public boolean deleteAllPitData() {
        SQLiteDatabase db = this.getWritableDatabase();

        int doneDelete = 0;
        doneDelete = db.delete(MATCH_TABLE, null, null);
        //Put a toast in main activity to say delete is done.
        //Log.w(TAG, Integer.toString(doneDelete));
        db.close();
        return doneDelete > 0;

    }

    public Cursor fetchAllMatches() {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor mCursor = db.query(MATCH_TABLE, new String[]{KEY_ID,
                        COL1, COL2, COL3, COL4, COL5, COL6, COL7, COL8},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}