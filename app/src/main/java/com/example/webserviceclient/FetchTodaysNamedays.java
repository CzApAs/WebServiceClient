package com.example.webserviceclient;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

public class FetchTodaysNamedays extends AsyncTask<String, Void, String> {
    private static final String TAG = FetchTodaysNamedays.class.getSimpleName();
    private TextView namedaysTextView;

    public FetchTodaysNamedays(TextView namedaysTextView) {
        this.namedaysTextView = namedaysTextView;
    }

    @Override
    protected String doInBackground(String... strings) {
        return FetchTodaysNamedaysUtils.getTodaysNamedays();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject data = jsonObject.getJSONObject("data");
            String todaysNamedays;

            todaysNamedays = data.getString("name_pl");

            if(todaysNamedays != null)
            {
                namedaysTextView.setText(todaysNamedays);
                return;
            }
            namedaysTextView.setText("Failed to fetch today's namedays.");

        } catch (Exception e) {
            namedaysTextView.setText("Failed to fetch today's namedays.");
            Log.e(TAG, "exception", e);
        }
    }
}
