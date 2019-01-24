package com.tencent.component.databinding;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tencent.component.R;

import java.util.List;

public class GameAdapter extends HorizontalRecyclerAdapter<GameAdapter.GameViewHolder> {
    private List<Integer> mData;
    private int mSize;
    public GameAdapter(RecyclerView recyclerView) {
        super(recyclerView);
    }

    public void setData(List<Integer> data) {
        mData = data;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public GameViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_game, parent, false);
        GameViewHolder holder = new GameViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final GameViewHolder holder, int position) {
        Integer id = mData.get(position);
        TextView textView = holder.itemView.findViewById(R.id.text);
        textView.setText("" + id);
//        Log.e("datata", "id = " + id);

    }

    public void setViewSize(int size) {
        mSize = size;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull GameViewHolder holder) {
        View itemView = holder.itemView;
        TextView textView = itemView.findViewById(R.id.text);
        Log.e("datata", "id = " + textView.getText());
        if (mSize > 0 && mSize != itemView.getHeight()) {
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.width = mSize;
            params.height = mSize;
            itemView.setLayoutParams(params);
        }
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {



        public GameViewHolder(View view) {
            super(view);
        }
    }
}
