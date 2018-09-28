package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Frog extends Sprite{

    public static final float STARTX = 0.5f;
    public static final float STARTY = 0.9f;

    public Frog() {
        pos = new Pos(STARTX, STARTY);
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc, yc;

        if (pos.x == 0.5f && pos.y == 0.9f) {
            xc = pos.x * w;
            yc = pos.y * h;
            pos.x = xc;
            pos.y = yc;
            System.out.println("inital x " + xc + " and y is "+ yc);
        }
        else {
            xc = pos.x;
            yc = pos.y;
        }

        p.setColor(Color.GREEN);

        c.drawCircle(xc,yc,20,p);
    }
}
