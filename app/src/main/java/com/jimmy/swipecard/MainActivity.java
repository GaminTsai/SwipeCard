package com.jimmy.swipecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardConfig.initConfig(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        SwipeCardAdapter adapter = new SwipeCardAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new SwipeCardLayoutManager());
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        WelfareBean bean = initDemoData();
        adapter.addAll(bean.getResults());

        ItemTouchHelper.Callback callback = new SwipeCardCallBack(recyclerView, adapter, adapter.getDatas());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private WelfareBean initDemoData() {
        String json = "{\n" +
                "  \"count\": 10, \n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"desc\": \"10.27\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa70755f\", \n" +
                "      \"publishedAt\": \"2015-10-27T02:43:16.906000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww2.sinaimg.cn/large/7a8aed7bjw1exfffnlf2gj20hq0qoju9.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"5.20\\u3002\\n520\\u7231\\u4f60\\uff0c\\u5c31\\u7ed9\\u4f60\\u751c\\u751c\\u7684\\u7b11\\u3002\\u4eca\\u65e5\\u7279\\u63a8\\uff01~~\\uff08\\u3065\\uffe33\\uffe3\\uff09\\u3065\\u256d\\u2764\\uff5e\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa7075c5\", \n" +
                "      \"publishedAt\": \"2015-05-21T10:05:06.527000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"6.10\\u2014\\u2014\\uff082\\uff09\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa7076df\", \n" +
                "      \"publishedAt\": \"2015-06-10T04:12:03.656000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1esxxi1vbq0j20qo0hstcu.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"6.10\\u2014\\u2014\\uff081\\uff09\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa7076e1\", \n" +
                "      \"publishedAt\": \"2015-06-10T04:12:04.272000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1esxxiw20rej20qo0hstcp.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"6.18\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa7076f8\", \n" +
                "      \"publishedAt\": \"2015-06-18T03:50:59.419000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1et80fw2p80j20qo0hsdj1.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"7.17\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa707701\", \n" +
                "      \"publishedAt\": \"2015-07-17T03:43:22.394000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww3.sinaimg.cn/large/7a8aed7bgw1eu5jpf3lamj20f00mitck.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"5.19\\n\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa707751\", \n" +
                "      \"publishedAt\": \"2015-05-20T03:57:51.477000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww2.sinaimg.cn/large/7a8aed7bgw1es8c7ucr0rj20hs0qowhl.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"7.3\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa70774e\", \n" +
                "      \"publishedAt\": \"2015-07-03T04:12:02.419000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1etpfol394kj20qo0hsdiw.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"8.18\\u2014\\u2014\\uff081\\uff09\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa70779f\", \n" +
                "      \"publishedAt\": \"2015-08-18T03:58:47.771000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1ev6jgvbt8ij20qo0hrdil.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }, \n" +
                "    {\n" +
                "      \"desc\": \"8.18\\u2014\\u2014\\uff082\\uff09\", \n" +
                "      \"ganhuo_id\": \"56cc6d1d421aa95caa7077a0\", \n" +
                "      \"publishedAt\": \"2015-08-19T03:56:32.545000\", \n" +
                "      \"readability\": \"\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://ww1.sinaimg.cn/large/7a8aed7bgw1ev6jh1hbsgj20hr0qoq5s.jpg\", \n" +
                "      \"who\": \"\\u5f20\\u6db5\\u5b87\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Gson gson = new Gson();
        return gson.fromJson(json, WelfareBean.class);
    }
}
