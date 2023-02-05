package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button registerButton = (Button) findViewById(R.id.loginButton);
        EditText emailText = (EditText) findViewById(R.id.loginEmailText);
        EditText passwordText = (EditText) findViewById(R.id.loginPasswordText);
        Button noAccountButton = (Button) findViewById(R.id.noAccountButton);
        Button mainMainButton = (Button) findViewById(R.id.mainMenuButton);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        noAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        mainMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString();
                if (email.matches(emailPattern) && email.length() > 0
                        && RegisterActivity.isUserExist(email) && password.length() > 3 &&
                        isPasswordMatch(email,password)) {
                    Toast.makeText(getApplicationContext(),
                            "you're logged in!", Toast.LENGTH_SHORT).show();
                    ContentValues values = new ContentValues();
                    values.put("Username", email);
                    HomeActivity.loggedInUser.insert("LoggedIn", null, values);
                    User.loggedInUser = getUserByEmail(email);
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                } else{
                    Toast.makeText(getApplicationContext(),
                            "incorrect info!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public static User getUserByEmail(String email){
        for (int i = 0; i < HomeActivity.userArrayList.size(); i++) {
            if (HomeActivity.userArrayList.get(i).getEmail().equals(email)){
                return HomeActivity.userArrayList.get(i);
            }
        }
        return null;
    }

    public boolean isPasswordMatch(String email, String password) {
        User user = getUserByEmail(email);
        return user.getPassword().equals(password);
    }
}