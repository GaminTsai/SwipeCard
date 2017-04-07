package com.jimmy.swipecard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class SwipeCardLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        super.onLayoutChildren(recycler, state);
        //摆放里面的子控件
        /**
         * RecyclerView的核心源码：recycler类
         * ViewHolder的重用，缓冲scrap(废弃) detach attach
         *
         */
        //1、在布局前把所有的子View detach掉，然后放入scrap集合里面缓存
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount < 1) return;

        int bottomPosition;


        if (itemCount < CardConfig.MAX_SHOW_COUNT) {
            bottomPosition = 0;
        } else {
            bottomPosition = itemCount - CardConfig.MAX_SHOW_COUNT;
        }

        //2.将最顶层的4个view添加到recyclerView容器内
        for (int position = bottomPosition;position<itemCount;position++){
            View view = recycler.getViewForPosition(position);
            addView(view);
            //测量child
            measureChildWithMargins(view,0,0);

            int withSpace = getWidth()-getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);
            //摆放child
            layoutDecorated(view,
                    withSpace/2,
                    heightSpace/2,
                    withSpace/2+getDecoratedMeasuredWidth(view),
                    heightSpace/2+getDecoratedMeasuredHeight(view));
            //层叠错开的效果

        }

    }
}
