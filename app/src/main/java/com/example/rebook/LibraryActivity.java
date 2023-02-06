package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class LibraryActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

       // @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imgBook1 = (ImageView) findViewById(R.id.imgBook1);
       // new DownloadImageFromInternet((ImageView) findViewById(R.id.imgBook1)).execute("https://pbs.twimg.com/profile_images/630285593268752384/iD1MkFQ0.png");

        LinearLayout root = findViewById(R.id.main);
        HorizontalScrollView yourBooks = new HorizontalScrollView(this);
        yourBooks.setLayoutParams(new HorizontalScrollView.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                300));
        yourBooks.setHorizontalScrollBarEnabled(false);
        yourBooks.setForegroundGravity(Gravity.CENTER_HORIZONTAL);


        TextView title1 = new TextView(this);
        title1.setText("Your books");
        LinearLayout.LayoutParams titleLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        title1.setTextSize(20);
        titleLayout.setMargins(50, 30, 0, 10);
        title1.setLayoutParams(titleLayout);

        root.addView(title1);
        root.addView(yourBooks);

        LinearLayout hLinear = new LinearLayout(this);
        hLinear.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        hLinear.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

        hLinear.setOrientation(LinearLayout.HORIZONTAL);
        yourBooks.addView(hLinear);


        for (int i = 0; i < HomeActivity.userLoggedIn.getBook().length(); i++) {
            ImageView img1 = new ImageView(this);
            img1.setLayoutParams(new LinearLayout.LayoutParams(240,
                    300,1.0f));

            reflect(HomeActivity.userLoggedIn.getBook().charAt(i)+"",img1);
            hLinear.addView(img1);
        }





    }

    public static void reflect(String bookId,ImageView img){
        if (Objects.equals(bookId, "1")) img.setImageResource(R.drawable.book1);
        if (Objects.equals(bookId, "2")) img.setImageResource(R.drawable.book2);
        if (Objects.equals(bookId, "3")) img.setImageResource(R.drawable.book3);
        if (Objects.equals(bookId, "4")) img.setImageResource(R.drawable.book4);
        if (Objects.equals(bookId, "5")) img.setImageResource(R.drawable.book5);
        if (Objects.equals(bookId, "6")) img.setImageResource(R.drawable.book6);
        if (Objects.equals(bookId, "7")) img.setImageResource(R.drawable.book7);
    }

}



