package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Wood extends Sprite {

    boolean movingleft;

    public Wood(float x, float y){
        this.pos = new Pos(x, y);
        movingleft = true;
    }
    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x * w;
        float yc = pos.y * h;

        p.setColor(Color.RED);
        p.setStrokeWidth(50.0f);

        float woodWidth = 100.0f;
        float woodHeight = 60.0f;
        c.drawRect(xc, yc, xc + woodWidth, yc + woodHeight, p);
        }
}
