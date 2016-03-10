//MainActivity Class, written by Ethan Honeycutt for moving ball graphic.

package com.example.ethan.graphicsandmotion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BallView extends View {

    public int xMin = 0;
    public int xMax;
    public int yMin = 0;
    public int yMax;
    public float ballRadius = 80;
    public float ballX;
    public float ballY;
    public float ballSpeedX = 10;
    public float ballSpeedY = 10;
    private RectF ballBounds;
    private Paint paint;
    public int color = Color.BLACK;
    public boolean moving = true;

    public BallView(Context context, AttributeSet attr) {
        super(context, attr);
        ballBounds = new RectF();
        paint = new Paint();
    }

    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        xMax = w-1;
        yMax = w-1;
        ballRadius = xMax/20;
        //random starting point
        ballX = xMin + (int)(Math.random() * ((xMax - xMin) + 1));
        ballY = yMin + (int)(Math.random() * ((yMax - yMin) + 1));
    }

    @Override
    //Draws the ball and court
    protected void onDraw(Canvas canvas) {

        paint.setStrokeWidth(0);
        paint.setColor(Color.LTGRAY);
        canvas.drawRect(xMin, yMin, xMax, yMax, paint);

        ballBounds.set(ballX - ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius);
        paint.setColor(color);
        canvas.drawOval(ballBounds, paint);

        //only move the ball if it is not stopped
        if(moving) {
            update();
        }
        invalidate();  // Force a re-draw
    }

    //Move ball and see if it has hit wall
    private void update() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        if (ballX + ballRadius > xMax) {
            ballSpeedX = -ballSpeedX;
            ballX = xMax-ballRadius;
        } else if (ballX - ballRadius < xMin) {
            ballSpeedX = -ballSpeedX;
            ballX = xMin+ballRadius;
        }
        if (ballY + ballRadius > yMax) {
            ballSpeedY = -ballSpeedY;
            ballY = yMax - ballRadius;
        } else if (ballY - ballRadius < yMin) {
            ballSpeedY = -ballSpeedY;
            ballY = yMin + ballRadius;
        }
    }
}