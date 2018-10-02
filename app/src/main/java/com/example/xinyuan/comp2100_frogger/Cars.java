package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class Cars extends ArrayList<Car> {

    private static final float DOWNGAP = 0.1f;
    private static final int MAXCAR = 3;
    private static final float MINGAP = 40.0f;
    private static final float UPPERY = 0.58f;
    private static final float LOWERY = 0.88f;



    public static Cars generateCar(int cols, int rows) {
        Cars res = new Cars();
//        float xgap = 1.0f / (cols + 1);
        for (float y = UPPERY; y <= LOWERY; y+= DOWNGAP) {
            for (int c = 1; c <= MAXCAR ; c++) {
                Random random = new Random();
                float xRandom = random.nextFloat();
                System.out.println(c);
                float x = xRandom;
                res.add(new Car(x, y));
            }
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

    public void draw(Canvas canvas, Paint paint) {
        for (Car c : this) c.draw(canvas, paint);
    }

    public void step() {
        // move the cars side to side

        for (Car c : this) {
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
}

