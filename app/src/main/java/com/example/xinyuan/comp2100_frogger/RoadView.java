package com.example.xinyuan.comp2100_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class RoadView extends View implements View.OnTouchListener, Runnable {
    public static final int STEPDELAY = 100;
    float canvasH, canvasW;
    Paint paint;
    Game game;
    Handler repaintHandler;

    public RoadView(Context context,AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        game = new Game();
        this.setOnTouchListener(this);
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

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
        game.draw(canvas,paint);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float userX = event.getX();
        float userY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            game.touch(checkRegion(userX,userY));
//            System.out.println();
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
        }
        else {
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
