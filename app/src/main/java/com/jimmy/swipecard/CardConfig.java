package com.jimmy.swipecard;

import android.content.Context;
import android.util.TypedValue;

public class CardConfig {
    public static int DEFAULT_SHOW_ITEM;
    public static float DEFAULT_SCALE;
    public static int DEFAULT_TRANSLATE_Y;


    public static void initConfig(Context context) {
        DEFAULT_SHOW_ITEM = 4;
        DEFAULT_SCALE = 0.05f;
        DEFAULT_TRANSLATE_Y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, context.getResources().getDisplayMetrics());


    }


}
