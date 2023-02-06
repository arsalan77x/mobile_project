package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class ReviewActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Button raedButton = (Button) findViewById(R.id.read);
        TextView authorText = (TextView) findViewById(R.id.author);
        TextView pagesText = (TextView) findViewById(R.id.pages);
        TextView genreText = (TextView) findViewById(R.id.genre);
        TextView publishText = (TextView) findViewById(R.id.publishDate);
        TextView reviewText = (TextView) findViewById(R.id.review);
        ImageView image = (ImageView) findViewById(R.id.image);


        int idxList = Integer.parseInt(HomeActivity.tester) - 1;
        authorText.setText("Author: " + BackEmulator.authorList.get(idxList));
        genreText.setText("Genre: " + BackEmulator.genreList.get(idxList));
        publishText.setText("Publish date: " + BackEmulator.yearList.get(idxList));
        pagesText.setText("Pages: " + BackEmulator.pageList.get(idxList));
        reviewText.setText("Review: " + BackEmulator.sumList.get(idxList));
        LibraryActivity.reflect(HomeActivity.tester, image);


        if (HomeActivity.userLoggedIn == null ) {
            raedButton.setText("Buy this book");
        } else if (!isUserHaveBook(HomeActivity.tester)) {
            raedButton.setText("Buy this book");
        } else {
            raedButton.setText("Read this book");
        }
        Toast toast = Toast.makeText(this, "You are not logged in.", Toast.LENGTH_LONG);

        raedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (HomeActivity.userLoggedIn == null) {
                    toast.show();
                    startActivity(new Intent(ReviewActivity.this, LoginActivity.class));
                } else if (!isUserHaveBook(HomeActivity.tester)) {
                    startActivity(new Intent(ReviewActivity.this, ShopActivity.class));
                } else {
                    startActivity(new Intent(ReviewActivity.this, ReaderActivity.class));
                }

            }
        });
    }

    public static boolean isUserHaveBook(String c) {
        for (int i = 0; i < HomeActivity.userLoggedIn.getBook().length(); i++) {
            if ((HomeActivity.userLoggedIn.getBook().charAt(i) + "").equals(c)) {
                return true;
            }
        }
        return false;
    }
}