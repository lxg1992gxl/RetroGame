package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Car extends Sprite {

    float carWidth;
    float carHeight = 60.0f;
    float carHeadWidth = 30.0f;
    float carHeadHeight = 40.0f;
    float carHeadGap = 5.0f;

    boolean movingleft;
    float xc, yc;
    int row;

    public Car(float x, float y, float carWidth, int row) {
        this.pos = new Pos(x, y);
        this.carWidth = carWidth;
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

        if (movingleft) {
            //draw body
            c.drawRect(xc + carHeadWidth, yc - carHeight / 2, xc + carWidth, yc + carHeight / 2, p);
            //draw head
            c.drawRect(xc, yc - carHeadHeight / 2, xc + carHeadWidth - carHeadGap, yc + carHeadHeight / 2, p);
        } else { //car moving right
            //draw body
            c.drawRect(xc, yc - carHeight / 2, xc + carWidth - carHeadWidth - carHeadGap, yc + carHeight / 2, p);
            //draw head
            c.drawRect(xc + carWidth - carHeadWidth, yc - carHeadHeight / 2, xc + carWidth, yc + carHeadHeight / 2, p);

        }
    }

    // check if the car has driven out of the road / screen
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
}
