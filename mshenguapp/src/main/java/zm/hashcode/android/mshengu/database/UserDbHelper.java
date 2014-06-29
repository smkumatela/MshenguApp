package zm.hashcode.android.mshengu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hashcode on 2014/06/27.
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static final String TAG = UserDbHelper.class.getSimpleName();

    public UserDbHelper(Context context) {
        super(context, UserTable.DB_NAME, null, UserTable.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String
                .format("create table %s (%s int primary key, %s text, %s text, %s int)",
                        UserTable.TABLE,
                        UserTable.Column.ID,
                        UserTable.Column.DEVICEKEY,
                        UserTable.Column.EMAIL,
                        UserTable.Column.PASSWORD,
                        UserTable.Column.USERNAME
                );
//
        Log.d(TAG, "onCreate with SQL: " + sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        // Typically you do ALTER TABLE ...
        db.execSQL("drop table if exists " + UserTable.TABLE);
        onCreate(db);

    }
}
