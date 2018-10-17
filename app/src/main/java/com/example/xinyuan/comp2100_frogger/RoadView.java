package com.example.xinyuan.comp2100_frogger;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class RoadView extends View implements View.OnTouchListener, Runnable {
    public static final int STEPDELAY = 100;
    float canvasH, canvasW;
    Paint paint;
    Game game;
    Handler repaintHandler;
    ArrayList<GameOver> observers;
    public static Bitmap carImage;
    public static Bitmap riverImage;
    public static Bitmap woodImage;

    public RoadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        game = new Game();
        this.setOnTouchListener(this);
        observers = new ArrayList<>();
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);
        carImage = BitmapFactory.decodeResource(getResources(),R.drawable.car);
        riverImage = BitmapFactory.decodeResource(getResources(), R.drawable.river);
        woodImage = BitmapFactory.decodeResource(getResources(), R.drawable.wood);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasH = canvas.getHeight();
        canvasW = canvas.getWidth();
        game.draw(canvas, paint);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float userX = event.getX();
        float userY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            userX = event.getX();
            userY = event.getY();
            game.touch(checkRegion(userX, userY));
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

    // step the view forward by one step - true is returned if more steps to go
    public boolean step() {
        game.step();
        if(game.lives.lives==0){
            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }


    private void notifyGameOver(){
        for (GameOver o: observers) o.gameOver();
    }


    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, RoadView.STEPDELAY);
        }
    }

    public void registerGameOver(GameOver o){
        observers.add(o);
    }

}
