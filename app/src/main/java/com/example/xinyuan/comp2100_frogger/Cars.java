package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class Cars extends ArrayList<Car> {

    private static final int CARROW = 3;
    private static final int MAXCAR = 3;
    private static final float MINGAP = 40.0f;


    public static Cars generateCar(float cW) {
        Random random = new Random();
        Cars res = new Cars();
        float xRandom = random.nextInt((int)cW);
        for (float y = 1275.6f; y <= 975.6; y-=150.0f) {
            float xGap = MINGAP + random.nextInt(60);
            for (float x = xRandom; x <= MAXCAR; x+= xGap) {
                res.add(new Car(xRandom,y));
            }

        }
        return res;
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Car c : this) c.draw(canvas, paint);
    }

    public void step() {
        // move the cars side to side

//        if (movingleft) {
//            this.pos.x -= 15;
//            if (this.pos.x == 0) {
//                movingleft = false;
//            }
//        } else {
//            this.pos.x += 15;
//            if (this.pos.x == cW) {
//                movingleft = true;
//            }
//        }
//    }
    }
}
