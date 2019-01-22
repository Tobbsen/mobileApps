package com.example.pvl;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        final List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        final ListView list_sensor = (ListView) findViewById(R.id.list_sensor);

        list_sensor.setAdapter(new SensorAdapter(this, R.layout.sensor_layout, sensors));

        list_sensor.setClickable(true);
        list_sensor.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
               // Log.e("SAMSUNG", Integer.toString(position));

                Intent singleSensor = new Intent(list_sensor.getContext(), SingleSensorActivity.class);
                //singleSensor.putExtra("Value", sensorText.getText().toString());
                singleSensor.putExtra("Name", sensors.get(position).getName());
                singleSensor.putExtra("Vendor", sensors.get(position).getVendor());
                singleSensor.putExtra("Resolution", Float.toString(sensors.get(position).getResolution()));

                startActivity(singleSensor);

            }
        });
    }

}


