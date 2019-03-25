package com.tencent.component.databinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.component.databinding.FragmentGenerateBindingBinding;

public class GenerateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        FragmentGenerateBindingBinding binding = FragmentGenerateBindingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
