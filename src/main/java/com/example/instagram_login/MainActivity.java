package com.example.instagram_login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       mAuth = FirebaseAuth.getInstance();
       emailEditText = findViewById(R.id.emailEditText);
       passwordEditText= findViewById(R.id.passwordEditText);
        }
        public void signUp(View view)
        {
            String email=emailEditText.getText().toString();
            String password=passwordEditText.getText().toString();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        FirebaseUser user=mAuth.getCurrentUser();
                        Toast.makeText(MainActivity.this,"Sign Up Successful",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
    public void signIn(View view)
    {
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user=mAuth.getCurrentUser();
                    Toast.makeText(MainActivity.this,"Sign in Successful",Toast.LENGTH_SHORT).show();
            }
                else {
                    Toast.makeText(MainActivity.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                }
        }
    });
    }
}