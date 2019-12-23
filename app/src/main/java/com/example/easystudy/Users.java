package com.example.easystudy;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private   String Email , Password ;
    private Map<String,Courses> progress;

    public Users(){}

    public Users (String E, String P){
        this.Email=E;
        this.Password=P;
//        this.progress = new HashMap<String, Courses>();
//        progress.put("cpp","0");
//        progress.put("python","0");

    }
    //    public Users(Users u){
//        this.Email=u.Email;
//        this.Password=u.Password;
//        this.progress = u.progress;
//
//    }
    public Users(String E, String P,HashMap<String,Courses> hm){
        this.Email=E;
        this.Password=P;
        this.progress = hm;


    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
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