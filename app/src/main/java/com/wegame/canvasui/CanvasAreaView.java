package com.wegame.canvasui;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.wegame.canvasui.utils.Utils;
import com.wegame.canvasui.widget.Area;

import org.json.JSONException;
import org.json.JSONObject;

public class CanvasAreaView extends View {

    private Area mArea;

    public CanvasAreaView(Context context) {
        this(context, null, 0);
    }

    public CanvasAreaView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasAreaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void inflateFromJson(String areaStr) {
        JSONObject areaJson = null;
        try {
            areaJson = new JSONObject(areaStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (areaJson == null) {
            throw new RuntimeException("Area json invalid");
        }
        mArea = createRootArea(areaJson);

    }

    private Area createRootArea(JSONObject areaJson) {
        String clazzName = areaJson.optString("area");
        if (TextUtils.isEmpty(clazzName)) {
            throw new RuntimeException("Root area class can not be null");
        }
        Class<Area> areaClazz = null;
        try {
            areaClazz = (Class<Area>) Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (areaClazz == null) {
            throw new RuntimeException("Root class not found");
        }

        Area area = Utils.newInstance(areaClazz);
        if (area == null) {
            throw new RuntimeException("Root class instance result null");
        }
        return area;
    }




}
