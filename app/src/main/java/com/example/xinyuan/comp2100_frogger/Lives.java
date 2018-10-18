package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//This class is written by Zirui Tan
//Initialize number of lives.
public class Lives {
    int lives = 3;

    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = 0.77f * w;
        float yc = 0.035f * h;

        p.setColor(Color.RED);
        p.setTextSize(70);
        c.drawText("Lives: "+String.valueOf(lives), xc, yc, p);
    }
}
