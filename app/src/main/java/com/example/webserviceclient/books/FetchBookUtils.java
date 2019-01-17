package com.example.webserviceclient.books;

import android.net.Uri;
import android.util.Log;

import com.example.webserviceclient.URLJSONExtractor;

import java.net.MalformedURLException;
import java.net.URL;

public class FetchBookUtils {
    private static final String TAG = FetchBookUtils.class.getSimpleName();
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    private static final String QUERY_PARAM = "q";
    private static final String MAX_RESULTS = "maxResults";
    private static final String PRINT_TYPE = "printType";

    private FetchBookUtils() {
        throw new IllegalStateException("Utility class");
    }

    static String getBookInfo(String queryString) {
        Uri builtUri = Uri.parse(BOOK_BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, queryString)
                .appendQueryParameter(MAX_RESULTS, "10")
                .appendQueryParameter(PRINT_TYPE, "books")
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
