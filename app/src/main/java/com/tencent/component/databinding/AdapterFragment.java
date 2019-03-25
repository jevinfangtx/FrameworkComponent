package com.tencent.component.databinding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tencent.component.R;
import com.tencent.component.databinding.FragmentAdapterBinding;

import javax.annotation.Nullable;

public class AdapterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentAdapterBinding binding = FragmentAdapterBinding.inflate(inflater, container, false);
        binding.setImg(new Img());
        return binding.getRoot();
//        View view = inflater.inflate(R.layout.fragment_adapter2, container, false);
//        return view;
    }

//    @Override
//    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
//        View rootView = getView();
//        ImageView imageView = rootView.findViewById(R.id.image_view);
//        Img img = new Img();
//        Glide.with(this).load(img.url).into(imageView);
//    }
}
