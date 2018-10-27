package com.tencent.component.databinding;

import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.component.databinding.FragmentDatabindingSampleBinding;

public class SampleDatabingFragment extends Fragment {
    ObservableArrayMap<String, Object> mUser = new ObservableArrayMap<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDatabindingSampleBinding binding = FragmentDatabindingSampleBinding.inflate(inflater, container, false);

        mUser.put("firstName", "Google");
        mUser.put("lastName", "Inc.");
        mUser.put("age", 17);
        binding.setUser(mUser);
        binding.setHandlers(new MyHandlers());
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser.put("age", 100);
            }
        },3000);
        return binding.getRoot();
    }
}
