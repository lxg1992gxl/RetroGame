package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class River extends Sprite {

    public static final float STARTX = 0.0f;
    public static final float STARTY = 0.15f;
    public static final float ENDY = 0.45f;


    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        p.setColor(Color.BLUE);
        c.drawRect(STARTX,STARTY * h,w,ENDY * h, p);
    }
}
