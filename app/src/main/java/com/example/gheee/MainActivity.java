package com.example.gheee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        SystemClock.sleep(10000);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser=firebaseAuth.getCurrentUser();
        if (currentuser==null){
            Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(registerIntent);
            finish();
        }else {
            Intent mainIntent = new Intent(MainActivity.this,StartActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }
}


