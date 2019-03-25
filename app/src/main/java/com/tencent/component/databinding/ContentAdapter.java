package com.tencent.component.databinding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tencent.component.R;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private Context mContext;
    private List<Integer> mData = new ArrayList<Integer>();

    public ContentAdapter(Context context) {
        mContext = context;
        mData.clear();
        for (int i = 0; i < 50; i++) {
            mData.add(i);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder contentViewHolder, int i) {
        TextView textView = contentViewHolder.itemView.findViewById(R.id.text);
        textView.setText(mData.get(i) + "");
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_content, viewGroup, false);
        return new ContentViewHolder(view);
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        public ContentViewHolder(View view) {
            super(view);
        }
    }
}
