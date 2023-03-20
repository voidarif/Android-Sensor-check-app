package com.nexthopetech.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class sensor_list extends AppCompatActivity implements SensorEventListener {

    TextView listOfSensors;

    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        listOfSensors = findViewById(R.id.list_Of_Sensors);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
        /*for (Sensor sensor : sensors) {
            //Log.d("Sensors", "" + sensor.getName());
           // listOfSensors.append(sensor.getName());
            listOfSensors.setText(sensor.getName());
        }*/

        for (int i = 0; i < sensors.size(); i ++){
            listOfSensors.append(sensors.get(i).getName());
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}