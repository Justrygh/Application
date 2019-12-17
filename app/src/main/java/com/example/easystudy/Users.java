package com.example.easystudy;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private   String Email , Password ;
    private Map<String,String> progress;

    public Users(){}

    public Users (String E, String P){
        this.Email=E;
        this.Password=P;
        this.progress = new HashMap<String, String>();
        progress.put("cpp","0");
        progress.put("python","0");

    }
//    public Users(Users u){
//        this.Email=u.Email;
//        this.Password=u.Password;
//        this.progress = u.progress;
//
//    }
    public Users(String E, String P,HashMap<String,String> hm){
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

    public Map<String, String> getProgress() {
        return progress;
    }

}
