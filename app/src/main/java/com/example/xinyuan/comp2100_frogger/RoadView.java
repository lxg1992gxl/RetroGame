package com.example.xinyuan.comp2100_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class RoadView extends View implements View.OnTouchListener, Runnable {

    float canvasH, canvasW;
    Paint paint;
    Game game;

    public RoadView(Context context,AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        game = new Game();
        this.setOnTouchListener(this);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasH = canvas.getHeight();
        canvasW = canvas.getWidth();
        System.out.println("Height is " + canvasH);
        System.out.println("2/3 Height is " + (2 * canvasH / 3));

        Paint paintBG = new Paint();
        paintBG.setColor(Color.BLUE);
        paintBG.setStrokeWidth(450);
        canvas.drawLine(0,525,canvas.getWidth(),525,paintBG);


        // line showing UP DOWN LEFT RIGHT
        paintBG.setStrokeWidth(10);
        paintBG.setColor(Color.RED);
        canvas.drawLine(0.5f* canvasW,canvasH / 3,0.5f * canvasW, (2 * canvasH / 3),paintBG);
        canvas.drawLine(0,canvasH / 3,canvasW,canvasH/3,paintBG);
        paintBG.setColor(Color.GREEN);
        canvas.drawLine(0,((2 * canvasH / 3)),canvasW,((2 * canvasH / 3)),paintBG);


        game.draw(canvas,paint);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float userX = event.getX();
        float userY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            game.touch(checkRegion(userX,userY));
        }
        invalidate();
        return true;
    }

    private String checkRegion(float x, float y) {
        if (x <= canvasW && x >= 0 && y <= canvasH / 3) {
            return "GOUP";
        }
        else if (x <= canvasW && x >= 0 && y >= 2 * canvasH / 3) {
            return "GODOWN";
        }
        else if (x <= 0.5 * canvasW && x >= 0 && y < 2 * canvasH / 3 && y > canvasH / 3) {
            return "GOLEFT";
        }
        else {
           return "GORIGHT";
        }
    }

    @Override
    public void run() {

    }
}
