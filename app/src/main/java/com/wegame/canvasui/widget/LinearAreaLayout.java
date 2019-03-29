package com.wegame.canvasui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import org.json.JSONObject;

public class LinearAreaLayout extends AreaGroup {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int mOrientation;

    /**
     * 在布局方向上的尺寸
     */
    private int mTotalLength;

    public LinearAreaLayout(Context context, JSONObject attribute) {
        super(context, attribute);
        String orientation = attribute.optString("orientation");
        if (TextUtils.equals(orientation, "horizontal")) {
            mOrientation = HORIZONTAL;
        } else {
            // 默认是VERTICAL的
            mOrientation = VERTICAL;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mOrientation == VERTICAL) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        mTotalLength = 0;
        int count = getChildCount();
        final int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);

        for (int i = 0; i < count; i++) {
            final Area child = getChildAt(i);
            if (child == null) {
                mTotalLength += 0;
                continue;
            }
//            if (child.getVi)
        }

    }

    private void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {

    }
}
