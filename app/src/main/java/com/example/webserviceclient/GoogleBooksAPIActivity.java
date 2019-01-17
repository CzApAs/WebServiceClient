package com.example.webserviceclient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class GoogleBooksAPIActivity extends AppCompatActivity {
    private EditText bookInput;
    private TextView titleText;
    private TextView authorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_books_api);

        bookInput = (EditText) findViewById(R.id.bookInputEditText);
        titleText = (TextView) findViewById(R.id.titleText);
        authorText = (TextView) findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String queryString = bookInput.getText().toString();
        // hiding keyboard if the search button is pressed
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {
            authorText.setText("");
            titleText.setText(getString(R.string.loading));
            new FetchBook(titleText, authorText).execute(queryString);
        } else {
            if(queryString.length() == 0) {
                authorText.setText("");
                titleText.setText(getString(R.string.searchInputEmpty));
            } else {
                authorText.setText("");
                titleText.setText(R.string.networkError);
            }
        }
    }
}
