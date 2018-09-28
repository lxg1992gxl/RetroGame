package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Game {

    private Frog frog;
    private Woods woods;

    public Game() {
        frog = new Frog();
        woods = Woods.manyWoods(450, 1);
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint) {
        frog.draw(canvas, paint);
        woods.draw(canvas, paint);
    }
}
