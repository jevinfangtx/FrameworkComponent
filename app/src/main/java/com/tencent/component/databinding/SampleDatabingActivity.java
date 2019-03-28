package com.tencent.component.databinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.tencent.component.R;
import com.tencent.component.architecture.UserProfileFragment;
import com.tencent.component.retrofit2.RetrofitFragment;
import com.tencent.component.textspan.SpanFragment;
import com.wegame.canvasui.CanvasuiFragment;
//import com.tencent.component.kotlindev.UserFragment;

public class SampleDatabingActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databinding_sample);
//        ObservableClassFragment fragment = new ObservableClassFragment();

//        Fragment fragment = new AdapterFragment();

//        Fragment fragment = new UserProfileFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(UserProfileFragment.UID_KEY, "1");
//        fragment.setArguments(bundle);

//        Fragment fragment = new UserFragment();

//        Fragment fragment = new RetrofitFragment();

        Fragment fragment = new CanvasuiFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();
    }
}
