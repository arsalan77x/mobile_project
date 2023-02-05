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

        Button profileButton = (Button) findViewById(R.id.profileButton);
        Button shopButton = (Button) findViewById(R.id.shopButton);
        Button libraryButton = (Button) findViewById(R.id.libraryButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.equals("")) {
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    Toast.makeText(getApplicationContext(),
                            "You are not logged in yet!", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                }

            }
        });

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ShopActivity.class));
            }
        });

        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LibraryActivity.class));
            }
        });
    }



    public void goToReview1(View view) {
        tester = "1";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }

    public void goToReview2(View view) {
        tester = "2";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }

    public void goToReview3(View view) {
        tester = "3";
        startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
    }
}