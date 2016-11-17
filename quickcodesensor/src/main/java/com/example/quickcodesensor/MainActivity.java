package com.example.quickcodesensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    public TextView txt_Gravity;
    public TextView txt_Accel;
    public TextView txt_LAccel;
    public TextView txt_Gyro;

    public SensorManager mSensorManager;
    public Sensor sGravity;
    public Sensor sAccel;
    public Sensor sLAccel;
    public Sensor sGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sAccel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sLAccel = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sGyro = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        txt_Gravity = (TextView) findViewById(R.id.txt_Gravity);
        txt_Accel = (TextView) findViewById(R.id.txt_Accel);
        txt_LAccel = (TextView) findViewById(R.id.txt_LinAccel);
        txt_Gyro = (TextView) findViewById(R.id.txt_Gyro);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, sGravity, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sAccel, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sLAccel, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sGyro, SensorManager.SENSOR_DELAY_NORMAL);
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
        switch (event.sensor.getType()){
            case Sensor.TYPE_GRAVITY:
                txt_Gravity.setText(String.format("%.2f", event.values[0])  + ", " + String.format("%.2f", event.values[1]) + ", " + String.format("%.2f", event.values[2]));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                txt_Accel.setText(String.format("%.2f", event.values[0])  + ", " + String.format("%.2f", event.values[1]) + ", " + String.format("%.2f", event.values[2]));
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                txt_LAccel.setText(String.format("%.2f", event.values[0])  + ", " + String.format("%.2f", event.values[1]) + ", " + String.format("%.2f", event.values[2]));
                break;
            case Sensor.TYPE_GYROSCOPE:
                txt_Gyro.setText(String.format("%.2f", event.values[0])  + ", " + String.format("%.2f", event.values[1]) + ", " + String.format("%.2f", event.values[2]));
                break;
        }
    }
}
