package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {

    private Frog frog;

    public Game() {
        frog = new Frog();
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        frog.draw(canvas, paint);
    }
}
