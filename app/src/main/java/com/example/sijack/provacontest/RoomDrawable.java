package com.example.sijack.provacontest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by Sijack on 23/01/2018.
 */

public class RoomDrawable extends View {

    private float x, y, w, h;
    private Paint stroke;
    private final float STROKE_WIDTH = 10;

    public RoomDrawable(Context context, int x, int y, int w, int h, int screenw, int screenh) {
        super(context);

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        setWillNotDraw(false);
        setMinimumHeight(screenh);
        setMinimumWidth(screenw);

        stroke = new Paint();
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setColor(Color.RED);
        stroke.setStrokeWidth(STROKE_WIDTH);

    }

    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        canvas.drawRect(x, y, x+w, y+h, stroke);

        Bitmap marker = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
        int markerd = marker.getWidth();


        canvas.drawBitmap(marker, x+(w/2)-(markerd/2), y+(h/2)-(markerd/2), null);

        Log.d("DEBUG", "ondraw " + marker.getWidth());
    }
/*
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(getSuggestedMinimumWidth(),getSuggestedMinimumHeight());

        Log.d("DEBUG", "onmeasure, " + getSuggestedMinimumWidth() + ", " + getSuggestedMinimumHeight());

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int smw = getSuggestedMinimumWidth();
        int smh = getSuggestedMinimumHeight();
        setMeasuredDimension(getMeasuredWidth(),getMeasuredHeight());
        Log.d("DEBUG", "onlayout" + getMeasuredWidth() + ", " + getMeasuredHeight());

    }
    */
}
