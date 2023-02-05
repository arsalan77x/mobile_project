package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReaderActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static int pageCounter = 0;
    public static ArrayList<String> contentList =  new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);




        String string = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.book1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int counter = 0;
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            counter += 1;
            stringBuilder.append(string).append(" ");

            if (counter == 10) {

                Log.d(LOG_TAG,  stringBuilder.toString());
                contentList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                pageCounter += 1;
                counter = 0;
            }

        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(LOG_TAG,  Integer.toString(pageCounter));
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        pageAdapter adapter = new pageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


    }
}

