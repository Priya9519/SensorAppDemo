package com.example.priya.sensorappdemo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.View;

/**
 * Created by priya on 28/9/17.
 */

public class AnimateView extends View {
    private static final int CIRCLE_RADIUS = 15;
    private Paint paint;
    private int x;
    private int y;
    private int vWidth;
    private int vHeight;
//parameterised  constructor of class
    public AnimateView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        vWidth = w;
        vHeight = h;
    }
    // change condition and set position of object
    public void onSensorEvent (SensorEvent event) {
        x = x - (int) event.values[0];
        y = y + (int) event.values[1];
        if (x <= 0 + CIRCLE_RADIUS) {
            x = 0 + CIRCLE_RADIUS;
        }
        if (x >= vWidth - CIRCLE_RADIUS) {
            x = vWidth - CIRCLE_RADIUS;
        }
        if (y <= 0 + CIRCLE_RADIUS) {
            y = 0 + CIRCLE_RADIUS;
        }
        if (y >= vHeight - CIRCLE_RADIUS) {
            y = vHeight - CIRCLE_RADIUS;
        }
    }
    //draw circle
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, y, CIRCLE_RADIUS, paint);
        invalidate();
    }
}
