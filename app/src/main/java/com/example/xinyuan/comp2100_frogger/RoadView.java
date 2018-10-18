package com.example.xinyuan.comp2100_frogger;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
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
    boolean riverPlaying, roadPlaying, vicPlaying, ggPlaying;
    public static Bitmap riverImage;


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
        mp.start();
        roadPlaying = true;
        riverPlaying = vicPlaying = ggPlaying = false;
        riverImage = BitmapFactory.decodeResource(getResources(), R.drawable.river);

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


        playBGM();
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

    // step the view forward by one step - true is returned if more steps to go
    public boolean step() {
        game.step();
        if(game.lives.lives==0){
            notifyGameOver();
            return false;
        }

        /*
        checking special cases so that correct BGM can be play
        */
        if (!Game.won && vicPlaying && !roadPlaying) {
            BGM.stopPlaying(mp);
            mp = BGM.play(this.getContext(),"ROAD");
            mp.start();
            vicPlaying = false;
            roadPlaying = true;
        }
        else if (Game.frogDied && !ggPlaying && !riverPlaying && roadPlaying) {
            BGM.stopPlaying(mp);
            mp = BGM.play(this.getContext(),"GG");
            mp.setVolume(1,1);
            mp.start();
            roadPlaying = false;
            ggPlaying = true;
        }
        else if (!Game.frogDied && ggPlaying && !roadPlaying) {
            BGM.stopPlaying(mp);
            mp = BGM.play(this.getContext(),"ROAD");
            mp.start();
            roadPlaying = true;
            ggPlaying = false;
            riverPlaying = false;
        }
        else if (Game.frogDied && !ggPlaying && riverPlaying && !roadPlaying) {
            BGM.stopPlaying(mp);
            mp = BGM.play(this.getContext(),"GG");
            mp.setVolume(1,1);
            mp.start();
            riverPlaying = false;
            ggPlaying = true;
        }
        this.invalidate();
        return true;
    }

    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, RoadView.STEPDELAY);
        }
    }

    // play different BGM based on the current frog location
    public void playBGM() {
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
    }

    //Notify the observers game over.
    private void notifyGameOver(){
        for (GameOver o: observers) o.gameOver();
    }

    //Register observers.
    public void registerGameOver(GameOver o){
        observers.add(o);
    }

}
