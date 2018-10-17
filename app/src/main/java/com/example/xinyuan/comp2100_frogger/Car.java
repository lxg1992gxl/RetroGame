package com.example.xinyuan.comp2100_frogger;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Random;

public class Car extends Sprite {

    float carWidth = 100.0f;
    float carHeight = 60.0f;

    boolean movingleft;
    float xc, yc;
    int row;
    Random random;

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
        random = new Random();
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
}
