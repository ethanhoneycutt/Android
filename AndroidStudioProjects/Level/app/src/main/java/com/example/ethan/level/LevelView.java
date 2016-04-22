/**
 * Created by Ethan on 4/11/2016.
 * LevelView is the dynamic view that displays all information and objects
 */
package com.example.ethan.level;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class LevelView extends View
{
    float x;
    float y;
    float z;
    int width;
    int height;

    public LevelView(Context context) {
        super(context);

    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, width, height, paint);
        paint.setTextSize(60);
        int radius=40;

        paint.setColor(Color.LTGRAY);
        canvas.drawRoundRect(new RectF(50, 50, width - 50, 150), 35, 35, paint);
        canvas.drawRoundRect(new RectF(50, 200, 150, width + 100), 35, 35, paint);
        canvas.drawCircle(100 + (width - 100) / 2, 100 + (width - 100) / 2, (width - 250) / 2, paint);

        float ballx;
        float bally;

        if(Math.round(x / 10 * 90) < 10 && Math.round(x / 10 * 90) > -10){
            paint.setColor(Color.GREEN);
        }
        else{
            paint.setColor(Color.RED);
        }
        ballx=100 + (x+10)/20*(width - 200);
        bally=100;
        canvas.drawCircle(ballx, bally, radius, paint);
        canvas.drawText(Integer.toString(Math.round(x / 10 * 90)), 250, width + 25, paint);
        canvas.drawText("X", 250, width + 75, paint);

        if(Math.round(y / 10 * 90) < 10 && Math.round(y / 10 * 90) > -10){
            paint.setColor(Color.GREEN);
        }
        else{
            paint.setColor(Color.RED);
        }
        ballx=100;
        bally=250 + (-y+10)/20*(width - 200);
        canvas.drawCircle(ballx, bally, radius, paint);
        canvas.drawText(Integer.toString(Math.round(y / 10 * 90)), 375, width + 25, paint);
        canvas.drawText("Y", 375, width + 75, paint);

        if(Math.round(x / 10 * 90) < 10 && Math.round(x / 10 * 90) > -10 && Math.round(y / 10 * 90) < 10 && Math.round(y / 10 * 90) > -10){
            paint.setColor(Color.GREEN);
        }
        else{
            paint.setColor(Color.RED);
        }
        ballx=width-310 + x/12*(width-250)/2;
        bally=width-310 + -y/12*(width-250)/2;
        canvas.drawCircle(ballx, bally, radius, paint);

        if(Math.round(z / 10 * 90) < -85 || Math.round(z / 10 * 90) > 85){
            paint.setColor(Color.GREEN);
        }
        else{
            paint.setColor(Color.RED);
        }
        canvas.drawText(Integer.toString(Math.round(z/10*90)), 500, width + 25, paint);
        canvas.drawText("Z", 500, width + 75, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);

        ballx=100 + (width - 100) / 2;
        bally=100 + (width - 100) / 2;
        canvas.drawCircle(ballx, bally, radius, paint);
        ballx=100 + (width - 200)/2;
        bally=100;
        canvas.drawCircle(ballx,bally, radius, paint);
        ballx=100;
        bally=250 + (width - 200)/2;
        canvas.drawCircle(ballx,bally, radius, paint);

        paint.setColor(Color.WHITE);
        canvas.drawText("Level Angles (Degrees)", 75, width + 200, paint);
    }

}