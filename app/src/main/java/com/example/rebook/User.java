package com.example.rebook;


public class User {


    private String password;
    private String email;
    private String book;
    private String username;
    public static User loggedInUser = null;


    public User(String email, String book,String password, String username){
        this.email = email;
        this.password = password;
        this.book = book;

        this.username= username;

    }

    public String getEmail() {
        return email;
    }

    public String getBook() {
        return book;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}

