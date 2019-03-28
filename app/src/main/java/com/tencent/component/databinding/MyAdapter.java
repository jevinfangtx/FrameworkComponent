package com.tencent.component.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MyAdapter {

    @BindingAdapter("src")
    public static void setSrc(ImageView imageView, int resId) {
        imageView.setImageResource(resId);
    }

    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view).load(url).into(view);
    }
}
