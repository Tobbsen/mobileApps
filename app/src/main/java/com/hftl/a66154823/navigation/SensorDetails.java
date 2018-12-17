package com.hftl.a66154823.navigation;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class SensorDetails extends Activity {

    RadioGroup dynSensors;
    Button btnexit;
    SensorManager sMgr;
    TextView SensorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_details);
        btnexit = (Button) findViewById(R.id.close);
        dynSensors = (RadioGroup) findViewById(R.id.groupRadio);
        sMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> deviceSensors = sMgr.getSensorList(Sensor.TYPE_ALL);
        SensorText = (TextView) findViewById(R.id.textSensor);

        //find name of Sensor or ID
        int selectedSensorID = dynSensors.getCheckedRadioButtonId();
        Sensor selectedS =  deviceSensors.get(selectedSensorID);
        SensorText.setText(selectedS.toString());



        btnexit.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            finish();
        }});


    }


}
