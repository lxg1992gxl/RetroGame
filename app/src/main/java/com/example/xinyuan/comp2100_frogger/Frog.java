package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Frog extends Sprite{

    public static final float STARTX = 0.5f;
    public static final float STARTY = 0.9f;
    public static final float FROGRADIUS = 20;
    float xc, yc;
    boolean initialization = true;


    public Frog() {
        pos = new Pos(STARTX, STARTY);
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

//        if (pos.x == 0.5f && pos.y == 0.9f) {
//            xc = pos.x * w;
//            yc = pos.y * h;
//            pos.x = xc;
//            pos.y = yc;
//            System.out.println("inital x " + xc + " and y is "+ yc);
//            initialization = false;
//        }
//        else {
//            xc = pos.x;
//            yc = pos.y;
//        }

        xc = pos.x * w;
        yc = pos.y * h;
//        System.out.println("x is " + xc + "and yc is " + yc);

        p.setColor(Color.GREEN);

        c.drawCircle(xc,yc,FROGRADIUS,p);
    }

    public boolean hitby(Car c) {
        return (c.pos.rectCircleColliding(this,c));
    }
}
