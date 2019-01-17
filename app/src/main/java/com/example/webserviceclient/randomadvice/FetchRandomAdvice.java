package com.example.webserviceclient.randomadvice;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.webserviceclient.namedays.FetchTodaysNamedays;

import org.json.JSONObject;

public class FetchRandomAdvice extends AsyncTask<String, Void, String> {
    private static final String TAG = FetchTodaysNamedays.class.getSimpleName();
    private TextView randomadviceTextView;

    public FetchRandomAdvice(TextView randomadviceTextView){
        this.randomadviceTextView = randomadviceTextView;
    }

    @Override
    protected String doInBackground(String... strings) {
        return FetchRandomAdviceUtils.getRandomAdvice();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject data = jsonObject.getJSONObject("slip");
            String randomAdvice;

            randomAdvice = data.getString("advice");

            if(randomAdvice != null)
            {
                randomadviceTextView.setText(randomAdvice);
                return;
            }
            randomadviceTextView.setText("Failed to fetch random advice.");

        } catch (Exception e) {
            randomadviceTextView.setText("Failed to fetch random advice.");
            Log.e(TAG, "exception", e);
        }
    }
}
