package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Woods extends ArrayList<Wood> {

    private static final float DOWNGAP = 0.1f;
    private static final int MAXWOOD = 3;
    private static final float MINGAP = 40.0f;
    private static final float UPPERY = 0.18f;
    private static final float LOWERY = 0.38f;

    public static Woods manyWoods(){
        Woods res = new Woods();
        int rows = 1;
        for (float y = UPPERY; y <= LOWERY; y+= DOWNGAP) {
            for (int c = 1; c <= MAXWOOD ; c++) {
                Random random = new Random();
                float xRandom = random.nextFloat();
                System.out.println(c);
                float x = xRandom;
                res.add(new Wood(x, y, rows));
            }
            rows ++;
        }
        for (int i = 0; i < res.size(); i++) {
            if (i < 3 || i >6) {
                res.get(i).movingleft = true;
            }
            else {
                res.get(i).movingleft = false;
            }
        }
        return res;
    }

    public static Wood generateWood(int row){
        if (row == 1) {
            Wood c = new Wood(1.0f, UPPERY, 1);
            c.movingleft = true;
            return c;
        } else if (row == 3) {
            Wood c = new Wood(1.0f, UPPERY + DOWNGAP + DOWNGAP, 3);
            c.movingleft = true;
            return c;
        } else {
            Wood c = new Wood(0.0f, UPPERY + DOWNGAP, 2);
            c.movingleft = false;
            return c;
        }
    }

    public void draw(Canvas c, Paint p){
        for (Wood a:this) a.draw(c, p);
    }

    public void step(){
        for (Wood c : this) {
            if (c.movingleft) {
                c.pos.x -= 0.025f;
                if (c.pos.x <= 0.0f) {
                    c.movingleft = false;
                }
            } else {
                c.pos.x += 0.025f;
                if (c.pos.x >= 1.0f) {
                    c.movingleft = true;
                }
            }
        }
    }

    public void updateWoods(Woods woods){
        ListIterator<Wood> ci = this.listIterator();
        while (ci.hasNext()) {
            Wood c = ci.next();
            if (c.outOfTheRoad()) {
                int row = c.row;
                ci.remove();
                ci.add(generateWood(row));
            }
        }
    }
}
