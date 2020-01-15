package com.example.easystudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminActivity extends AppCompatActivity {

    private EditText email_id , course_id;
    private Button check_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        email_id = (EditText)findViewById(R.id.email_admin);
        course_id = (EditText)findViewById(R.id.course_admin);
        check_id = (Button)findViewById(R.id.check_admin);

        check_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_ok(email_id.getText().toString().trim(), course_id.getText().toString().trim())) {

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