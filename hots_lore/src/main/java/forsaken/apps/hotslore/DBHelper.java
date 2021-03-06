package forsaken.apps.hotslore;

import android.content.Context;
import android.content.res.Resources;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Forsaken on 11.09.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "myLogs";
    Context context;
    private  String DB_PATH = "/data/data/forsaken.apps.hotslore/databases/";
    private String DB_NAME = "";
    private SQLiteDatabase mDataBase;
    public  DBHelper (Context context, String nameDB, SQLiteDatabase.CursorFactory factory, String SQLReq){
        super(context, nameDB, null, 1);
        Log.d(TAG, "super");
        this.context=context;
        this.DB_NAME = nameDB;
    }
    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();
        if (dbExist){}
        else {
            this.getReadableDatabase();
            try{copyDataBase();}
            catch (IOException e) {throw new Error("Error copying database");}
        }
    }
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e){}
        if (checkDB != null){checkDB.close();}
        return checkDB!=null;
    }
    private void copyDataBase() throws IOException{
        InputStream myInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer,0,length);
        }
        myOutput.flush(); myOutput.close(); myInput.close();
    }
    public void openDataBase() throws SQLException{
        String myPath = DB_PATH+DB_NAME;
        mDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
    @Override
    public  synchronized void close(){
        if(mDataBase !=null) {mDataBase.close();}
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    @Override
    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
