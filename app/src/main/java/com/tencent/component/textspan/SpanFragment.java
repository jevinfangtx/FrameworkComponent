package com.tencent.component.textspan;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tencent.component.R;
import com.tencent.component.common.DensityUtils;

public class SpanFragment extends Fragment {

    private TextView mTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_span, container, false);
        mTextView = view.findViewById(R.id.textview);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ColorStateList colorStateList = new ColorStateList(new int[][]{{android.R.attr.state_selected}, {0}},
//                new int[]{Color.RED, Color.BLACK});
//        mTextView.setTextColor(colorStateList);
//        mTextView.setSelected(true);

        CharSequence text = mTextView.getText();

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(text);
        int start = text.length();
        builder.append(" ");
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher_round);
        MyImageSpan span = new MyImageSpan(drawable);
        drawable.setBounds(0, 0, DensityUtils.dip2px(getContext(), 16),
                DensityUtils.dip2px(getContext(), 12                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ));
        builder.setSpan(span, start, start+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView.setText(builder);

    }
}
