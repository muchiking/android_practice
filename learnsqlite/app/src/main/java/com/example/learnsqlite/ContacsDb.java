package com.example.learnsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ContacsDb {
    public static final String Key_Rowid="_id";
    public static final String key_name="_person_name";
    public static final String key_cell="_cell";

    private  final String Database_Name ="ContactsDB";
    private  final String Database_Table ="ContactsTable";
    private final int DATABASE_VERSION = 1;
    private  DBHelper ourhelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public ContacsDb (Context context){
        ourContext = context;
    }
    private  class  DBHelper extends SQLiteOpenHelper
    {
        public DBHelper(@Nullable Context context) {
            super(context, Database_Name, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String sqlCode= "create table "+ Database_Table +  " ("+ Key_Rowid +" integer primary key autoincrement,"+
                    key_name + " text not null, "+
                    key_cell + " text not null );";
            sqLiteDatabase.execSQL(sqlCode);


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Drop table if exists "+ Database_Table);
            onCreate(sqLiteDatabase);

        }
    }
    public ContacsDb open() throws SQLException
    {
        ourhelper = new DBHelper(ourContext);
        ourDatabase =ourhelper.getWritableDatabase();

        return this;
    }
    public void close(){
        ourhelper.close();
    }
    public long createEntry(String name,String cell){
        ContentValues cv = new ContentValues();
        Log.d("[+]" ,"createEntry: "+name+ cell);
        cv.put(key_name,name);
        cv.put(key_cell,cell);
        return ourDatabase.insert(Database_Table,null,cv);

    }
    public String getData(){
        String [] columns = new String[] {Key_Rowid,key_name,key_cell};// what data structuer is this
        Cursor c=ourDatabase.query(Database_Table,columns,null,null,null,null,null);
        String result = "";
        int iRowId = c.getColumnIndex(Key_Rowid);
        int iName = c.getColumnIndex(key_name);
        int iCell = c.getColumnIndex(key_cell);

        for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRowId)+":"+c.getString(iName) + " "+c.getString(iCell)+"\n";
            Log.d("[+]", "getData: "+ result);
        }
        c.close();
        return result;

    }
    public long deleteEntry(String rowid){
        return ourDatabase.delete(Database_Table,Key_Rowid+"=?",new String[]{rowid});
    }
    public long updateentry(String rowid,String name,String cell){
        ContentValues cv = new ContentValues();
        cv.put(key_name,name);
        cv.put(key_cell,cell);

        return ourDatabase.update( Database_Table,cv,Key_Rowid + "=?",new String[]{rowid});
    }

}
