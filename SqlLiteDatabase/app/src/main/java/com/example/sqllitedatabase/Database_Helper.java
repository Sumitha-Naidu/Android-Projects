package com.example.sqllitedatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Database_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ClgDB";
    public static final String TABLE_NAME = "student";
    public static final String COL1 = "ROLLNO";
    public static final String COL2 = "NAME";
    public static final String COL3 = "AGE";
    public Database_Helper(Context con) { super(con,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("+COL1+" INTEGER PRIMARY KEY,"+COL2+" TEXT,"+COL3+" TEXT )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String rn,String name,String age)
    {
        SQLiteDatabase sb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1,rn);
        cv.put(COL2,name);
        cv.put(COL3,age);
        long res = sb.insert(TABLE_NAME,null,cv);
        if(res == -1)
            return false;
        else
            return true;
    }
    public Cursor viewData() {
        SQLiteDatabase sb = this.getWritableDatabase();
        Cursor cs = sb.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cs;
    }
    public boolean updateData(String rn,String name,String age) {
        SQLiteDatabase sb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2,name);
        cv.put(COL3,age);
        sb.update(TABLE_NAME,cv,"ROLLNO = "+rn,null);
            return true;
    }
    public int deleteData(String rn) {
        SQLiteDatabase sb = this.getWritableDatabase();
        int cn = sb.delete(TABLE_NAME,"ROLLNO = "+rn,null);
        return cn;
    }
}
