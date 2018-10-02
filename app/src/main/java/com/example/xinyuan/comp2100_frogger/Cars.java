package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Cars extends ArrayList<Car> {

    private static final float DOWNGAP = 0.1f;
    private static final int MAXCAR = 3;
    private static final float MINGAP = 20.0f;
    private static final float UPPERY = 0.58f;
    private static final float LOWERY = 0.88f;

    public static Cars generateCar() {
        Cars res = new Cars();
        int row = 1;

        for (float y = UPPERY; y <= LOWERY; y += DOWNGAP) {
            for (int numberOfCar = 1; numberOfCar <= MAXCAR; numberOfCar++) {
                Random random = new Random();
                float xRandom = random.nextFloat();
                float x = xRandom;
                res.add(new Car(x, y, row));
            }
            row++;
        }
        for (int i = 0; i < res.size(); i++) {
            if (i < 3 || i > 6) {
                res.get(i).movingleft = true;
            } else {
                res.get(i).movingleft = false;
            }
        }
        return res;
    }

    public static Car generateNewCar(int row) {
        if (row == 1) {
            Car c = new Car(1.0f, UPPERY, 1);
            c.movingleft = true;
            return c;
        } else if (row == 3) {
            Car c = new Car(1.0f, UPPERY + DOWNGAP + DOWNGAP, 3);
            c.movingleft = true;
            return c;
        } else {
            Car c = new Car(0.0f, UPPERY + DOWNGAP, 2);
            c.movingleft = false;
            return c;
        }
    }

    public void draw(Canvas canvas, Paint paint) {
        for (Car c : this) c.draw(canvas, paint);
    }

    public void step() {
        // move the cars side to side
        for (Car c : this) {
            if (c.movingleft) {
                c.pos.x -= 0.025f;
            }
            else {
                c.pos.x += 0.025f;
            }
        }
    }

    public void updateCars(Cars cars) {
        ListIterator<Car> ci = this.listIterator();
        while (ci.hasNext()) {
            Car c = ci.next();
            if (c.outOfTheRoad()) {
                int row = c.row;
                ci.remove();
                ci.add(generateNewCar(row));
            }
        }
    }
}

