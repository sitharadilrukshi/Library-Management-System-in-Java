package com.java.librarymanagementsystem;

import java.io.Serializable;

public class User implements Serializable {
    private String user_name;

    public User(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
