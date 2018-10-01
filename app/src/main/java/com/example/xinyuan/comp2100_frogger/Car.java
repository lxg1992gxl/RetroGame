package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Car extends Sprite {

    //    private static final float Y = 0.9f;
    float cW;
    boolean movingleft;
    float xc, yc;
    Random random;

    public Car(float x, float y) {
        this.pos = new Pos(x, y);
        movingleft = true;
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        p.setColor(Color.BLACK);

        xc = pos.x * w;
        yc = pos.y * h;

//        random = new Random();
//        float carWidth = random.nextInt(120);
        float carWidth = 100.0f;
        float carHeight = 60.0f;
        c.drawRect(xc, yc, xc + carWidth, yc + carHeight, p);
    }

}
