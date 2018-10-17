package com.example.xinyuan.comp2100_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;

public class RoadView extends View implements View.OnTouchListener, Runnable {
    public static final int STEPDELAY = 100;
    float canvasH, canvasW;
    Paint paint;
    Game game;
    Timer soundTimer;
    Handler repaintHandler;
    MediaPlayer mp;
    boolean riverPlaying, roadPlaying, vicPlaying;


    public RoadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        game = new Game();
        this.setOnTouchListener(this);
        soundTimer = new Timer();
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);

//        road= MediaPlayer.create(context, R.raw.road);
//        river = MediaPlayer.create(context, R.raw.river);
//        victory = MediaPlayer.create(context,R.raw.victory);
//        frogDrowned = MediaPlayer.create(context, R.raw.);
//        road.start();
        mp = BGM.play(context,"ROAD");
        roadPlaying = true;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        canvasH = canvas.getHeight();
        canvasW = canvas.getWidth();
        /*
        // line showing UP DOWN LEFT RIGHT region
        // uncomment this to see the control regions

        Paint paintGuidedLine = new Paint();
        paintGuidedLine.setStrokeWidth(10);
        paintGuidedLine.setColor(Color.RED);
        // upper line
        canvas.drawLine(0,canvasH * 0.35f,canvasW, canvasH * 0.35f, paintGuidedLine);
        // lower line
        canvas.drawLine(0,canvasH * 0.65f,canvasW, canvasH * 0.65f, paintGuidedLine);
        // left right line
        canvas.drawLine(0.5f * canvasW,canvasH * 0.35f,0.5f * canvasW,canvasH * 0.65f,paintGuidedLine);
        */
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

        /*if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {

            game.touch(checkRegion(userX, userY));
        }*/

        if (Game.currentPlace == "ROAD") {
            if (!roadPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(), "ROAD");
                mp.start();
            }
            if (riverPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(),"ROAD");
                mp.start();
            }

        } else if (Game.currentPlace == "RIVER") {
            if (roadPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(), "RIVER");
                mp.start();
                roadPlaying = false;
                riverPlaying = true;
            }
        }
        else if (Game.currentPlace == "VIC") {
            if (riverPlaying) {
                BGM.stopPlaying(mp);
                mp = BGM.play(this.getContext(), "VIC");
                mp.start();
            }

        }

        System.out.println(Game.currentPlace);

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
//        if (game.hasWon() || game.carHit()) {
//           /* Context context = this.getContext();
//            while (!(context instanceof GameActivity))
//                context = ((GameActivity) context).getBaseContext();
//            ((GameActivity) context).endActivity(game.hasWon() ? "You Win !!" : "You Lost :(");*/
////            notifyGameOver();
//            return false;
//        }
        this.invalidate();
        return true;
    }

    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, RoadView.STEPDELAY);
        }
    }
}
