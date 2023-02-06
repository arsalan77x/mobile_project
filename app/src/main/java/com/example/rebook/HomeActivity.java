package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public static ArrayList<User> userArrayList;
    public static User userLoggedIn;
    public static SQLiteDatabase loggedInUser;
    public static UserDB userDatabase;
    public static final int DB_VERSION = 1;
    String email = "";
    public static String tester = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userDatabase = new UserDB(HomeActivity.this);
        userArrayList = new ArrayList<>();
        userArrayList = userDatabase.fetchUsers();

        loggedInUser = openOrCreateDatabase("loggedInUser", MODE_PRIVATE, null);
        loggedInUser.execSQL("CREATE TABLE IF NOT EXISTS LoggedIn (Username TEXT);");
        Cursor resultSet = loggedInUser.rawQuery("Select * from LoggedIn", null);

        resultSet.moveToFirst();


        if (resultSet.getCount() == 0) {
            email = "";
        } else {
            email = resultSet.getString(0);
            userLoggedIn = LoginActivity.getUserByEmail(email);
        }

    }



    public void goShop(View view) {
        if (userLoggedIn == null) {
            Toast toast = Toast.makeText(this, "You are not logged in.", Toast.LENGTH_LONG);
            toast.show();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        }
        else {
            startActivity(new Intent(HomeActivity.this, ShopActivity.class));
        }

    }

    public void goLibrary(View view) {
        if (userLoggedIn == null) {
            Toast toast = Toast.makeText(this, "You are not logged in.", Toast.LENGTH_LONG);
            toast.show();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        } else{
            startActivity(new Intent(HomeActivity.this, LibraryActivity.class));
        }

    }

    public void goProfile(View view) {
        if (email.equals("")) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            Toast.makeText(getApplicationContext(),
                    "You are not logged in yet!", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
        }
    }
    public void goExit(View view) {
        HomeActivity.this.finish();
        System.exit(0);
    }

    public void go1(View view) {
        tester="1";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }
    public void go2(View view) {
        tester="2";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }
    public void go3(View view) {
        tester="6";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }
    public void go4(View view) {
        tester="3";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }
}