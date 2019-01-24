package com.tencent.component.databinding;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tencent.component.R;

import java.util.Arrays;


public class CoordinatorFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private GameAdapter mAdapter;
    private RecyclerView mContentRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coordinator, container, false);
        AppBarLayout appBarLayout = view.findViewById(R.id.app_bar);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new GameAdapter(mRecyclerView);
        mAdapter.setData(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new HorizontalItemDecoration(50, 30));
        int expandSize = getContext().getResources().getDimensionPixelSize(R.dimen.D3);
        int collapsedSize = expandSize - (int) (expandSize * 0.5);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
//                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                int size;
                if (Math.abs(i) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed
//                    Log.e("datata", "Collapsed");
                    size = collapsedSize;

//                    mAdapter.notifyDataSetChanged();
                } else if (i == 0) {
                    // Expanded
                    size = expandSize;
//                    Log.e("datata", "Expanded");

//                    mAdapter.notifyDataSetChanged();
                } else {
//                    Log.e("datata", "between = " + i);
                    size = (int)(expandSize - 1.0f * (expandSize - collapsedSize) * Math.abs(i) / appBarLayout.getTotalScrollRange());
                    // Somewhere in between
                }

//                boolean isViewChanged = false;
//                int childCount = mRecyclerView.getChildCount();
//                View childView;
//                for (int index = 0; index < childCount; index++) {
//                    childView = mRecyclerView.getChildAt(index);
//                    ViewGroup.LayoutParams params = childView.getLayoutParams();
//                    if (params.width != size) {
//                        params.width = size;
//                        params.height = size;
//                        childView.setLayoutParams(params);
//                        isViewChanged = true;
//                    }
//                }
//                if (isViewChanged && mAdapter != null) {
//                    mAdapter.setViewSize(size);
//                }
            }
        });
        mContentRecycler = view.findViewById(R.id.content_recycler);
        mContentRecycler.setAdapter(new ContentAdapter(getContext()));
        mContentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
