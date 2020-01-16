package com.example.easystudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminActivity extends AppCompatActivity {

    private EditText email_id , course_id;
    private TextView output_id;
    private Button check_id, back_id;
    private FirebaseDatabase mdatabase;
    private DatabaseReference mRef ;
    private String ans = "";
    private boolean isOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        email_id = (EditText)findViewById(R.id.email_admin);
        course_id = (EditText)findViewById(R.id.course_admin);
        check_id = (Button)findViewById(R.id.check_admin);
        back_id = (Button)findViewById(R.id.back_admin);
        output_id = (TextView)findViewById(R.id.admin_out);

        output_id.setVisibility(View.GONE);
        back_id.setVisibility(View.GONE);

        back_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_id.setVisibility(View.VISIBLE);
                course_id.setVisibility(View.VISIBLE);
                check_id.setVisibility(View.VISIBLE);
                back_id.setVisibility(View.GONE);
                output_id.setVisibility(View.GONE);
            }
        });

        check_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_ok(email_id.getText().toString().trim(), course_id.getText().toString().trim())) {
                    mdatabase = FirebaseDatabase.getInstance();
                    mRef = mdatabase.getReference("Users");
                    mRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                                if (childSnapshot.child("email").getValue().equals(email_id.getText().toString().trim())) {
                                    isOk = true;
                                    for(DataSnapshot child_data: childSnapshot.child("progress").getChildren()){
                                        if(child_data.getKey().equals(course_id.getText().toString().trim())){
                                            for(DataSnapshot child_answer: child_data.getChildren()) {
                                                ans += child_answer.getValue().toString();
                                                if(ans.equals(course_id.getText().toString().trim())){
                                                    ans = "";
                                                }
                                            }
                                            output_id.setText(ans);
                                            output_id.setVisibility(View.VISIBLE);
                                            email_id.setVisibility(View.GONE);
                                            course_id.setVisibility(View.GONE);
                                            check_id.setVisibility(View.GONE);
                                            back_id.setVisibility(View.VISIBLE);
                                            ans = "";
                                        }
                                        else{
                                            ans = "The current user is not registered to " + course_id.getText().toString().trim() + " course";
                                            output_id.setText(ans);
                                            output_id.setVisibility(View.VISIBLE);
                                            email_id.setVisibility(View.GONE);
                                            course_id.setVisibility(View.GONE);
                                            check_id.setVisibility(View.GONE);
                                            back_id.setVisibility(View.VISIBLE);
                                            ans = "";
                                        }
                                    }
                                }
                            }
                            if(isOk == false){
                                ans = "The current email is not valid";
                                output_id.setText(ans);
                                output_id.setVisibility(View.VISIBLE);
                                email_id.setVisibility(View.GONE);
                                course_id.setVisibility(View.GONE);
                                check_id.setVisibility(View.GONE);
                                back_id.setVisibility(View.VISIBLE);
                                ans = "";
                            }
                            isOk = false;
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }

    private boolean is_ok(String email, String pass){

        if(email.isEmpty() || pass.isEmpty())
            return false;
        else return true;

    }
}