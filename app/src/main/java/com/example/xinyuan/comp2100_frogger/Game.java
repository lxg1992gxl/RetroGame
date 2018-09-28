package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {

    private Frog frog;
    private Car car;

    public Game() {
        frog = new Frog();
        car = new Car(0,0);
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        frog.draw(canvas, paint);
        car.draw(canvas,paint);

    }

    public void touch(String move) {
        if (move == "GOUP") {
            frog.pos.y -= 150;
        }
        else if (move == "GODOWN") {
            frog.pos.y += 150;
        }
        else if (move == "GOLEFT") {
            frog.pos.x -= 100;
        }
        else {
            frog.pos.x += 100;
        }
    }
}

