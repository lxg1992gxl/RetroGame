package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Car extends Sprite {

    private static final float Y = 0.9f;
    float cW;
    boolean movingleft;
    float xc, yc;

    public Car (float x, float y) {
        this.pos = new Pos(x,y);
        movingleft = true;
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();
        cW = w;

        p.setColor(Color.BLACK);


        // 1275.6
        // 1125.6
        // 975.6

        if (pos.x == 0.5f && pos.y == 0.9f) {
            xc = pos.x * w;
            yc = pos.y * h - 180;
            pos.x = xc;
            pos.y = yc;
            System.out.println("inital x " + xc + " and y is "+ yc);
        }
        else {
            xc = pos.x;
            yc = pos.y;
        }

//        xc = pos.x * w;
//        yc = pos.y * h - 180.0f;
//        pos.x = xc;
//        pos.y = yc;
        c.drawRect(xc,yc,xc+100,yc+50,p);
    }

    public void step() {
        // move the cars side to side

        if (movingleft) {
            this.pos.x -= 15;
            if (this.pos.x == 0) {
                movingleft = false;
            }
        } else {
            this.pos.x += 15;
            if (this.pos.x == cW) {
                movingleft = true;
            }
        }
    }
}
