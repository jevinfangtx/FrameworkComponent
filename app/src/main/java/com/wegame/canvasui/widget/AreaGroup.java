package com.wegame.canvasui.widget;

import android.content.Context;

import org.json.JSONObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AreaGroup extends Area {

    private static final int ARRAY_INITIAL_CAPACITY = 12;
    private static final int ARRAY_CAPACITY_INCREMENT = 12;

    private Area[] mChildren = new Area[ARRAY_INITIAL_CAPACITY];
    private int mChildrenCount = 0;

    public AreaGroup(Context context, JSONObject attribute) {
        super(context, attribute);
    }

    public void addArea(Area area) {
        if (area == null) {
            return;
        }
        increaseChildrenArray();
        mChildren[mChildrenCount] = area;
        mChildrenCount++;
    }

    private void increaseChildrenArray() {
        Area[] children = mChildren;
        final int size = mChildren.length;
        if (size == mChildrenCount) {
            mChildren = new Area[size + ARRAY_CAPACITY_INCREMENT];
            System.arraycopy(children, 0, mChildren, 0, size);
        }
    }

    public int getChildCount() {
        return mChildrenCount;
    }

    @Nullable
    public Area getChildAt(int index) {
        if (index < 0 || index >= mChildrenCount) {
            return null;
        }
        return mChildren[index];
    }
}
