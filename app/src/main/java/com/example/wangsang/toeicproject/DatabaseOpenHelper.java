package com.example.wangsang.toeicproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="toeic1.db";
    public static final String TABLE_NAME ="part5";
    public static final String COL_1 ="CONTENT";
    public static final String COL_2 ="A";
    public static final String COL_3 ="B";
    public static final String COL_4 ="C";
    public static final String COL_5 ="D";
    public static final String COL_6 ="ANSWER";



    DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "( "
                                + COL_1 + " TEXT PRIMARY KEY, "
                                + COL_2 + " TEXT, "
                                + COL_3 + " TEXT, "
                                + COL_4 + " TEXT, "
                                + COL_5 + " TEXT, "
                                + COL_6 + " TEXT )"
                  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}
