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
    boolean initialization = true;
    Wood attached = null;


    public Frog() {
        pos = new Pos(STARTX, STARTY);
    }

    public void attach(Wood wood){
        attached = wood;
    }


    //check if frog is on a wood
    //stop frog if it is riding wood out of screen
    public void attached() {
        if (attached != null) {
            if (attached.movingleft) {
                if (pos.x >= LEFTLIMIT){
                    this.pos.x -= 0.025f;
                }
            } else {
                if (pos.x <= RIGHTLIMIT){
                    this.pos.x += 0.025f;
                }
            }
        }
    }

    @Override
    public void draw(Canvas c, Paint p) {
//        System.out.println("x is " + xc + "and yc is " + yc);
        int h = c.getHeight();
        int w = c.getWidth();

        xc = pos.x * w;
        yc = pos.y * h;
//        System.out.println("x is " + xc + "and yc is " + yc);

        p.setColor(Color.GREEN);

        c.drawCircle(xc,yc,FROGRADIUS,p);
    }

    //not used
    public boolean hitby(Car c) {
        return (c.pos.rectCircleColliding(this,c));
    }


    //check if frog reach the other side of the river
    //if the frog reach the goal, return true
    public boolean reachGoal() {
        if (this.pos.y < 0.1) {
            return true;
        } else return false;
    }
}
