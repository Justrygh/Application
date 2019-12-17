package com.example.easystudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private   String Email , Password ;
    private Map<String, Boolean> progress;

    public Users (String E, String P){
        this.Email=E;
        this.Password=P;
        this.progress = new HashMap<>();
    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public Map<String, Boolean> getProgress() {
        return progress;
    }

}
