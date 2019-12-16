package com.example.easystudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class cpp_Activity extends AppCompatActivity {

    private TextView vars,strings,if_else;
    private CheckBox vars_checkBox,strings_checkBox,if_else_checkBox;
   // protected FirebaseUser c_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp_);

        vars = (TextView)findViewById(R.id.cpp_var);
        strings = (TextView)findViewById(R.id.cpp_string);
        if_else = (TextView)findViewById(R.id.cpp_if_else);

        vars_checkBox = (CheckBox)findViewById(R.id.vars_checkBox);
        strings_checkBox = (CheckBox)findViewById(R.id.string_checkBox);
        if_else_checkBox = (CheckBox)findViewById(R.id.if_else_checkBox);

        vars_checkBox.setEnabled(false);
        strings_checkBox.setEnabled(false);
        if_else_checkBox.setEnabled(false);



        vars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.w3schools.com/cpp/cpp_variables.asp"));
                startActivity(viewIntent);

                vars_checkBox.setEnabled(true);

            }
        });

        vars_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vars_checkBox.setEnabled(false);
            }
        });

        strings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewIntent =new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.w3schools.com/cpp/cpp_strings.asp"));
                startActivity(viewIntent);
                strings_checkBox.setEnabled(true);

            }
        });
        strings_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strings_checkBox.setEnabled(false);

            }
        });

        if_else.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewIntent =new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.w3schools.com/cpp/cpp_conditions.asp"));
                startActivity(viewIntent);
                if_else_checkBox.setEnabled(true);


            }
        });
        if_else_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if_else_checkBox.setEnabled(false);
            }
        });


    }
}
