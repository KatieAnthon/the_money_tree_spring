package com.makers.moneytree.model;

public class UserObj {
    public String UserID = "";
    public int timer = 0;
    public String name = "";

    public String email = "";
    public String password = "";

    public UserObj() {

    }
    public String getUserID() {
        return UserID;
    }
    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
