package com.example.easystudy;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseHelper {

    private FirebaseDatabase mdatabase;
    private DatabaseReference mRef ;
    protected Users user ;
    protected Courses course;



    public void addUser(Users user){ // adding a user to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users");
        mRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
        Log.d("debug form addUser: ", "createUserWithEmail:success "+FirebaseAuth.getInstance().getCurrentUser().getUid());

    }



    public void readUser(final OnGetDataListener getdata){


        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users");
        mRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                user = dataSnapshot.child(FirebaseAuth.getInstance().getUid()).getValue(Users.class);
                Log.d("reading "," email ------ "+user.getEmail());


//                hm = new HashMap<>();
//
//                for (DataSnapshot childSnapshot: dataSnapshot.child(FirebaseAuth.getInstance().getUid()+"/progress").getChildren()) {
//                    hm.put(childSnapshot.getKey(), childSnapshot.getValue().toString());
//                }

//                u_email = dataSnapshot.child(FirebaseAuth.getInstance().getUid()).child("email").getValue(String.class);
//                u_pass = dataSnapshot.child(FirebaseAuth.getInstance().getUid()).child("password").getValue(String.class);
//                user = new Users(u_email,u_pass,hm);
                getdata.onSuccess(user);
                //user_var_update(u_email,u_pass,hm)
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }





    public interface OnGetDataListener {
        //this is for callbacks
        void onSuccess(Users usr);
        void onSuccess(Courses c);

    }

    public void userUpdatemap(String key,Users user){
        mRef.child(key).setValue(user);
    }

    public void readCourses(final String c_name , final OnGetDataListener getdata){

        mRef = FirebaseDatabase.getInstance().getReference("Courses");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                course = dataSnapshot.child(c_name).getValue(Courses.class);
                getdata.onSuccess(course);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }


}