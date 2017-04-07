package com.jimmy.swipecard;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    private List<T> mDatas = new ArrayList<>();

    public void add(T t) {
        mDatas.add(t);
    }

    public void add(T t, boolean isNotifyDataSetChanged) {
        mDatas.add(t);
        if (isNotifyDataSetChanged)
            notifyDataSetChanged();
    }

    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void remove(int position, boolean isNotifyDataSetChanged) {
        mDatas.remove(position);
        if (isNotifyDataSetChanged)
            notifyDataSetChanged();
    }

    public void remove(T t, boolean isNotifyDataSetChanged) {
        mDatas.remove(t);
        if (isNotifyDataSetChanged)
            notifyDataSetChanged();
    }

    public void clear(boolean isNotifyDataSetChanged) {
        mDatas.clear();
        if (isNotifyDataSetChanged)
            notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public List<T> getDatas() {
        return mDatas;
    }
}
