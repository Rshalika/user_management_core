package com.example.models;


public class User {

    private String username;
    private String password;

    private boolean isAdmin;

    private boolean passwordSet;

    public User(String username, String password, boolean isAdmin, boolean passwordSet) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.passwordSet = passwordSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isPasswordSet() {
        return passwordSet;
    }

    public void setPasswordSet(boolean passwordSet) {
        this.passwordSet = passwordSet;
    }
}
