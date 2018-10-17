package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Cars extends ArrayList<Car> {

    private static final float DOWNGAP = 0.1f;
    private static final int MAXCAR = 3;
    private static final float UPPERY = 0.6f;
    private static final float LOWERY = 0.9f;

    public static Cars generateCar() {
        Cars res = new Cars();

        float[][] carPos = CarPositions.getPosition();

        int row = 1;
        int i = 0;
        for (float y = UPPERY; y <= LOWERY; y += DOWNGAP) {
            for (int numberOfCar = 0; numberOfCar < MAXCAR; numberOfCar++) {
                res.add(new Car(carPos[i][0], y, carPos[i][1],row));
                i++;
            }
            row++;
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

    public static Car generateNewCar(float carWidth, int row) {
        if (row == 1) {
            Car c = new Car(1.0f, UPPERY, carWidth,1);
            c.movingleft = true;
            return c;
        } else if (row == 3) {
            Car c = new Car(1.0f, UPPERY + DOWNGAP + DOWNGAP,carWidth, 3);
            c.movingleft = true;
            return c;
        } else {
            Car c = new Car(0.0f, UPPERY + DOWNGAP,carWidth,2);
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
                c.pos.x -= 0.015f;
            } else {
                c.pos.x += 0.015f;
            }
        }
    }

    public void updateCars(Cars cars) {
        ListIterator<Car> ci = this.listIterator();
        while (ci.hasNext()) {
            Car c = ci.next();
            if (c.outOfTheRoad()) {
                int row = c.row;
                float carWidth = c.carWidth;
                ci.remove();
                ci.add(generateNewCar(carWidth,row));
            }
        }
    }
}

