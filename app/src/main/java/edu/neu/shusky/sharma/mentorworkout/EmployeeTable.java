package edu.neu.shusky.sharma.mentorworkout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EmployeeTable{

    public static final String KEY_NAME = "exerciseName";
    public static final String KEY_SETS = "sets";
    public static final String KEY_REPS = "reps";
    public static final String KEY_ROWID = "_id";
    public static final String KEY_DATE = "date";

    private static final String TAG = "EmployeeTable";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "employee_Final";
    private static final String DATABASE_TABLE = "employee";
    private static final int DATABASE_VERSION = 3;

    /**
     * Database creation sql statement
     */
    private static final String DATABASE_CREATE =
            "create table " + DATABASE_TABLE + " (" + KEY_ROWID + " integer primary key autoincrement, "
                    + KEY_NAME +" text not null, " + KEY_SETS + " integer not null, " + KEY_REPS + " integer not null);";
    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(TAG, "Creating DataBase: " + DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     *
     * @param ctx the Context within which to work
     */
    public EmployeeTable(Context ctx) {
        this.mCtx = ctx;
    }

    public EmployeeTable open() throws SQLException {
        Log.i(TAG, "OPening DataBase Connection....");
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public long createExercise(String exerciseName, Integer set, Integer reps) {
        Log.i(TAG, "Inserting record...");
        mDb.execSQL("INSERT INTO employee (exerciseName, sets, reps) VALUES('"
                + exerciseName + "','" + set + "'," + reps + ");");
//        ContentValues initialValues = new ContentValues();
//        initialValues.put(KEY_NAME, exerciseName);
//        initialValues.put(KEY_SETS, set);
//        initialValues.put(KEY_REPS,reps);
//        return mDb.insert(DATABASE_TABLE, null, initialValues);
        return 0;
    }

    public boolean deleteEmployee(long rowId) {

        return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    public Cursor fetchAllEmployee() {


        Cursor c = mDb.rawQuery("SELECT * FROM employee",null);

        return c;
//        return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,
//                KEY_SETS,KEY_REPS}, null, null, null, null, null);
    }

    public Cursor fetchEmployee(long empId) throws SQLException {

        Cursor mCursor =

                mDb.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                                KEY_NAME, KEY_SETS,KEY_REPS}, KEY_ROWID + "=" + empId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public boolean updateEmployee(int empId, String empName, String empDesignation) {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, empName);
        args.put(KEY_SETS, empDesignation);

        return mDb.update(DATABASE_TABLE, args, KEY_ROWID + "=" + empId, null) > 0;
    }


}