package com.example.loginsystem;

import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "database";
    static int version = 1;

    String createTableUser = "CREATE TABLE if not exists `user` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `username` TEXT," +
            " `full_name` TEXT,`password` TEXT, `email` TEXT, `suid` TEXT )";


    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);


    }

    public void insertUser(ContentValues contentValues) {
        getWritableDatabase().insert("user", "", contentValues);
    }

    public boolean isLoginValid(String username, String password) {
        String sql = "Select count(*) from user where username='" + username + "' and password='" + password + "'";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();
        statement.close();

        if (l == 1) {
            return true;

        } else {
            return false;
        }


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String loadHandler() {
        String result = "";
        String query = "Select*FROM user";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
}