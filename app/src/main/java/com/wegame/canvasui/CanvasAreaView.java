package com.wegame.canvasui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.wegame.canvasui.utils.ScreenUtils;
import com.wegame.canvasui.utils.Utils;
import com.wegame.canvasui.widget.Area;
import com.wegame.canvasui.widget.AreaGroup;

import org.json.JSONArray;
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
        mArea = createAreaFromJson(areaJson);
    }

    public void measureCanvas() {
        final int screenWidth = ScreenUtils.getScreenWidth(getContext());
        final int screenHeight = ScreenUtils.getScreenHeight(getContext());
        ViewGroup.LayoutParams lp = this.getLayoutParams();
        final int canvasWidthMeasureSpec = getCanvasMeasureSpec(screenWidth, lp.width);
        final int canvasHeightMeasureSpec = getCanvasMeasureSpec(screenHeight, lp.height);
        mArea.measure(canvasWidthMeasureSpec, canvasHeightMeasureSpec);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("datata", "1111");
    }

    private Area createAreaFromJson(JSONObject areaJson) {
        if (areaJson == null) {
            throw new RuntimeException("Area json can not be null");
        }
        String clazzName = areaJson.optString("Area");
        if (TextUtils.isEmpty(clazzName)) {
            throw new RuntimeException("Area class can not be null");
        }
        Class<Area> areaClazz;
        try {
            areaClazz = (Class<Area>) Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Area class " + clazzName + " not found");
        }
        JSONObject attribute = areaJson.optJSONObject("attribute");
        if (attribute == null) {
            throw new RuntimeException("Read " + clazzName + " attribute failed");
        }
        Area area = Utils.newInstance(areaClazz, new Class<?>[]{Context.class, JSONObject.class}, getContext(), attribute);
        if (area == null) {
            throw new RuntimeException("Instance area class " + clazzName + " return null");
        }
        if (area instanceof AreaGroup) {
            JSONArray children = areaJson.optJSONArray("children");
            if (children != null) {
                for (int i = 0; i < children.length(); i++) {
                    JSONObject childJson = children.optJSONObject(i);
                    Area child = createAreaFromJson(childJson);
                    ((AreaGroup) area).addArea(child);
                }
            }
        }
        return area;
    }

    /**
     * 获取canvas measure的根spec
     * @param windowSize
     * @param rootDimension
     * @return
     */
    private int getCanvasMeasureSpec(int windowSize, int rootDimension) {
        int measureSpec;
        switch (rootDimension) {
            case ViewGroup.LayoutParams.MATCH_PARENT:
                measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
                break;
            case ViewGroup.LayoutParams.WRAP_CONTENT:
                measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                break;
            default:
                measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
                break;
        }
        return measureSpec;
    }
}
