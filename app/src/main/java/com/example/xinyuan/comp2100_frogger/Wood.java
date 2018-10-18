package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
//This class is written by Dong Xi

public class Wood extends Sprite {

    float woodWidth, xc, yc;
    float woodHeight = 60.0f;
    boolean movingleft;
    int row;
    float round = 15.0f;

    public Wood(float x, float y, float woodWidth, int row) {
        this.pos = new Pos(x, y);
        this.row = row;
        this.woodWidth = woodWidth;
        movingleft = true;
    }

    @Override
    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        xc = pos.x * w;
        yc = pos.y * h;

        p.setColor(Color.rgb(222, 184, 135));
        p.setStrokeWidth(50.0f);

        //draw wood in round rec
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            c.drawRoundRect(xc, yc - woodHeight / 2, xc + woodWidth, yc + woodHeight / 2, round, round, p);
        }
    }

    // check if the wood has floated out of the river/screen
    public boolean outOfTheRiver() {
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
