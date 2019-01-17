package com.example.webserviceclient;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLJSONExtractor {
    private static final String TAG = FetchTodaysNamedaysUtils.class.getSimpleName();

    private URLJSONExtractor() {
        throw new IllegalStateException("Utility class");
    }

    public static String getJSONFromURLWithGET(URL requestURL){

        HttpURLConnection urlConnection;
        BufferedReader reader;
        String resultString;

        try {
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0) {
                return null;
            }
            resultString = buffer.toString();

            urlConnection.disconnect();
            reader.close();

            return resultString;
        }
        catch(Exception e)
        {
            Log.e(TAG, "exception", e);
            return null;
        }
    }
}
