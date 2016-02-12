package com.example.ethan.devicelist;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SensorInfo extends AppCompatActivity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_info);
        Bundle extras = getIntent().getExtras();
        int position = 0;
        if (extras != null) {
            position = Integer.parseInt(extras.getString("position"));
        }

        SensorManager mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        Iterator<Sensor> iSense = sensorList.iterator();
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        // Loop to get each sensor
        while (iSense.hasNext())
        {
            Sensor s = iSense.next();
            sensors.add(s);
        }

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("Name: " + String.valueOf(sensors.get(position).getName()));

        TextView type = (TextView) findViewById(R.id.type);
        type.setText("Type: " + String.valueOf(sensors.get(position).getType()));

        TextView power = (TextView) findViewById(R.id.power);
        power.setText("Power: " + Float.toString(sensors.get(position).getPower()));

        TextView version = (TextView) findViewById(R.id.version);
        version.setText("Version: " + String.valueOf(sensors.get(position).getVersion()));


    }

}