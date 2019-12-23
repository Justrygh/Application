package com.example.easystudy;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private   String Email , Password , Admin;
    private Map<String,Courses> progress;

    public Users(){}

    public Users (String E, String P){
        this.Email=E;
        this.Password=P;
        this.Admin = "0";

    }

    public Users(String E, String P,HashMap<String,Courses> hm){
        this.Email=E;
        this.Password=P;
        this.progress = hm;
        this.Admin = "0";


    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setAdmin(String admin) {
        Admin = admin;
    }

    public String getAdmin() {
        return Admin;
    }

    public Map<String, Courses> getProgress() {
        return progress;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setProgress(Map<String, Courses> progress) {
        this.progress = progress;
    }


}