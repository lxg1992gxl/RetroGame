package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * A integer can record how many times the frog successfully make through
 * default shown on top left conner
 */

public class Score {
    int score = 0;

    public void draw(Canvas c, Paint p) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = 0.01f * w;
        float yc = 0.03f * h;

        p.setColor(Color.BLACK);
        p.setTextSize(70);

        c.drawText(String.valueOf(score), xc, yc, p);
    }

    public int getScore() {
        return score;
    }

}
