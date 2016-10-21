package com.example.bindings;

public class ErrorBinding {

    private String message;

    public ErrorBinding(){}

    public ErrorBinding(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
