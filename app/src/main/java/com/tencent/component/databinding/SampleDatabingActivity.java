package com.tencent.component.databinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.tencent.component.R;

public class SampleDatabingActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databinding_sample);
//        ObservableClassFragment fragment = new ObservableClassFragment();
//        GenerateFragment fragment = new GenerateFragment();
//        CoordinatorFragment fragment = new CoordinatorFragment();
        Fragment fragment = new RecyclerFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();
    }
}
