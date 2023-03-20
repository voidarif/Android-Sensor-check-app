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

public class light_sensor extends AppCompatActivity implements SensorEventListener {

    TextView light_sensor_text;

    private SensorManager sm;
    private Sensor s;
    private List<Sensor> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        light_sensor_text = findViewById(R.id.light_sensor_text);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(s == null){
            light_sensor_text.setText("Light sensor not found !");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float currentValue = sensorEvent.values[0];
        light_sensor_text.setText(String.valueOf(currentValue +" Lux"));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (s != null) {
            sm.registerListener(this, s, 1/2);
        }
    }
}