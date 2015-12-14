package com.org.example.http.request;

import android.text.TextUtils;

import com.org.example.http.OkHttpManager;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by gzhenk on 15-12-14.
 */
public class GetRequest extends BaseRequest {

    /**
     * 设置设置url
     *
     * @param url 　url
     * @return getRequest
     */
    public GetRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * 异步请求
     *
     * @param callback callback
     * @return call
     */
    @Override
    public Call enqueue(Callback callback) {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url can not be null !");
        }

        Request.Builder builder = new Request.Builder().url(url);

        Request request = builder.build();

        Call call = OkHttpManager.getOkHttpClient().newCall(request);
        call.enqueue(callback);
        return call;
    }


    /**
     * 同步请求
     *
     * @throws IOException
     * @return　response
     */
    @Override
    public Response execute() throws IOException {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url can not be null !");
        }

        Request.Builder builder = new Request.Builder().url(url);


        Request request = builder.build();
        Call call = OkHttpManager.getOkHttpClient().newCall(request);
        Response response = call.execute();
        return null;
    }
}
