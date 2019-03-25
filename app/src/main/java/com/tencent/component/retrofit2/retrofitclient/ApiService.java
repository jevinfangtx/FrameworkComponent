package com.tencent.component.retrofit2.retrofitclient;

import com.tencent.component.retrofit2.TestService;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    //获取省列表
    @GET("common/areas")
    Flowable<ResultWrap<ResultDemo>> query();


    public static class Province {
        public String name;
    }
}
