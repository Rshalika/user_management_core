package com.example.bindings;


import com.example.models.User;

public class ResponseBinding {

    private User user;
    private boolean success;
    private String message;

    public  ResponseBinding(){}

    public ResponseBinding(User user, boolean success, String message) {
        this.user = user;
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String isMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
