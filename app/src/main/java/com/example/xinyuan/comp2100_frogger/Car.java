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

        c.drawRect(xc, yc, xc + carWidth, yc + carHeight, p);
    }

    public boolean outOfTheRoad() {
        if (movingleft) {
            pos.x -= 0.025f;
            if (pos.x <= -0.09f) {
                return true;
            }
        } else {
            pos.x += 0.025f;
            if (pos.x >= 1.0f) {
                return true;
            }
        }
        return false;
    }
}
