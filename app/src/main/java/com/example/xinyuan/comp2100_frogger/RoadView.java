package com.example.xinyuan.comp2100_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RoadView extends View {

    Paint paint;
    Game game;

    public RoadView(Context context,AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        game = new Game();

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint paintBG = new Paint();
//        paintBG.setColor(Color.BLUE);
//        paintBG.setStrokeWidth(600);
//        canvas.drawLine(0,500,canvas.getWidth(),500,paintBG);
//        canvas.drawCircle(100,800,16,paint);
        game.draw(canvas,paint);
    }

}
