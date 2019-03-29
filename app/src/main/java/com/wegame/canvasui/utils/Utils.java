package com.wegame.canvasui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Utils {

    @Nullable
    public static <T> T newInstance(@NonNull Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static <T> T newInstance(@NonNull Class<T> clazz, Class<?>[] constructorParamTypes, Object... constructorParams) {
        try {
            Constructor<T> c = clazz.getConstructor(constructorParamTypes);
            c.setAccessible(true);
            return c.newInstance(constructorParams);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取布局的尺寸 {match_parent, wrap_content, 0, dp, px}
     * @param context
     * @param sizeStr
     * @return
     */
    public static int getCanvasAreaSize(Context context, String sizeStr) {
        if (TextUtils.equals(sizeStr, "match_parent")) {
            return ViewGroup.LayoutParams.MATCH_PARENT;
        } else if (TextUtils.equals(sizeStr, "wrap_content")) {
            return ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            return getDimensionPixelSize(context, sizeStr);
        }
     }

    /**
     * 其他单位数值转化为px单位
     * 0 -> 0, px -> px, dp -> dp
     * @param context
     * @param valueStr
     * @return
     */
    public static int getDimensionPixelSize(Context context, String valueStr) {
        String valueTrim = valueStr.trim();
        if (TextUtils.equals(valueTrim, "0")) {
            return 0;
        }
        int size = valueTrim.length();
        String unit = valueTrim.substring(size - 2, size);
        String data = valueTrim.substring(0, size -2);
        Float value = 0f;
        try {
             value = Float.parseFloat(data);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int pixel = 0;
        if (TextUtils.equals(unit, "dp")) {
            pixel = DensityUtil.dip2px(context, value);
        } else if (TextUtils.equals(unit, "px")) {
            pixel = value.intValue();
        }
        return pixel;
    }



    /**
     * 判断是否有网络连接
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }

        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            //Log.w(LOG_TAG, "couldn't get connectivity manager");
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {

                    if (info[i].isConnected()) {
                        //Log.d(LOG_TAG, "network is available");
                        return true;
                    }
                }
            }
        }
        //Log.d(LOG_TAG, "network is not available");
        return false;
    }

}
