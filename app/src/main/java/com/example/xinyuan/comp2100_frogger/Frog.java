package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Frog extends Sprite{

    public static final float STARTX = 100f;
    public static final float STARTY = 800f;

    public Frog() {
        pos = new Pos(STARTX, STARTY);
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

//        float xc = pos.x * w;
//        float yc = pos.y * h;
        p.setColor(Color.GREEN);

        c.drawCircle(STARTX,STARTY,20,p);
    }
}
