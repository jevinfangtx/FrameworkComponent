package com.tencent.component.retrofit2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tencent.component.R;

public class RetrofitFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retrofit, container, false);
        TestService service = new TestService();
        TestService.TestParam param = new TestService.TestParam();
        param.userId = 1;
        service.postReq(param);
        return view;
    }
}
