package com.example.easystudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {


    private EditText email_id , passwd_id;
    private Button login_ ,signup_;
    private FirebaseAuth mAuth;
    protected Users studentUsers = new Users(null,null);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
//        if(mAuth.getCurrentUser()!= null){
//            startActivity(new Intent(MainActivity.this,HomeActivity.class));
//            finish();
//        }
//        if(mAuth.getCurrentUser()!= null){
//            mAuth.signOut();
//        }

        email_id = (EditText)findViewById(R.id._email);
        passwd_id = (EditText)findViewById(R.id._passwd);
        login_ = (Button) findViewById(R.id._login);
        signup_ = (Button) findViewById(R.id._register);

        signup_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_ok(email_id.getText().toString().trim(),passwd_id.getText().toString().trim()))
                    register_fun(email_id.getText().toString().trim(),passwd_id.getText().toString().trim());
            }
        });

        login_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_ok(email_id.getText().toString().trim(),passwd_id.getText().toString().trim()))

                    login_fun(email_id.getText().toString().trim(),passwd_id.getText().toString().trim());
            }
        });
    }

    private void login_fun(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Log.d("msg :", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("msg :", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }


    private void register_fun(final String email, final String pass) {


        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            studentUsers = new Users(email,pass);


                            Log.d("msg :", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            new FirebaseHelper().addUser(studentUsers);
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("msg :", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {

        if(user != null){

            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            // new FirebaseHelper().readUser();
            // studentUsers
            //    user = FirebaseAuth.getInstance().getCurrentUser();
        }


    }



    private boolean is_ok(String email, String pass){

        if(email.isEmpty() || pass.isEmpty())
            return false;
        else return true;

    }
}