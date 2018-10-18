package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private static final float FROGMOVEX = 0.05f;
    private static final float FROGMOVEY = 0.1f;
    public static String gameMode = "EASY";   // default game mode
    public static String currentPlace;

    private River river;
    private Frog frog;
    private Cars cars;
    private Woods woods;
    public static boolean frogDied, won, ableToMove, delayed;
    public static Score score;
    public Lives lives;


    public Game() {
        System.out.println(gameMode);
        frog = new Frog();
        cars = Cars.generateCar();
        woods = Woods.generateWoods();
        river = new River();
        score = new Score();
        lives = new Lives();
        frogDied = won = delayed = false;
        ableToMove = true;
        currentPlace = "ROAD";          // default frog starting place
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        river.draw(canvas, paint);
        cars.draw(canvas, paint);
        woods.draw(canvas, paint);
        frog.draw(canvas, paint);
        score.draw(canvas, paint);
        lives.draw(canvas, paint);
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

        // return frog is dead when frog in river unless frog is  attachOn on a wood
        if (frog.pos.y > 0.15f && frog.pos.y < 0.45f) {
            frogDied = true;
            for (Wood w : woods) {
                if (frog.pos.jumpedOnWoods(frog, w)) {
                    frogDied = false;
                    frog.attach(w);
                }
            }
        } else {
            frog.attach(null);
        }
        frog.attachOn();

        // get where the frog is currently at so that correct bgm can be played
        getCurrentPlace();

        //check if frog is dead, and revive frog back to starting position after 1sec
        if (frogDied) {
            if (!won) {
                lives.lives--;
                won = true;
                ableToMove = false;
            }
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    frog.pos.replace();
                    frog.attach(null);
                    frogDied = won = false;
                    ableToMove = true;
                }
            }, 1000);

        }

        //if frog reaches to the other side of the river increase score
        // then replace the frog after 4 sec
        if (frog.reachGoal()) {
            if (!won) {
                score.score++;
                won = true;
            }
            if (!delayed) {
                delayed = true;
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        frog.pos.replace();
                        won = false;
                        delayed = false;
                    }
                }, 4000);
            }
        }

        //check if frog is hit by a car
        if (frog.pos.y > 0.45f && frog.pos.y < 0.9f) {
            for (Car c : cars) {
                if (frog.pos.hitByCar(frog, c)) {
                    frogDied = true;
                }
            }
        }
    }


    // move the frog according to user touch event
    public void touch(String move) {
        if (ableToMove) {
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

    // get the current frog's location
    public String getCurrentPlace() {
        if (frog.pos.y <= 0.12f) {
            return currentPlace = "VIC";
        } else if (frog.pos.y > 0.1f && frog.pos.y <= 0.52f) {
            return currentPlace = "RIVER";
        } else if (frog.pos.y > 0.5f && frog.pos.y <= 0.92f) {
            return currentPlace = "ROAD";
        }
        throw new Error("Invalid place for frog!! " + frog.pos.y);
    }
}

