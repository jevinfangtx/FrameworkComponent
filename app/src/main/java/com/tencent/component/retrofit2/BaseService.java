package com.tencent.component.retrofit2;

import com.tencent.component.retrofit2.retrofitclient.ResultWrap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseService<Data> {

    public Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

    public void postReq(Param body) {
        Retrofit retrofit = getRetrofit();
        Class serviceClass = getRequestClass();
        Request request = retrofit.create(Request.class);
//        Call<>
//        call.enqueue(new Callback<ResultWrap>() {
//            @Override
//            public void onResponse(Call<ResultWrap> call, Response<ResultWrap> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResultWrap> call, Throwable t) {
//
//            }
//        });

    }

    protected abstract Class<? extends Request> getRequestClass();

    protected abstract void onFail(int result, String errMsg, Data data);
    protected abstract void onSuccess(Data data);

    public interface Param {

    }

    public interface Request {
        Call<ResultWrap> post(Param param);
    }
}
