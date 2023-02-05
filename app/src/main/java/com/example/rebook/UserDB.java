package com.example.rebook;




        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import androidx.annotation.Nullable;

        import java.util.ArrayList;

public class UserDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "userDataDB";
    private static final String TABLE_NAME = "userData";
    private static final String ID_COL = "id";
    private static final String EMAIL_COL = "email";
    private static final String PASSWORD_COL = "password";

    private static final String USERNAME_COL = "username";

    public UserDB(Context context) {
        super(context, DB_NAME, null, HomeActivity.DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + USERNAME_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }


    public void addNewUser(String email, String password, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);
        values.put(USERNAME_COL, username);
        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public void updateUser(String lastEmail, String email, String password, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);
        values.put(USERNAME_COL, username);
        db.update(TABLE_NAME, values, "email=?", new String[]{lastEmail});
        db.close();
    }



    public void updatePass(String lastPass, String email, String password, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL_COL, email);
        values.put(PASSWORD_COL, password);
        values.put(USERNAME_COL, username);
        db.update(TABLE_NAME, values, "password=?", new String[]{lastPass});
        db.close();
    }


    public ArrayList<User> fetchUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorUser = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<User> userArrayList = new ArrayList<>();

        if (cursorUser.moveToFirst()) {
            do {
                userArrayList.add(new User(cursorUser.getString(1),
                        cursorUser.getString(2),
                        cursorUser.getString(3)));
            } while (cursorUser.moveToNext());

        }

        cursorUser.close();
        return userArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
