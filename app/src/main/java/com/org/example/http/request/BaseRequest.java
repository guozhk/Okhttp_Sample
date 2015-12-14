package com.org.example.http.request;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

/**
 * Created by gzhenk on 15-12-14.
 */
public abstract class BaseRequest {

    protected String url;

    protected Map<String, String> params;

    protected Object tag;


    protected void addHeaders(Request.Builder builder, Map<String, String> headers) {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;
        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }

        builder.headers(headerBuilder.build());
    }


    protected String appendParams(String url, Map<String, String> params) {
        StringBuffer sb = new StringBuffer();
        sb.append(url + "?");

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
        }

        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    protected void appendParams(FormEncodingBuilder builder, Map<String, String> params) {

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
    }

    abstract Call enqueue(Callback callback);

    abstract Response execute() throws IOException;


}
