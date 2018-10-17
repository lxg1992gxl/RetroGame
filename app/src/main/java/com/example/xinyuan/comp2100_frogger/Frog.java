package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Frog extends Sprite{

    public static final float STARTX = 0.5f;
    public static final float STARTY = 0.9f;
    public static final float FROGRADIUS = 20;

    public static final double LEFTLIMIT = 0.06;
    public static final double RIGHTLIMIT = 0.94;
    public static final double TOPLIMIT = 0.11;
    public static final double BOTTOMLIMIT = 0.89;

    float xc, yc;
    int cH, cW;
    Wood attached = null;


    public Frog() {
        pos = new Pos(STARTX, STARTY);
    }

    public void attach(Wood wood){
        attached = wood;
    }


    //Attach the frog on a wood (so that frog can move along with it)
    //stop frog if it is riding wood out of screen
    public void attachOn() {
        if (attached != null) {
            if (attached.movingleft) {
                if (pos.x >= LEFTLIMIT){
                    this.pos.x -= Woods.speed;
                }
            } else {
                if (pos.x <= RIGHTLIMIT){
                    this.pos.x += Woods.speed;
                }
            }
        }
    }


    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();
        cH = h;
        cW = w;
        xc = pos.x * w;
        yc = pos.y * h;
        p.setColor(Color.GREEN);
        c.drawCircle(xc,yc,FROGRADIUS,p);

//        System.out.println(c.getHeight());
//        System.out.println(pos.y);
        //System.out.println(yc);

    }


    //check if frog reach the other side of the river
    //if the frog reach the goal, return true
    public boolean reachGoal() {
        if (this.pos.y < 0.1) {
            return true;
        } else return false;
    }
}
