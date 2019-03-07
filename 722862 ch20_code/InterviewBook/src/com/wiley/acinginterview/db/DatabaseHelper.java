package com.wiley.acinginterview.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static DatabaseHelper instance;
    
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WILEYDB";
    private static final String TABLE_NAME = "People";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";

    private DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    public static DatabaseHelper getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    /**
     * create a database with id column plus two fields
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        final String createStatement = "CREATE TABLE " + TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + 
                COLUMN_NAME + "TEXT, " +
                COLUMN_AGE + "INTEGER);";
        db.execSQL(createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        dropTables(db);
    }
    
    private void dropTables(SQLiteDatabase db)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }
    
    public int queryForAge(String name, Context context)
    {
        int age = -1;
        final DatabaseHelper helper = DatabaseHelper.getInstance(context);
        final SQLiteDatabase db = helper.getReadableDatabase();
        final String [] columns = new String [] {COLUMN_NAME, COLUMN_AGE};
        final String selection = COLUMN_NAME + "=?";
        final String [] args = new String [] {name};
        
        Cursor cursor = db.query(TABLE_NAME, columns, selection, args, null,  null,  null);
        try
        {
            final boolean hasData = cursor.moveToFirst();
            if (hasData)
            {
                final int columnIndex = cursor.getColumnIndex(COLUMN_AGE);
                age = cursor.getInt(columnIndex);
            }
        }
        finally
        {
            cursor.close();
        }
        return age;
    }
    
    public void insertNameAges(String [] names, int [] ages, Context context)
    {
        final DatabaseHelper helper = DatabaseHelper.getInstance(context);
        final SQLiteDatabase db = helper.getReadableDatabase();
        
        for (int i = 0; i < names.length; i++)
        {
            final ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, names[i]);
            values.put(COLUMN_AGE, ages[i]);
            db.insert(TABLE_NAME, null, values);
        }
        db.close();
    }
}