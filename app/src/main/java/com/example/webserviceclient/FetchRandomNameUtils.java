package com.example.webserviceclient;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class FetchRandomNameUtils {
    private static final String TAG = FetchTodaysNamedaysUtils.class.getSimpleName();
    private static final String RANDOMNAME_BASE_URL = "https://uinames.com/api";

    private FetchRandomNameUtils() {
        throw new IllegalStateException("Utility class");
    }

    static String getRandomName() {
        Uri builtUri = Uri.parse(RANDOMNAME_BASE_URL).buildUpon()
                .build();

        URL requestURL = null;
        try {
            requestURL = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            Log.e(TAG, "exception", e);
            return null;
        }
        return URLJSONExtractor.getJSONFromURLWithGET(requestURL);
    }
}
