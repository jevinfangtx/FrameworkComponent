package com.wegame.canvasui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;

import com.wegame.canvasui.utils.Utils;
import org.json.JSONObject;
import java.util.Iterator;

public class Area {

    protected Context mContext;
    protected String id = null;
    protected int areaWidth;
    protected int areaHeight;
    protected float areaWeight;
    protected int marginLeft;
    protected int marginTop;
    protected int marginRight;
    protected int marginBottom;
    protected int paddingLeft;
    protected int paddingTop;
    protected int paddingRight;
    protected int paddingBottom;
    protected int bgColor;
    protected int visible;

    int mMeasureWidth;
    int mMeasureHeight;

    public Area(Context context, JSONObject attribute) {
        mContext = context;
        Iterator<String> iterator = attribute.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals("id")) {
                this.id = attribute.optString(key);
            } else if (key.equals("width")) {
                this.areaWidth = Utils.getCanvasAreaSize(context, attribute.optString(key));
            } else if (key.equals("height")) {
                this.areaHeight = Utils.getCanvasAreaSize(context, attribute.optString(key));
            } else if (key.equals("weight")) {
                this.areaWeight = (float) attribute.optDouble(key);
            } else if (key.equals("margin")) {
                String marginStr = attribute.optString(key);
                String[] margin = marginStr.trim().split(",");
                if (margin == null || margin.length == 0) {
                    throw new RuntimeException("Read attribute margin " + marginStr + " failed");
                }
                for (int i = 0; i < 4 && i < margin.length; i++) {
                    int value = Utils.getDimensionPixelSize(context, margin[i]);
                    switch (i) {
                        case 0:
                            marginLeft = value;
                            break;
                        case 1:
                            marginTop = value;
                            break;
                        case 2:
                            marginRight = value;
                            break;
                        case 3:
                            marginBottom = value;
                            break;
                        default:
                            break;

                    }
                }
            } else if (key.equals("padding")) {
                String paddingStr = attribute.optString(key);
                String[] padding = paddingStr.trim().split(",");
                if (padding == null || padding.length == 0) {
                    throw new RuntimeException("Read attribute padding " + paddingStr + " failed");
                }
                for (int i = 0; i < 4 && i < padding.length; i++) {
                    int value = Utils.getDimensionPixelSize(context, padding[i]);
                    switch (i) {
                        case 0:
                            paddingLeft = value;
                            break;
                        case 1:
                            paddingTop = value;
                            break;
                        case 2:
                            paddingRight = value;
                            break;
                        case 3:
                            paddingBottom = value;
                            break;
                        default:
                            break;

                    }
                }
            } else if (key.equals("bg_color")) {
                String color = attribute.optString(key);
                try {
                    this.bgColor = Color.parseColor(color);
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            }
        }
    }

    public final void measure(int widthMeasureSpec, int heightMeasureSpec) {
        onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasureDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
    }

    protected final void setMeasureDimension(int measureWidth, int measureHeight) {
        mMeasureWidth = measureWidth;
        mMeasureHeight = measureHeight;
    }

    protected final void setMeasureDimensionRaw(int measureWidth, int measureHeight) {

    }

    public final int getMeasureWidth() {
        return mMeasureWidth;
    }

    public final int getMeasureHeight() {
        return mMeasureHeight;
    }

    /**
     * 获取默认的尺寸
     * @param size
     * @param measureSpec
     * @return
     */
    public static int getDefaultSize(int size, int measureSpec) {
        int result = size;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case View.MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case View.MeasureSpec.AT_MOST:
            case View.MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }



}
