package com.example.webserviceclient;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class FetchRandomAdviceUtils {
    private static final String TAG = FetchTodaysNamedaysUtils.class.getSimpleName();
    private static final String RANDOMADVICE_BASE_URL = "https://api.adviceslip.com/advice";

    private FetchRandomAdviceUtils() {
        throw new IllegalStateException("Utility class");
    }

    static String getRandomAdvice() {
        Uri builtUri = Uri.parse(RANDOMADVICE_BASE_URL).buildUpon()
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
