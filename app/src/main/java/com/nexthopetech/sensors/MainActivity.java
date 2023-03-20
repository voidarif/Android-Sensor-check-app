package com.nexthopetech.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sensorlist_Btn, gravityReading_btn, lightsSensor_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorlist_Btn = findViewById(R.id.sensorList_btn);
        gravityReading_btn = findViewById(R.id.gravityReading_btn);
        lightsSensor_btn = findViewById(R.id.lightsSensor_btn);

        sensorlist_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, sensor_list.class);
                startActivity(intent);
            }
        });

        gravityReading_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, gravity_sensor.class);
                startActivity(intent);
            }
        });
        lightsSensor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, light_sensor.class);
                startActivity(intent);
            }
        });
    }
}