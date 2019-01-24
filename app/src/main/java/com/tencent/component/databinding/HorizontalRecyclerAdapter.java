package com.tencent.component.databinding;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jevinfang on 2018/5/5.
 */

public abstract class HorizontalRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    private RecyclerView mRecyclerView;
    private OnItemClickListener mItemClickListener;

    public HorizontalRecyclerAdapter(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
        initView();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    @Override
    public final VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH holder = onCreateView(parent, viewType);
        bindViewClickListener(holder);
        return holder;
    }

    public abstract VH onCreateView(ViewGroup parent, int viewType);

    public void bindViewClickListener(RecyclerView.ViewHolder holder) {
        if (holder == null) {
            return;
        }
        final View view = holder.itemView;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
                if (holder == null || holder.getAdapterPosition() < 0) {
                    return;
                }
                mDefItemClickListener.onItemClick(HorizontalRecyclerAdapter.this, view, holder.getAdapterPosition());
            }
        });
    }

    private OnItemClickListener mDefItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(RecyclerView.Adapter adapter, View view, int position) {
            scrollItemViewCenter(view);
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(adapter, view, position);
            }
        }
    };

    private void scrollItemViewCenter(View view) {
        if (mRecyclerView.getAdapter().getItemCount() == 0) {
            return;
        }
        int parentCenter = mRecyclerView.getWidth() / 2;
        int offset = parentCenter - view.getWidth() / 2;
        int position = mRecyclerView.getChildAdapterPosition(view);
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        layoutManager.scrollToPositionWithOffset(position, offset);
    }

    public interface OnItemClickListener {

        /**
         * Callback method to be invoked when an item in this RecyclerView has
         * been clicked.
         *
         * @param adapter  the adpater
         * @param view     The itemView within the RecyclerView that was clicked (this
         *                 will be a view provided by the adapter)
         * @param position The position of the view in the adapter.
         */
        void onItemClick(RecyclerView.Adapter adapter, View view, int position);
    }
}
