package com.tencent.component.retrofit2;

import com.tencent.component.retrofit2.retrofitclient.ResultWrap;

import retrofit2.Call;
import retrofit2.http.POST;

public class TestService extends BaseService<TestService.Result> {

    public static class TestParam implements BaseService.Param {
        public int userId;
    }

    public static class Result {
        public int result;
        public int data;
    }

    @Override
    protected Class getRequestClass() {
        return RequestTest.class;
    }

    @Override
    protected void onFail(int result, String errMsg, TestService.Result data) {

    }

    @Override
    protected void onSuccess(TestService.Result data) {

    }

    public interface RequestTest {
        @POST("translate")
        Call<ResultWrap> post(Param body);
    }
}
