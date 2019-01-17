package com.example.webserviceclient.randomadvice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.webserviceclient.R;

public class RandomAdviceAPIActivity extends AppCompatActivity {

    private TextView randomadviceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_advice_api);

        randomadviceTextView = findViewById(R.id.randomadviceTextView);
    }

    public void getRandomAdvice(View view)
    {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected())
        {
            randomadviceTextView.setText(R.string.loading);
            new FetchRandomAdvice(randomadviceTextView).execute();
        }
        else
        {
            randomadviceTextView.setText(getString(R.string.networkError));
        }
    }
}
