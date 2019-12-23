package com.example.easystudy;

import java.util.Map;

public class Courses {


    private String name;
    private Map<String,String> tutorials;


    public Courses(){}

    public Courses(String name , Map<String,String> map){

        this.name = name;
        this.tutorials = map;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getTutorials() {
        return tutorials;
    }

    public void setTutorials(Map<String, String> tutorials) {
        this.tutorials = tutorials;
    }
}
