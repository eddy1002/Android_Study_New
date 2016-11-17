package com.example.quickcodepedometer;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    public TextView txt_Main;

    public SensorManager mSensorManager;
    public Sensor sAccel;

    public int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_Main = (TextView) findViewById(R.id.txt_Main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sAccel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, sAccel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    public void onSensorChanged(SensorEvent event){
        double speed = 0.0f;
        double gravity = 9.8f;
        int dir_UP = 0; int dir_DOWN = 0;

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            speed = Math.sqrt(x*x + y*y + z*z);
        }

        if (speed - gravity > 5){
            dir_UP = 1;
        }

        if (dir_UP == 1 && speed - gravity > 5){
            dir_DOWN = 1;
        }

        if (dir_DOWN == 1){
            step++;
            txt_Main.setText(step + "걸음");
            dir_UP = 0;
            dir_DOWN = 0;
        }
    }
}
