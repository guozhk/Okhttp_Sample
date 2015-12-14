package com.org.example.http;

import com.org.example.http.request.GetRequest;
import com.org.example.http.request.PostRequest;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by gzhenk on 15-12-14.
 */
public class OkHttpManager {

    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (OkHttpManager.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient();
                }
            }
        }

        return mOkHttpClient;
    }


    public static GetRequest get() {
        return new GetRequest();
    }

    public static PostRequest post() {
        return new PostRequest();
    }
}
