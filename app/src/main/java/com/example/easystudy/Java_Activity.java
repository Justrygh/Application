
package com.example.easystudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Java_Activity extends AppCompatActivity {

    private TextView vars,strings,if_else;
    private CheckBox vars_checkBox,strings_checkBox,if_else_checkBox;
    private FirebaseHelper fh = new FirebaseHelper();
    private Map<String,String> helper = new HashMap<>();
    private boolean existsVar = false;
    private boolean existsStr = false;
    private boolean existsElse = false;

    private Users usr;
    private FirebaseUser userDemo;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_);
        auth = FirebaseAuth.getInstance();
        userDemo = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();

        vars = (TextView)findViewById(R.id.csh_var);
        strings = (TextView)findViewById(R.id.csh_string);
        if_else = (TextView)findViewById(R.id.csh_if_else);

        vars_checkBox = (CheckBox)findViewById(R.id.vars_checkBox);
        strings_checkBox = (CheckBox)findViewById(R.id.string_checkBox);
        if_else_checkBox = (CheckBox)findViewById(R.id.if_else_checkBox);
        //Log.d("cpp ","  --------   "+fh.user.getEmail()+" email  ");

        vars_checkBox.setEnabled(false);
        strings_checkBox.setEnabled(false);
        if_else_checkBox.setEnabled(false);
      /*
        myRef = database.getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usr = dataSnapshot.child(userDemo.getUid()).getValue(Users.class);
                Log.d("msgggggggg","   "+usr.getEmail());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        */
        fh.readUser(new FirebaseHelper.OnGetDataListener() {
            @Override
            public void onSuccess(Users usr) {

//                Log.d("cpp ","     "+fh.user+" email  "+ fh.user.getEmail());


//                vars = (TextView)findViewById(R.id.cpp_var);
//                strings = (TextView)findViewById(R.id.cpp_string);
//                if_else = (TextView)findViewById(R.id.cpp_if_else);
//
//                vars_checkBox = (CheckBox)findViewById(R.id.vars_checkBox);
//                strings_checkBox = (CheckBox)findViewById(R.id.string_checkBox);
//                if_else_checkBox = (CheckBox)findViewById(R.id.if_else_checkBox);
//                //Log.d("cpp ","  --------   "+fh.user.getEmail()+" email  ");
//
//                helper = fh.user.getProgress().get("cpp");
//
//                vars_checkBox.setEnabled(false);
//                strings_checkBox.setEnabled(false);
//                if_else_checkBox.setEnabled(false);
//                helper = fh.user.getProgress().get("cpp");

                helper = fh.user.getProgress().get("java").getTutorials();

                if(helper.get("variables").equals("1")) {
                    existsVar = true;
                }
                if(helper.get("strings").equals("1")){
                    existsStr = true;
                }
                if(helper.get("if_else").equals("1")){
                    existsElse = true;
                }
                if(existsVar == true){
                    //vars_checkBox.setVisibility(View.INVISIBLE);
                    vars_checkBox.setChecked(true);
                    vars_checkBox.setEnabled(false);
                }
                if(existsStr == true){
                    strings_checkBox.setChecked(true);
                    strings_checkBox.setEnabled(false);
                }
                if(existsElse == true){
                    if_else_checkBox.setChecked(true);
                    if_else_checkBox.setEnabled(false);
                }

                vars.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent viewIntent =
                                new Intent("android.intent.action.VIEW",
                                        Uri.parse("https://www.w3schools.com/java/java_variables.asp"));
                        startActivity(viewIntent);
                        if (existsVar == false) {
                            vars_checkBox.setEnabled(true);
                        }

                    }
                });

                vars_checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {/////////////TODO
                        helper.put("variables","1");
                        vars_checkBox.setEnabled(false);
                        // Log.d("var check ", " prog = "+ fh.user.getProgress().get("cpp"));
                        fh.user.getProgress().get("java").setTutorials(helper);
                        fh.userUpdatemap(FirebaseAuth.getInstance().getUid(),fh.user);

                    }
                });

                strings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent viewIntent =new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.w3schools.com/java/java_strings.asp"));
                        startActivity(viewIntent);
                        if (existsStr == false) {
                            strings_checkBox.setEnabled(true);
                        }

                    }
                });
                strings_checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        helper.put("strings","1");
                        vars_checkBox.setEnabled(false);
                        //   Log.d("var check ", " prog = "+ fh.user.getProgress().get("cpp"));
                        fh.user.getProgress().get("java").setTutorials(helper);
                        fh.userUpdatemap(FirebaseAuth.getInstance().getUid(),fh.user);

                    }
                });

                if_else.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent viewIntent =new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.w3schools.com/java/java_conditions.asp"));
                        startActivity(viewIntent);
                        if (existsElse == false) {
                            if_else_checkBox.setEnabled(true);
                        }


                    }
                });
                if_else_checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        helper.put("if_else","1");
                        vars_checkBox.setEnabled(false);
                        //Log.d("var check ", " prog = "+ fh.user.getProgress().get("cpp"));
                        fh.user.getProgress().get("java").setTutorials(helper);
                        fh.userUpdatemap(FirebaseAuth.getInstance().getUid(),fh.user);
                    }
                });


            }
            public void onSuccess(Courses c) { }


        });
    }


}