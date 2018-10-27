package com.tencent.component.databinding;

import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.component.databinding.FragmentDatabindingObservableClassBinding;


public class ObservableClassFragment extends Fragment {
    User mUser = new User("jevin", "fang");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDatabindingObservableClassBinding binding = FragmentDatabindingObservableClassBinding.inflate(inflater, container, false);
        binding.setUser(mUser);
        binding.setHandlers(new MyHandlers());
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser.setFirstName("tian");
            }
        },3000);
        return binding.getRoot();
    }
}
