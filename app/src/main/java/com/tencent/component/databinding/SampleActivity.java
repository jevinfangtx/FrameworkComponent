package com.tencent.component.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tencent.component.R;
import com.tencent.component.databinding.ActivityDatabingBinding;

public class SampleActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databing);
//        ActivityDatabingBinding binding = ActivityDatabingBinding.inflate(getLayoutInflater());
        User user = new User("Test", "User");
        binding.setUser(user);
    }
}
