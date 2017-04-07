package com.jimmy.swipecard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SwipeCardAdapter extends BaseRecyclerAdapter<WelfareBean.ResultsEntity> {

    private Context context;

    public SwipeCardAdapter(Context context) {
        super();
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_swipe_card, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        WelfareBean.ResultsEntity entity = getItem(position);
        if (holder instanceof  CardViewHolder){
            CardViewHolder cardViewHolder = (CardViewHolder) holder;
            cardViewHolder.whoTv.setText(entity.getWho());
            cardViewHolder.descTv.setText(entity.getDesc());
            Glide.with(context).load(entity.getUrl()).into(cardViewHolder.imageView);
        }
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView descTv;
        TextView whoTv;
        ImageView imageView;
        View itemView;

        public CardViewHolder(View itemView) {
            super(itemView);
            descTv = (TextView) itemView.findViewById(R.id.desc_tv);
            whoTv = (TextView) itemView.findViewById(R.id.who_tv);
            imageView = (ImageView) itemView.findViewById(R.id.show_image);
            this.itemView = itemView;
        }

    }
}
