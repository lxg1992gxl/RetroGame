package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Woods extends ArrayList<Wood> {

    private static final float DOWNGAP = 0.1f;
    private static final int MAXWOOD = 3;
    private static final float UPPERY = 0.18f;
    private static final float LOWERY = 0.38f;
    static float speed = 0.015f;

    public static Woods manyWoods() {
        Woods res = new Woods();
        int rows = 1;
        float[][] woodPosition = WoodPositions.getPosition();
        int i = 0;

        for (float y = UPPERY; y <= LOWERY; y += DOWNGAP) {
            for (int c = 1; c <= MAXWOOD; c++) {
                res.add(new Wood(woodPosition[i][0], y, woodPosition[i][1],rows));
                i++;
            }
            rows++;
        }
        for (int j = 0; j < res.size(); j++) {
            if (j < 3 || j >= 6) {
                res.get(j).movingleft = true;
            } else {
                res.get(j).movingleft = false;
            }
        }
        return res;
    }

    public static Wood generateWood(float woodWidth, int row) {
        if (row == 1) {
            Wood c = new Wood(1.0f, UPPERY,woodWidth, 1);
            c.movingleft = true;
            return c;
        } else if (row == 3) {
            Wood c = new Wood(1.0f, UPPERY + DOWNGAP + DOWNGAP,woodWidth, 3);
            c.movingleft = true;
            return c;
        } else {
            Wood c = new Wood(0.0f, UPPERY + DOWNGAP,woodWidth,2);
            c.movingleft = false;
            return c;
        }
    }

    public void draw(Canvas c, Paint p) {
        for (Wood a : this) a.draw(c, p);
    }

    public void step() {
        for (Wood c : this) {
            if (c.movingleft) {
                c.pos.x -= speed;
            } else {
                c.pos.x += speed;
            }
        }
    }

    public void updateWoods(Woods woods) {
        ListIterator<Wood> ci = this.listIterator();
        while (ci.hasNext()) {
            Wood c = ci.next();
            if (c.outOfTheRoad()) {
                int row = c.row;
                float woodWidth = c.woodWidth;
                ci.remove();
                ci.add(generateWood(woodWidth, row));
            }
        }
    }
}
