package com.example.pvl;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SingleSensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_sensor);
        Intent myIntent = getIntent(); // gets the previously created intent
        String vendor = myIntent.getStringExtra("Vendor"); // will return "FirstKeyValue"
        String resolution = myIntent.getStringExtra("Resolution");
        //myIntent.removeExtra("Value");
        Log.e("SAMSUNG", "OPENED SingleSensorsActivity " + vendor + " " + resolution);

        TextView herstellerTV = (TextView) findViewById(R.id.textView3);
        //herstellerTV.setText(value.split("\\s+")[2]);
        herstellerTV.setText(vendor);

        TextView valueTV = (TextView) findViewById(R.id.textView5);
        valueTV.setText(resolution);
    }
}
