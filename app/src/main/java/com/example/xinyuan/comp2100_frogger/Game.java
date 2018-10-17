package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {

    private static final float FROGMOVEX = 0.05f;
    private static final float FROGMOVEY = 0.1f;
    public static String gameMode = "EASY";   // default game mode
    public static String currentPlace;

    private River river;
    private Frog frog;
    private Cars cars;
    private Woods woods;
    public static boolean frogDied;
    private Score score;
    public Lives lives;


    public Game() {
        System.out.println(gameMode);
        frog = new Frog();
        cars = Cars.generateCar();
        woods = Woods.generateWoods();
        river = new River();
        score = new Score();
        lives = new Lives();
        frogDied = false;
        currentPlace = "ROAD";
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        river.draw(canvas, paint);
        cars.draw(canvas, paint);
        woods.draw(canvas, paint);
        frog.draw(canvas, paint);
        score.draw(canvas, paint);
        lives.draw(canvas,paint);
    }



    public void step() {
        cars.step();
        cars.updateCars(cars);
        woods.step();
        woods.updateWoods(woods);

        //return frog is dead when frog in river
        //unless frog attached on a wood
        if (frog.pos.y > 0.15f && frog.pos.y < 0.45f) {
            frogDied = true;
            for (Wood w : woods) {
                    if (frog.pos.attachedOnWoods(frog, w)) {
                    frogDied = false;
                    System.out.println("frog attach");
                    frog.attach(w);
                }
            }
        } else {
            frog.attach(null);
        }
        frog.attachOn();

        System.out.println(frog.pos.y);
        if (frog.pos.y <= 0.1f) {
            currentPlace = "VIC";
        }
        else if (frog.pos.y > 0.1f && frog.pos.y <= 0.5f) {
            currentPlace = "RIVER";
        }
        else if (frog.pos.y > 0.1f && frog.pos.y <= 0.9f) {
            currentPlace = "ROAD";
        }

        //if frog reach to the other side of the river
        //increase score and replace the frog
        if (frog.reachGoal()) {
            score.score++;
            frog.pos.replace();
        }

        //check if frog is hit by a car
        if (frog.pos.y > 0.45f && frog.pos.y < 0.9f) {
            for (Car c : cars) {
                if (frog.pos.hitByCar(frog,c)) {
                    frogDied = true;
                }
            }
        }
        //check if frog is dead, if so, lives -1 and back to start position.
        if (frogDied) {
            lives.lives--;
            frog.pos.replace();
            frog.attach(null);
            frogDied = false;
        }

    }


    public void touch(String move) {
        if (move == "GOUP") {
            //limit the frog moving area
            //prevent it moving out of screen
            if (frog.pos.y > Frog.TOPLIMIT)
                frog.pos.y -= FROGMOVEY;
        } else if (move == "GODOWN") {
            if (frog.pos.y < Frog.BOTTOMLIMIT)
                frog.pos.y += FROGMOVEY;
        } else if (move == "GOLEFT") {
            if (frog.pos.x > Frog.LEFTLIMIT)
                frog.pos.x -= FROGMOVEX;
        } else if (move == "GORIGHT") {
            if (frog.pos.x < Frog.RIGHTLIMIT)
                frog.pos.x += FROGMOVEX;
        }
    }

}

