package com.example.webserviceclient.namedays;

import android.net.Uri;
import android.util.Log;

import com.example.webserviceclient.URLJSONExtractor;

import java.net.MalformedURLException;
import java.net.URL;

public class FetchNamedaySearchResultsUtils {
    private static final String TAG = FetchNamedaySearchResultsUtils.class.getSimpleName();
    private static final String NAMEDAYS_BASE_URL = "https://api.abalin.net/get/getdate?";
    private static final String NAMEDAYS_NAME = "name";
    private static final String NAMEDAYS_CALENDAR = "calendar";

    private FetchNamedaySearchResultsUtils() {
        throw new IllegalStateException("Utility class");
    }

    static String getSearchedNamedays(String queryString) {
        Uri builtUri = Uri.parse(NAMEDAYS_BASE_URL).buildUpon()
                .appendQueryParameter(NAMEDAYS_NAME, queryString)
                .appendQueryParameter(NAMEDAYS_CALENDAR, "pl")
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


