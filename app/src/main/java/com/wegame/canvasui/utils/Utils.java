package com.wegame.canvasui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
