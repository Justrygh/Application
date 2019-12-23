package com.example.easystudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.snapshot.IndexedNode;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {


    private ImageView cpp;
    private FirebaseHelper fh = new FirebaseHelper();
    private Users user;
    private FirebaseDatabase mdatabase;
    private DatabaseReference mRef ;
    private FirebaseUser userDemo;
    private FirebaseAuth auth;
    private boolean check_me = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Courses");
        userDemo = FirebaseAuth.getInstance().getCurrentUser();

        cpp = (ImageView)findViewById(R.id.cpp_B);
        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fh.readCourses("cpp", new FirebaseHelper.OnGetDataListener() {
                    @Override
                    public void onSuccess(Users usr) { }

                    @Override
                    public void onSuccess(final Courses c) {
                        Log.d("courses read", "  course = " + c.getName() + " tutorials = " +c.getTutorials());

                        fh.readUser(new FirebaseHelper.OnGetDataListener() {
                            @Override
                            public void onSuccess(Users usr) {
                               HashMap<String,Courses> hm = new HashMap<>();
                                hm.put("cpp",c);
                                if(usr.getProgress() == null){ usr.setProgress(hm);}
                                if(usr.getProgress() != null && !usr.getProgress().containsKey("cpp")){
                                    usr.getProgress().put("cpp",c);


                                }
                                fh.userUpdatemap(userDemo.getUid(),usr);
                                if(check_me == false) {
                                    startActivity(new Intent(HomeActivity.this, cpp_Activity.class));
                                    check_me = true;
                                }

                            }

                            @Override
                            public void onSuccess(Courses c) {

                            }

                        });
                    check_me = false;
                    }

                });





            }
        });



    }



}