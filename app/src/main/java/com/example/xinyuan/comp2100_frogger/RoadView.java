package com.example.xinyuan.comp2100_frogger;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import java.util.Timer;

public class RoadView extends View implements View.OnTouchListener, Runnable {
    public static final int STEPDELAY = 100;
    float canvasH, canvasW;
    Paint paint;
    Game game;
    Timer soundTimer;
    Handler repaintHandler;
    ArrayList<GameOver> observers;
    MediaPlayer mp;
    boolean riverPlaying, roadPlaying, vicPlaying;


    public RoadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        game = new Game();
        this.setOnTouchListener(this);
        soundTimer = new Timer();
        observers = new ArrayList<>();
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);
        mp = BGM.play(context,"ROAD");
        roadPlaying = true;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvasH = canvas.getHeight();
        canvasW = canvas.getWidth();
        game.draw(canvas, paint);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float userX;
        float userY;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            userX = event.getX();
            userY = event.getY();
            game.touch(checkRegion(userX, userY));
        }

        if (Game.currentPlace == "ROAD") {
            if (vicPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(),"ROAD");
                mp.start();
                vicPlaying = false;
                roadPlaying = true;
            }
            if (riverPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(),"ROAD");
                mp.start();
                riverPlaying = false;
                roadPlaying = true;
            }
            if (!roadPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(), "ROAD");
                mp.start();
                roadPlaying = true;
            }

        }
        else if (Game.currentPlace == "RIVER") {
            if (roadPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(), "RIVER");
                mp.start();
                roadPlaying = false;
                riverPlaying = true;
            }
        }
        else if (Game.currentPlace == "VIC") {
            if (riverPlaying || roadPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(), "VIC");
                mp.start();
                vicPlaying = true;
                riverPlaying = false;
                roadPlaying = false;
            }

        }

        invalidate();
        return true;
    }

    // check which region is the user pressing, and return a correct move instruction to the frog
    private String checkRegion(float x, float y) {
        // pressing upper region
        if (x <= canvasW && x >= 0 && y <= canvasH * 0.35f) {
            return "GOUP";
        }
        // pressing lower region
        else if (x <= canvasW && x >= 0 && y >= canvasH * 0.65f) {
            return "GODOWN";
        }
        // pressing left side of middle region
        else if (x <= 0.5 * canvasW && x >= 0 && y < canvasH * 0.65f && y > canvasH * 0.35f) {
            return "GOLEFT";
        } else {
            return "GORIGHT";
        }

    }

    // Step the view forward by one step - if live is 0, game over, else move forward.
    public boolean step() {
        game.step();
        if(game.lives.lives==0){
            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }

    //Notify the observers game over.
    private void notifyGameOver(){
        for (GameOver o: observers) o.gameOver();
    }


    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, RoadView.STEPDELAY);
        }
    }
    //Register observers.
    public void registerGameOver(GameOver o){
        observers.add(o);
    }

}
