package com.jimmy.swipecard;

import android.content.Context;
import android.util.TypedValue;

public class CardConfig {
    public static int MAX_SHOW_COUNT;
    public static float SCALE_GAP;
    public static int TRANS_Y_GAP;


    public static void initConfig(Context context) {
        MAX_SHOW_COUNT = 4;
        SCALE_GAP = 0.05f;
        TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, context.getResources().getDisplayMetrics());


    }


}
