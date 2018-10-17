package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Car extends Sprite {

    float carWidth = 100.0f;
    float carHeight = 60.0f;

    boolean movingleft;
    float xc, yc;
    int row;
    Random random;



    public Car(float x, float y, int row) {
        this.pos = new Pos(x, y);
        this.row = row;
        movingleft = true;
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        p.setColor(Color.BLACK);

        xc = pos.x * w;
        yc = pos.y * h;

        random = new Random();
//        float carWidth = random.nextInt(120);

//        c.drawRect(xc, yc, xc + carWidth, yc + carHeight, p);
        c.drawRect(xc, yc, xc + carWidth, yc + carHeight, p);
    }

    public boolean outOfTheRoad() {
        if (movingleft) {
            if (pos.x <= -0.09f) {
                return true;
            }
        } else {
            if (pos.x >= 1.0f) {
                return true;
            }
        }
        return false;
    }

    public boolean hitFrog(Frog frog){
        float fx = frog.xc;
        float fy = frog.yc;

        System.out.println("Frog position");
        System.out.println(fx);
        System.out.println(fy);
        float minDistX = this.xc;
        float maxDistX = this.xc+carWidth;
        float minDistY = this.yc+carHeight;
        float maxDistY = this.yc;
        System.out.println("Car pos");
        System.out.println("min x "+minDistX);
        System.out.println("max x "+maxDistX);
        System.out.println("min y "+minDistY);
        System.out.println("max y"+maxDistY);

        // the frog with radius in this region is hit
        if(fx<=maxDistX && fx>minDistX && fy<=minDistY && fy>maxDistY ){
            return true;
        }
        return false;

    }
}
