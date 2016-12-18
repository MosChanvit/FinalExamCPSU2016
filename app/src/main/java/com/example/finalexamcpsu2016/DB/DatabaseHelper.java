package com.example.finalexamcpsu2016.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lenovo on 12/18/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static  final  String TAG  = DatabaseHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "Login.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_Register = "Register";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    private static final String SQL_CRATE_TABLERegister =
            "CREATE TABLE " + TABLE_Register + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_USERNAME + " TEXT, "
                    + COL_PASSWORD + " TEXT, "
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRATE_TABLERegister);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_USERNAME, "android");
        cv.put(COL_PASSWORD, "123456");
        db.insert(TABLE_Register, null, cv);

    }

    public void AddTotalscore(String name,String username,String passworld){
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        cv.put(COL_NAME,name);
        cv.put(COL_USERNAME,username);
        cv.put(COL_PASSWORD,passworld);

        Long id = db.insert(TABLE_Register,null,cv);
        db.close();
        Log.i(TAG,"ออกแล้วโว้ย"+id);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
