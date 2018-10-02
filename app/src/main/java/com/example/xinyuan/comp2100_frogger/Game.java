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
    private Score score;

    public Game() {
        frog = new Frog();
        cars = Cars.generateCar();
        woods = Woods.manyWoods();
        river = new River();
        score = new Score();
        frogDied = false;
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        river.draw(canvas, paint);
        frog.draw(canvas, paint);
        cars.draw(canvas, paint);
        woods.draw(canvas, paint);
        score.draw(canvas, paint);

    }

    public boolean hasWon() {
        return !frogDied;
    }

    public boolean carHit() {
        return frogDied;
    }

    public void step() {
        cars.step();
        cars.updateCars(cars);
        woods.step();
        woods.updateWoods(woods);

        if (frog.reachGoal()) {
            score.s++;
            frog.pos.y = 0.9f;
        }

//         check if frog is hit by a car

//        if (frog.hitby(car)) {
//                frogDied = true;
//        }
    }


    public void touch(String move) {
        if (move == "GOUP") {
            if (frog.pos.y > 0.11)
                frog.pos.y -= FROGMOVE;
        } else if (move == "GODOWN") {
            if (frog.pos.y < 0.89)
                frog.pos.y += FROGMOVE;
        } else if (move == "GOLEFT") {
            if (frog.pos.x > 0.11)
                frog.pos.x -= FROGMOVE;
        } else if (move == "GORIGHT") {
            if (frog.pos.y < 0.89)
                frog.pos.x += FROGMOVE;
        }
    }

}

