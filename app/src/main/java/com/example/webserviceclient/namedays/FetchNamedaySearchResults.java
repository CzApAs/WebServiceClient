package com.example.webserviceclient.namedays;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class FetchNamedaySearchResults extends AsyncTask<String, Void, String> {
    private static final String TAG = FetchNamedaySearchResults.class.getSimpleName();
    private TextView namedaySearchOutput;

    public FetchNamedaySearchResults(TextView namedaySearchOutput) {
        this.namedaySearchOutput = namedaySearchOutput;
    }

    @Override
    protected String doInBackground(String... strings) {
        return FetchNamedaySearchResultsUtils.getSearchedNamedays(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("results");
            StringBuilder builtString = new StringBuilder();

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject result = itemsArray.getJSONObject(i);
                String day = result.getString("day");
                String month = result.getString("month");

                if (i != 0) {
                    builtString.append(", ");
                }

                builtString.append(day);
                builtString.append("/");
                builtString.append(month);
            }
            String resultString = builtString.toString();
            if (resultString != "") {
                namedaySearchOutput.setText(resultString);
            } else {
                namedaySearchOutput.setText("No results found");
            }
        } catch (Exception e) {
            namedaySearchOutput.setText("No results found");
            Log.e(TAG, "exception", e);
        }
    }
}

