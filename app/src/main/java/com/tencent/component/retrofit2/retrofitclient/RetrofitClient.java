package com.tencent.component.retrofit2.retrofitclient;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // https://blog.csdn.net/zl_china/article/details/79467558
    // https://blog.csdn.net/zl_china/article/details/78529105

    public static final long CONNECTTIME = 30000;

    public static final String BASE_URL = "http://jxhdapi.ooowin.com/";

    private Retrofit mRetrofit;

    public RetrofitClient() {
        //添加日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("TAG", "==========" + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);

        //获取OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECTTIME, TimeUnit.MICROSECONDS)
                .readTimeout(CONNECTTIME,TimeUnit.MICROSECONDS)
                .writeTimeout(CONNECTTIME,TimeUnit.MICROSECONDS)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new HttpHeaderInterceptor())
                .build();

        //初始化Retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    public <T> T getService(Class<T> service) {
        return mRetrofit.create(service);
    }



    //  创建单例
    private static class SingletonHolder {
        private static final RetrofitClient INSTANCE = new RetrofitClient();
    }


    public static class HttpHeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            Request build = request.newBuilder()
//                .addHeader("","")   添加header
                    .build();
            return chain.proceed(build);
        }
    }
}
