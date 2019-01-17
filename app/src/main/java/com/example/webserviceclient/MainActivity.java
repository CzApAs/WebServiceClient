package com.example.webserviceclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.webserviceclient.books.GoogleBooksAPIActivity;
import com.example.webserviceclient.namedays.NameDaysAPIActivity;
import com.example.webserviceclient.randomadvice.RandomAdviceAPIActivity;
import com.example.webserviceclient.randomnames.RandomNameAPIActivity;

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

    public void openRandomAdviceAPIActivity(View view) {
        Intent intent = new Intent(this, RandomAdviceAPIActivity.class);
        startActivity(intent);
    }

    public void openRandomNameAPIActivity(View view) {
        Intent intent = new Intent(this, RandomNameAPIActivity.class);
        startActivity(intent);
    }

}
