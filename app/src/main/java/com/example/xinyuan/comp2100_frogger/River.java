package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
//This class is written by Dong Xi
public class River extends Sprite {

    private static final float STARTX = 0.0f;
    private static final float STARTY = 0.15f;
    private static final float ENDY = 0.45f;

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        p.setColor(Color.BLUE);
        RectF river = new RectF (STARTX,STARTY*h,w,ENDY*h);
        c.drawBitmap(RoadView.riverImage,null,river,p);
    }
}
