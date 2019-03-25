package com.tencent.component.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tencent.component.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UrlImageSpan extends ImageSpan {

    private String url;
    private TextView tv;
    private boolean picShowed;

    public UrlImageSpan(Context context, String url, TextView tv) {
        super(context, R.drawable.icon_feed_elite_left);
        this.url = url;
        this.tv = tv;
    }

    @Override
    public Drawable getDrawable() {
        if (!picShowed) {
            Glide.with(tv.getContext()).asBitmap().load(url).listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
//                    tv.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
                            Resources resources = tv.getContext().getResources();
                            int targetWidth = (int) (60);
                            Bitmap zoom = zoom(resource, targetWidth);
                            BitmapDrawable b = new BitmapDrawable(resources, zoom);

                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                            Field mDrawable;
                            Field mDrawableRef;
                            try {
                                mDrawable = ImageSpan.class.getDeclaredField("mDrawable");
                                mDrawable.setAccessible(true);
                                mDrawable.set(UrlImageSpan.this, b);

                                mDrawableRef = DynamicDrawableSpan.class.getDeclaredField("mDrawableRef");
                                mDrawableRef.setAccessible(true);
                                mDrawableRef.set(UrlImageSpan.this, null);

                                picShowed = true;
                                CharSequence text = tv.getText();

//                                genericInvokeMethod(tv, "handleTextChanged", text, 0, 1, 1);

                                tv.setText(text);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            }
//                        }
//                    }, 0);
                    return false;
                }
            }).submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
        }
        return super.getDrawable();
    }

    /**
     * 按宽度缩放图片
     *
     * @param bmp  需要缩放的图片源
     * @param newW 需要缩放成的图片宽度
     *
     * @return 缩放后的图片
     */
    public static Bitmap zoom(@NonNull Bitmap bmp, int newW) {

        // 获得图片的宽高
        int width = bmp.getWidth();
        int height = bmp.getHeight();

        // 计算缩放比例
        float scale = ((float) newW) / width;

        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);

        return newbm;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        super.draw(canvas, text, start, end, x, top, y, bottom, paint);
    }

    public static Object genericInvokeMethod(Object obj, String methodName,
                                             Object... params) {
        int paramCount = params.length;
        Method method;
        Object requiredObj = null;
        Class<?>[] classArray = new Class<?>[paramCount];
        for (int i = 0; i < paramCount; i++) {
            classArray[i] = params[i].getClass();
        }
        try {
            method = obj.getClass().getDeclaredMethod(methodName, classArray);
            method.setAccessible(true);
            requiredObj = method.invoke(obj, params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return requiredObj;
    }
}
