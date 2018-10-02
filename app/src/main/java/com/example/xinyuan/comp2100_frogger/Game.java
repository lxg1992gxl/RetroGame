package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {

    private static final float FROGMOVE = 0.1f;

    private River river;
    private Frog frog;
    private Car car;
    private Cars cars;
    private Woods woods;
    private boolean frogDied;

    public Game() {
        frog = new Frog();
//        car = new Car(0,0);
        cars = Cars.generateCar(3,3);
        woods = Woods.manyWoods(3, 3);
        river = new River();
        frogDied = false;
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        river.draw(canvas,paint);
        frog.draw(canvas, paint);
        cars.draw(canvas, paint);
        woods.draw(canvas, paint);
    }

    public boolean hasWon() {
        return !frogDied;
    }

    public boolean carHit() {
        return frogDied;
    }

    public void step() {
        cars.step();
        woods.step();

//         check if frog is hit by a car
//        if (!frog.initialization && !car.initialization) {
//            if (frog.hitby(car)) {
//                frogDied = true;
//            }
//        }
    }

    public void touch(String move) {
        if (move == "GOUP") {
            frog.pos.y -= FROGMOVE;
        }
        else if (move == "GODOWN") {
            frog.pos.y += FROGMOVE;
        }
        else if (move == "GOLEFT") {
            frog.pos.x -= FROGMOVE;
        }
        else {
            frog.pos.x += FROGMOVE;
        }
    }
}

