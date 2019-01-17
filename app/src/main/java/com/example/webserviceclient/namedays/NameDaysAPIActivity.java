package com.example.webserviceclient.namedays;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.webserviceclient.R;

public class NameDaysAPIActivity extends AppCompatActivity {
    private TextView getNamedaysResultTextView;
    private EditText searchNamedaysEditText;
    private TextView searchNamedaysResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_days_api);

        getNamedaysResultTextView = (TextView) findViewById(R.id.todaysNamedaysOutput);
        searchNamedaysEditText = (EditText) findViewById(R.id.namedaySearchInputText);
        searchNamedaysResultTextView = (TextView) findViewById(R.id.namedaySearchOutput);
    }


    public void getNamedays(View view)
    {

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected())
        {
            getNamedaysResultTextView.setText(R.string.loading);
            new FetchTodaysNamedays(getNamedaysResultTextView).execute();
        }
        else
        {
            getNamedaysResultTextView.setText(R.string.networkError);
        }
    }

    public void searchNamedays(View view)
    {
        String queryString = searchNamedaysEditText.getText().toString();
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected())
        {
            searchNamedaysResultTextView.setText(R.string.loading);
            new FetchNamedaySearchResults(searchNamedaysResultTextView).execute(queryString);
        }
        else
        {
            searchNamedaysResultTextView.setText(R.string.networkError);
        }
    }
}
