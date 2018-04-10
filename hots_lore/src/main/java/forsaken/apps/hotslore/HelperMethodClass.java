package forsaken.apps.hotslore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import static android.R.attr.key;
import static forsaken.apps.hotslore.R.id.bio;

/**
 * Created by Forsaken on 18.09.2017.
 */

public class HelperMethodClass {
    private static final String TAG = "myLogs";
    DBHelper dbHelper; 
    SQLiteDatabase database;
    Cursor cursor;

    void onCreateDBAPK(Context context, String nameDB, String SQLReq) {
        Log.d(TAG, "onCreateDBAPK " +nameDB);
        dbHelper = new DBHelper(context, nameDB, null, null);
        try {
            dbHelper.createDataBase();
            Log.d(TAG, "!!!CreateDatabase: " +nameDB);
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            dbHelper.openDataBase();
            Log.d(TAG, "!!!DBopened: "+nameDB);
        } catch (SQLiteException sqle) {
            throw sqle;
        }
        dbHelper.close();
    }

    int onViewDataFromFieldTable(Context context, String nameDB, String nameTableDB, String nameField, int currentString, TextView textView) {
        Log.d(TAG, "onViewDataFromFieldTable");

        dbHelper = new DBHelper(context, nameDB, null, null);
        try {
            database = dbHelper.getWritableDatabase();
            Log.d(TAG, "writableDB: "+nameDB);
        } catch (SQLiteException e) {
            database = dbHelper.getReadableDatabase();
            Log.d(TAG, "readDB: "+nameDB);
        }

        String str = "";
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        if (cursor.moveToPosition(currentString)) {
            str = cursor.getString(cursor.getColumnIndex(nameField));
        } else {
            str = "- All of this -";
            currentString = -1;
        }
        textView.setText(str);
        Log.d(TAG, "rec " + str);
        cursor.close();
        dbHelper.close();
        database.close();
        return currentString;
    }
}

