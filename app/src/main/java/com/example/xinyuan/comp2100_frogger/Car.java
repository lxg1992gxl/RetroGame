package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Car extends Sprite {

    public Car (float x, float y) {
        this.pos = new Pos(x,y);
    }
    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        p.setColor(Color.BLACK);
//        c.drawRect(900,900,1100,950,p);
//        p.setColor(Color.RED);
//        c.drawRect(800,800,1000,950,p);
    }
}
