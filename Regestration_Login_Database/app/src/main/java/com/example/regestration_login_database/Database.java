package com.example.regestration_login_database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class Database extends SQLiteOpenHelper {
    public static final String DB_NAME = "sumitha";
    public static final String TB_NAME = "register";
    public static final String COL1 = "Name";
    public static final String COL2 = "Age";
    public static final String COL3 = "Gender";
    public static final String COL4 = "DOB";
    public static final String COL5 = "Username";
    public static final String COL6 = "Password";
    public Database(@Nullable Context context) {
        super(context, DB_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME+"("+COL1+" TEXT, "+COL2+" TEXT,"+COL3+" TEXT, "+COL4+" TEXT,"+COL5+" TEXT, "+COL6+" TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean insertData(String name,String age,String gen,String dob,String user,String pass) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1 ,name);
        cv.put(COL2 ,age);
        cv.put(COL3 ,gen);
        cv.put(COL4 ,dob);
        cv.put(COL5,user);
        cv.put(COL6 ,pass);
        long b = db.insert(TB_NAME,null,cv);
        if (b == -1)
            return false;
        else return true;
    }
    public boolean chkLogin1(String user, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {COL5};
        String selection = COL5+"=?" +" AND " +COL6+"=?";
        String[] selargs = {user,pass};
        Cursor cs = db.query(TB_NAME,columns,selection,selargs,null,null,null);
        int count = cs.getCount();
        if(count > 0)
            return true;
        else
            return false;
    }
}
