package com.tencent.component.databinding;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jevinfang on 2018/5/11.
 */

public class GridItemDecoration1 extends RecyclerView.ItemDecoration {

    public static final String TAG = "GridItemDecoration";
    private int horizontalSpace;
    private int verticalSpace;
    public int paddingH;

    public GridItemDecoration1(Context context, @DimenRes int hRes, int vRes, int pHRes) {
        horizontalSpace = context.getResources().getDimensionPixelOffset(hRes);
        verticalSpace = context.getResources().getDimensionPixelOffset(vRes);
        paddingH = context.getResources().getDimensionPixelOffset(pHRes);
    }

    public GridItemDecoration1(int horizontalSpace, int verticalSpace, int paddingH) {
        this.horizontalSpace = horizontalSpace;
        this.verticalSpace = verticalSpace;
        this.paddingH = paddingH;
    }

    public int getPaddingH(){
        return paddingH;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.LayoutManager lm = parent.getLayoutManager();
        if (!(lm instanceof GridLayoutManager)) {
            throw new ClassCastException("LayoutManager is not GridLayoutManager");
        }
        int itemCount = parent.getAdapter().getItemCount();
        GridLayoutManager layoutManager = (GridLayoutManager) lm;
        int spanCount = layoutManager.getSpanCount();
        int columnCount, rowCount;
        if (layoutManager.getOrientation() == GridLayoutManager.VERTICAL) {
            columnCount = itemCount <= spanCount ? itemCount : spanCount;
            rowCount = itemCount <= spanCount ? 1 : (itemCount / spanCount) + 1;
        } else {
            rowCount = itemCount <= spanCount ? itemCount : spanCount;
            columnCount = itemCount <= spanCount ? 1 : (itemCount / spanCount) + 1;
        }
        int position = parent.getChildAdapterPosition(view);

        if (columnCount <= 1) {
            outRect.left = 0;
            outRect.right = 0;
        } else {
            /*
            left = i * (itemSpace - itemAdd)
            right = (i + 1) * itemAdd - i * itemSpace;
             */
            float itemSpace = horizontalSpace;
            float itemAdd = (columnCount - 1) * itemSpace * 1.0f / columnCount;
            int column = position % columnCount;
            if (position % columnCount == 0) {
                outRect.left = 0;
                outRect.right = (int) ((column + 1) * itemAdd - column * itemSpace);
            } else if ((position + 1) % columnCount == 0) {
                outRect.right = 0;
                outRect.left = (int) (column * (itemSpace - itemAdd));
            } else {
                outRect.left = (int) (column * (itemSpace - itemAdd));
                outRect.right = (int) ((column + 1) * itemAdd - column * itemSpace);
            }
        }

        if (rowCount <= 1) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else {
            float itemSpace = verticalSpace;
            float itemAdd = (rowCount - 1) * itemSpace * 1.0f / rowCount;
            int row = position / columnCount;
            if (row == 0) {
                outRect.top = 0;
                outRect.bottom = (int) ((row + 1) * itemAdd - row * itemSpace);
            } else if ((row + 1) == rowCount) {
                outRect.top = (int) (row * (itemSpace - itemAdd));
                outRect.bottom = 0;
            } else {
                outRect.top = (int) (row * (itemSpace - itemAdd));
                outRect.bottom = (int) ((row + 1) * itemAdd - row * itemSpace);
            }
        }
    }
}
