/**
 * Created by Ethan on 4/11/2016.
 * MainActivity listens to the accelerometer and updates the view accordingly
 */
package com.example.ethan.level;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public SensorManager mSensorManager;
    public Sensor mAccelerometer;
    LevelView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create the view with ball and numbers
        view = new LevelView(this);
        setContentView(view);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //create sensor objects
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //get size of display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        view.width = size.x;
        view.height = size.y;
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        //when accelerometer values change, redraw the view
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;
        view.x=(event.values[0]);
        view.y=(event.values[1]);
        view.z=(event.values[2]);

        view.invalidate();
    }
}
