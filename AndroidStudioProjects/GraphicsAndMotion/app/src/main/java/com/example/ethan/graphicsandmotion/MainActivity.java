//MainActivity Class, written by Ethan Honeycutt for moving ball graphic.

package com.example.ethan.graphicsandmotion;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    @Override
    //sets up view and starts onClickListeners
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BallView bView = (BallView)findViewById(R.id.canvas);

        SeekBar speed = (SeekBar)findViewById(R.id.speed);
        speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            //if slider moves, change speed
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bView.ballSpeedY = progress;
                bView.ballSpeedX = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {}
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        //red button
        Button clickButtonRed = (Button) findViewById(R.id.red);
        clickButtonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bView.color = Color.RED;
            }
        });

        //blue button
        Button clickButtonBlue = (Button) findViewById(R.id.blue);
        clickButtonBlue.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bView.color = Color.BLUE;
            }
        });

        //start/stop button
        Button clickButtonStop = (Button) findViewById(R.id.startstop);
        clickButtonStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bView.moving) {
                    bView.moving = false;
                    bView.ballX = (bView.xMax - bView.xMin)/2;
                    bView.ballY = (bView.yMax - bView.ballRadius);
                }
                else{
                    bView.moving = true;
                }
            }
        });
    }
}