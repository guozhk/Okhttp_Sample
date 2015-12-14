package com.org.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.org.example.http.OkHttpManager;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String url = "http://www.txmp.com.cn/index.php/openapi/cellphone/api?method=homepage.banner.getbannerlist&picSize=cs&nPage=1&pagelimit=6&&api_version=1.0&sign";
    String URL_USER = "https://raw.githubusercontent.com/ZhaoKaiQiang/OkHttpPlus/master/server/user";
    private Button getBtn;
    private Button postBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        getBtn = (Button) findViewById(R.id.btnget);
        postBtn = (Button) findViewById(R.id.btnpost);

        getBtn.setOnClickListener(this);
        postBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnget:
                getTest();
                break;
            case R.id.btnpost:
                postTest();
                break;
            default:
                break;
        }
    }


    private void getTest() {
        OkHttpManager.get().setUrl(URL_USER).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                Log.e(TAG,"e  request:"+request);
                Log.e(TAG,"e:"+e);
            }

            @Override
            public void onResponse(Response response) throws IOException {

                Log.e(TAG,"e  response:"+response);
                String body= response.body().string();
                Log.e(TAG,"e  body:"+body);
            }
        });
    }
    private void postTest() {
        OkHttpManager.get().setUrl(url).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                Log.e(TAG,"e  request:"+request);
                Log.e(TAG,"e:"+e);
            }

            @Override
            public void onResponse(Response response) throws IOException {

                Log.e(TAG,"e  response:"+response);

                String body= response.body().string();
                Log.e(TAG,"e  body:"+body);
            }
        });
    }
}




