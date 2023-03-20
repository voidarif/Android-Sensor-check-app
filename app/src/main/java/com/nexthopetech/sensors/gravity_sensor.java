package com.nexthopetech.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class gravity_sensor extends AppCompatActivity implements SensorEventListener {

    TextView gravity_write_text;

    private SensorManager sm;
    private  Sensor s;
    private List <Sensor> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity_sensor);

        gravity_write_text = findViewById(R.id.gravity_write_text);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        s = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);

        if(s == null){
            gravity_write_text.setText("Gravity sensor not found !");
        }

        sm.registerListener(this, s, 1);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float currentValue = sensorEvent.values[0];
        gravity_write_text.setText(String.valueOf(currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (s != null) {
            sm.registerListener(this, s, 1);
        }
    }
}