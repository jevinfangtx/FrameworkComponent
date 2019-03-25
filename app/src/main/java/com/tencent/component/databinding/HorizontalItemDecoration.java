package com.tencent.component.databinding;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jevinfang on 2018/5/4.
 */

public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {

    private int mItemOffset;
    private int mFirstItemOffset;

    public HorizontalItemDecoration(int itemOffset, int firstItemOffset) {
        mItemOffset = itemOffset;
        mFirstItemOffset = firstItemOffset;
    }

    public HorizontalItemDecoration(@NonNull Context context, @DimenRes int itemOffsetId,
                                    @DimenRes int firstItemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId),
                context.getResources().getDimensionPixelOffset(firstItemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildViewHolder(view).getAdapterPosition();
        setSpacingForItem(outRect, position, state.getItemCount());
//        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }

    private void setSpacingForItem(Rect outRect, int position, int itemCount) {
        if (position == 0) {
            outRect.left = mFirstItemOffset;
        } else if (position == itemCount - 1) {
            outRect.left = mItemOffset;
            outRect.right = mFirstItemOffset;
        } else {
            outRect.left = mItemOffset;
        }
    }
}
