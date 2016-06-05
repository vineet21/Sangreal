package com.vineet.sangreal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Dell on 22-05-2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String MAIN_DATABASE = "BayMaxDataBase.db";
    public static final String TABLE_NAME = "SUPERADMIN";
    public static final String CREATE_SCRIPT = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+ " ( " +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "USERNAME TEXT NOT NULL, " +
            "PASSWORD TEXT NOT NULL, " +
            "PHONENUMBER TEXT NOT NULL, " +
            "EMAIL TEXT NOT NULL, " +
            "DOB DATE , " +
            "ECONTACT TEXT);";
    public String Tag = "Log";
    public String DataBaseScript = null;

    public DataBaseHelper(Context context) {
        super(context, MAIN_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(Tag, "Before creating table script : "+CREATE_SCRIPT);
        db.execSQL(CREATE_SCRIPT);
        Log.i(Tag, "Table Created SuccessFully .............");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int _oldVersion, int _newVersion) {
        Log.i(Tag,  "Inside onUpgrade ........");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void InsertData(String UserName, String Password, String PhoneNum, String Email, String EconNo){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(CREATE_SCRIPT);

        Log.i(Tag, "Inside InsertData Function ...... GREATE SCRIPT : "+ CREATE_SCRIPT);
        DataBaseScript = "INSERT INTO "+TABLE_NAME+"( " +
                "USERNAME, PASSWORD, EMAIL, PHONENUMBER, ECONTACT )" +
                "VALUES ('"+UserName+"', '"+Password+"', '"+Email+"', '"+PhoneNum+"', '"+EconNo+"');";
        Log.i(Tag, "Insert Script : "+DataBaseScript);

        db.execSQL(DataBaseScript);

        Log.i(Tag, "Data Inserted SuccessFully .............");
        //return true;
    }
    public void CreateTable(){

        SQLiteDatabase db = this.getWritableDatabase();

        Log.i(Tag, "Before creating table script : "+CREATE_SCRIPT);
        db.execSQL(CREATE_SCRIPT);
        Log.i(Tag, "Table Created SuccessFully .............");
    }

    public Cursor isValidUser(String colData1,String colData2){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL(CREATE_SCRIPT);
        DataBaseScript = "SELECT * FROM "+TABLE_NAME+" WHERE USERNAME = '"+colData1+"' AND PASSWORD = '"+colData2+"';";
        Log.i(Tag, "Script to fetch Data : "+DataBaseScript);

        Cursor cursor = db.rawQuery(DataBaseScript, null);

        return cursor;
    }
    public Cursor isValidData(String colData, String colName){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL(CREATE_SCRIPT);
        DataBaseScript = "SELECT * FROM "+TABLE_NAME+" WHERE "+colName+"='"+colData+"';";
        Log.i(Tag,"isValid Function script : "+DataBaseScript);

        Cursor cursor = db.rawQuery(DataBaseScript, null);

        return cursor;

    }
    public Cursor FetchPassword(String mobileNum, String Email){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(CREATE_SCRIPT);
        DataBaseScript = "select * from "+TABLE_NAME+" where phonenumber = '"+mobileNum+"' or email = '"+Email+"';";
        Log.i(Tag, "Inside Fetching password ............."+DataBaseScript);
        Cursor cursor = db.rawQuery(DataBaseScript, null);
        Log.i(Tag,"Inside Fetching password ............. Returning .......");
        return cursor;

    }


}
