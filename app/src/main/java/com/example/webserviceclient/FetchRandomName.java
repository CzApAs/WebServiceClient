package com.example.webserviceclient;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

public class FetchRandomName extends AsyncTask<String, Void, String> {
    private static final String TAG = FetchTodaysNamedays.class.getSimpleName();
    private TextView randomNameTextView;

    public FetchRandomName(TextView randomNameTextView){
        this.randomNameTextView = randomNameTextView;
    }

    @Override
    protected String doInBackground(String... strings) {
        return FetchRandomNameUtils.getRandomName();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            String name = jsonObject.getString("name");
            String surname = jsonObject.getString("surname");
            String result = name + " " + surname;


            if(result.length() != 0)
            {
                randomNameTextView.setText(result);
                return;
            }
            randomNameTextView.setText("Failed to fetch random name.");

        } catch (Exception e) {
            randomNameTextView.setText("Failed to fetch random name.");
            Log.e(TAG, "exception", e);
        }
    }
}
