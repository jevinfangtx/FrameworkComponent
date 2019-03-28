package com.wegame.canvasui.widget;

import android.content.Context;

import org.json.JSONObject;

public class LinearAreaLayout extends AreaGroup {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int mOrientation;

    public LinearAreaLayout(Context context, JSONObject attribute) {
        super(context, attribute);
        mOrientation = attribute.optInt("orientation");
    }
}
