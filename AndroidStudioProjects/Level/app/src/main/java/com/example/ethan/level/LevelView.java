package com.example.ethan.level;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Ethan on 4/11/2016.
 */
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
        paint.setTextSize(20);
        canvas.drawText(Float.toString(Math.round(x/10*90)), 10, 25, paint);
        canvas.drawText(Float.toString(Math.round(y/10*90)), 10, 50, paint);
        canvas.drawText(Float.toString(Math.round(z/10*90)), 10, 75, paint);

        float ballx=(x+10)/20*width;
        float bally=height - (y+10)/20*height;
        int radius=15;
        canvas.drawCircle(ballx,bally, radius, paint);
    }

}