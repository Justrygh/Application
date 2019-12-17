package com.example.easystudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cpp_Activity extends AppCompatActivity {

    private TextView vars,strings,if_else;
    private CheckBox vars_checkBox,strings_checkBox,if_else_checkBox;
    private FirebaseHelper fh = new FirebaseHelper();
    private String helper = "";
    private boolean exists = false;

    private Users usr;
    private FirebaseUser userDemo;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp_);
        auth = FirebaseAuth.getInstance();
        userDemo = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
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

                Log.d("cpp ","     "+fh.user+" email  "+ fh.user.getEmail());


        vars = (TextView)findViewById(R.id.cpp_var);
        strings = (TextView)findViewById(R.id.cpp_string);
        if_else = (TextView)findViewById(R.id.cpp_if_else);

        vars_checkBox = (CheckBox)findViewById(R.id.vars_checkBox);
        strings_checkBox = (CheckBox)findViewById(R.id.string_checkBox);
        if_else_checkBox = (CheckBox)findViewById(R.id.if_else_checkBox);
        Log.d("cpp ","  --------   "+fh.user.getEmail()+" email  ");

//       try{ Thread.sleep(2000);}catch (Exception e){}
//        helper = fh.user.getProgress().get("cpp");
        vars_checkBox.setEnabled(false);
        strings_checkBox.setEnabled(false);
        if_else_checkBox.setEnabled(false);
        helper = fh.user.getProgress().get("cpp");
        Log.d("helper  ","" + helper);
//        for(int i=0; i<helper.length(); i++){
//            if(helper.charAt(i) == '1') {
//                vars_checkBox.setSelected(true);
//                vars_checkBox.setEnabled(false);
//            }
//            }

        vars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.w3schools.com/cpp/cpp_variables.asp"));
                startActivity(viewIntent);
//                for(int i=0; i<helper.length(); i++){
//                    if(helper.charAt(i) == '1'){
//                        exists = true;
//                        vars_checkBox.setSelected(true);
//                    }
//                }
//                if (exists == false) {
//                    vars_checkBox.setEnabled(true);
//                }

            }
        });

        vars_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/////////////TODO
                helper += '1';
                vars_checkBox.setEnabled(false);
                Log.d("var check ", " prog = "+ fh.user.getProgress().get("cpp"));
                fh.user.getProgress().put("cpp",""+helper);
                fh.userUpdatemap(FirebaseAuth.getInstance().getUid(),fh.user);

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

    });
}

    public void update_Ui(){
        for(int i=0; i<helper.length(); i++){
            if(helper.charAt(i) == '1')
                vars_checkBox.setSelected(true);
        }
    }
}
