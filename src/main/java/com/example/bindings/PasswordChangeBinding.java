package com.example.bindings;

public class PasswordChangeBinding {
    private String username;
    private String old;
    private String newPass;
    private String confirm;

    public PasswordChangeBinding(){}

    public PasswordChangeBinding(String username, String old, String newPass, String confirm) {
        this.username = username;
        this.old = old;
        this.newPass = newPass;
        this.confirm = confirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
