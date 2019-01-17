package com.example.webserviceclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openGoogleBooksAPIActivity(View view) {
        Intent intent = new Intent(this, GoogleBooksAPIActivity.class);
        startActivity(intent);
    }

    public void openNameDaysAPIActivity(View view) {
        Intent intent = new Intent(this, NameDaysAPIActivity.class);
        startActivity(intent);
    }
}
