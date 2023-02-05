package com.example.rebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button logoutButton = (Button) findViewById(R.id.logoutButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button applyEmail = (Button) findViewById(R.id.applyButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button applyPass = (Button) findViewById(R.id.applyButton2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button applyUser = (Button) findViewById(R.id.applyButton3);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText changeEmail = (EditText) findViewById(R.id.changeEmailText);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText changePassword = (EditText) findViewById(R.id.changePasswordText);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText changeUsername = (EditText) findViewById(R.id.changeUserName);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        applyEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEmail = changeEmail.getText().toString();

                if (newEmail.matches(emailPattern) && newEmail.length() > 0
                        && !RegisterActivity.isUserExist(newEmail)) {
                    HomeActivity.userDatabase.updateUser(HomeActivity.userLoggedIn.getEmail(),
                            newEmail, HomeActivity.userLoggedIn.getPassword(),
                            HomeActivity.userLoggedIn.getUsername());
                    Toast.makeText(getApplicationContext(),
                            "Email changed!", Toast.LENGTH_SHORT).show();
                    HomeActivity.loggedInUser.delete("LoggedIn", "Username=?", new String[]{HomeActivity.userLoggedIn.getEmail()});
                    ContentValues values = new ContentValues();
                    values.put("Username", newEmail);
                    HomeActivity.loggedInUser.insert("LoggedIn", null, values);
                    HomeActivity.userArrayList = new ArrayList<>();
                    HomeActivity.userArrayList = HomeActivity.userDatabase.fetchUsers();
                    HomeActivity.userLoggedIn = LoginActivity.getUserByEmail(newEmail);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "invalid email!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        applyPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = changePassword.getText().toString();

                if (newPass.length() > 0 && !newPass.equals(HomeActivity.userLoggedIn.getPassword())) {
                    HomeActivity.userDatabase.updatePass(HomeActivity.userLoggedIn.getPassword(),
                            HomeActivity.userLoggedIn.getEmail(), newPass,
                            HomeActivity.userLoggedIn.getUsername());
                    Toast.makeText(getApplicationContext(),
                            "Password changed!", Toast.LENGTH_SHORT).show();
                    HomeActivity.userArrayList = new ArrayList<>();
                    HomeActivity.userArrayList = HomeActivity.userDatabase.fetchUsers();
                    HomeActivity.userLoggedIn = LoginActivity.getUserByEmail(HomeActivity.userLoggedIn.getEmail());
                } else {
                    Toast.makeText(getApplicationContext(),
                            "invalid password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        applyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUser = changeUsername.getText().toString();
                if (newUser.length() > 0) {
                    HomeActivity.userDatabase.updateUser(HomeActivity.userLoggedIn.getEmail(),
                            HomeActivity.userLoggedIn.getEmail(), HomeActivity.userLoggedIn.getPassword(),

                            newUser);
                    Toast.makeText(getApplicationContext(),
                            "Username changed!", Toast.LENGTH_SHORT).show();
                    HomeActivity.userArrayList = new ArrayList<>();
                    HomeActivity.userArrayList = HomeActivity.userDatabase.fetchUsers();
                    HomeActivity.userLoggedIn = LoginActivity.getUserByEmail(HomeActivity.userLoggedIn.getEmail());
                } else {
                    Toast.makeText(getApplicationContext(),
                            "invalid username!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor resultSet = HomeActivity.loggedInUser.rawQuery("Select * from LoggedIn", null);
                resultSet.moveToFirst();
                String email = resultSet.getString(0);
                HomeActivity.loggedInUser.delete("LoggedIn", "Username=?", new String[]{email});
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}