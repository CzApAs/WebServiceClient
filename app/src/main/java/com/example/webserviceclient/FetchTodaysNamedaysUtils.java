package com.example.webserviceclient;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class FetchTodaysNamedaysUtils {
    private static final String TAG = FetchTodaysNamedaysUtils.class.getSimpleName();
    private static final String NAMEDAYS_BASE_URL = "https://api.abalin.net/get/today?";
    private static final String NAMEDAYS_COUNTRY = "country";

    private FetchTodaysNamedaysUtils() {
        throw new IllegalStateException("Utility class");
    }

    static String getTodaysNamedays() {
        Uri builtUri = Uri.parse(NAMEDAYS_BASE_URL).buildUpon()
                .appendQueryParameter(NAMEDAYS_COUNTRY, "pl")
                .build();

        URL requestURL = null;
        try {
            requestURL = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            Log.e(TAG, "exception", e);
            return null;
        }
        return JSONStringHandler.getJSONFromURLWithGET(requestURL);
    }
}
