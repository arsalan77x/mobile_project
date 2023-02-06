package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;



public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Button b1 = (Button) findViewById(R.id.read1);
        Button b2 = (Button) findViewById(R.id.read2);
        Button b3 = (Button) findViewById(R.id.read3);
        Button b4 = (Button) findViewById(R.id.read4);
        Button b5 = (Button) findViewById(R.id.read5);
        Button b6 = (Button) findViewById(R.id.read6);
        Button b7 = (Button) findViewById(R.id.read7);
        if (ReviewActivity.isUserHaveBook("1")) b1.setEnabled(false);
        if (ReviewActivity.isUserHaveBook("2")) b2.setEnabled(false);
        if (ReviewActivity.isUserHaveBook("3")) b3.setEnabled(false);
        if (ReviewActivity.isUserHaveBook("4")) b4.setEnabled(false);
        if (ReviewActivity.isUserHaveBook("5")) b5.setEnabled(false);
        if (ReviewActivity.isUserHaveBook("6")) b6.setEnabled(false);
        if (ReviewActivity.isUserHaveBook("7")) b7.setEnabled(false);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setEnabled(false);
                addBook("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook("2");
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook("3");
                b3.setEnabled(false);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook("4");
                b4.setEnabled(false);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook("5");
                b5.setEnabled(false);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook("6");
                b6.setEnabled(false);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b7.setEnabled(false);
                addBook("7");
            }
        });

    }

    private void addBook(String id){
        HomeActivity.userDatabase.updateUser(HomeActivity.userLoggedIn.getEmail(),
                HomeActivity.userLoggedIn.getEmail(),HomeActivity.userLoggedIn.getBook()+id, HomeActivity.userLoggedIn.getPassword(),
                HomeActivity.userLoggedIn.getUsername());
        Toast.makeText(getApplicationContext(),
                "Book added to your library!", Toast.LENGTH_SHORT).show();
        HomeActivity.userArrayList = new ArrayList<>();
        HomeActivity.userArrayList = HomeActivity.userDatabase.fetchUsers();
        HomeActivity.userLoggedIn = LoginActivity.getUserByEmail(HomeActivity.userLoggedIn.getEmail());
    }
}