package com.example.xinyuan.comp2100_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RoadView extends View {

    public RoadView(Context context,AttributeSet attrs) {
        super(context, attrs);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paintBG = new Paint();
        paintBG.setColor(Color.BLUE);
        paintBG.setStrokeWidth(600);
        canvas.drawLine(0,450,canvas.getWidth(),450,paintBG);
    }

}
