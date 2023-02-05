package com.example.rebook;


import java.util.ArrayList;

public class User {


    private String password;
    private String email;
    private String username;
    public static User loggedInUser = null;


    public User(String email,String password, String username){
        this.email = email;
        this.password = password;

        this.username= username;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}

