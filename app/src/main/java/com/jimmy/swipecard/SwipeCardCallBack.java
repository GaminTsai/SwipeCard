package com.jimmy.swipecard;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.List;

public class SwipeCardCallBack extends ItemTouchHelper.SimpleCallback {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List mData;

    public SwipeCardCallBack(RecyclerView recyclerView,
                             RecyclerView.Adapter adapter,
                             List mData) {
//四个滑动方向
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.mData = mData;
    }

//    @Override
//    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//        return 0;
//    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //滑动删除的方向
        Object removeObj = mData.remove(viewHolder.getLayoutPosition());
        mData.add(0, removeObj);
        adapter.notifyDataSetChanged();

    }

//    @Override
//    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//        //监听到child的变化，控制层叠动画效果
//        //零界点与滑动的比例系数有关系，
//        double distance = Math.sqrt(dX*dX+dY*dY);
//        double fraction = distance/getMoveThreshold(viewHolder);
//        if (fraction>1) fraction = 1;
//        int childCount = recyclerView.getChildCount();
//        for (int i = 0;i<childCount;i++){
//            View child = recyclerView.getChildAt(i);
//
//        }
//    }
}
