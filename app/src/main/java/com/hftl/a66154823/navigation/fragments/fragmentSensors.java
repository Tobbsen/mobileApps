package com.hftl.a66154823.navigation.fragments;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hftl.a66154823.navigation.R;
import com.hftl.a66154823.navigation.SensorDetails;

import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Belal on 18/09/16.
 */


public class fragmentSensors extends Fragment{

    private SensorManager sMgr;
    Sensor selectedS;
    TextView sensorDetails;
    TextView sensorListValue;
    TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_sensors, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Sensors");
        text =  view.findViewById(R.id.stext);
        sensorListValue = view.findViewById(R.id.textView);
        sensorDetails = view.findViewById(R.id.textSensor);
        final RadioGroup dynSensors = view.findViewById(R.id.groupRadio);
        sMgr = (SensorManager)getContext().getSystemService(SENSOR_SERVICE);
        final List<Sensor> deviceSensors = sMgr.getSensorList(Sensor.TYPE_ALL);
        String sensorText = "";
        int y = 0;
        for(Sensor x:deviceSensors){
            RadioButton rbn = new RadioButton(this.getContext());
            rbn.setId(y);
            rbn.setText(x.getName());
            dynSensors.addView(rbn);
            y++;
        }
        dynSensors.setOrientation(LinearLayout.VERTICAL);

        dynSensors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedSensorID = dynSensors.getCheckedRadioButtonId();
                selectedS =  deviceSensors.get(selectedSensorID);
                //sensorListValue.setText(selectedS.getName()+"\n"+selectedS.getStringType());


                //save the Sensor name in the Actions xml:
                text.setText(selectedS.toString());
                System.out.println("test: "+selectedS);
                /*
                Intent intent = new Intent(getActivity(), SensorDetails.class);
                fragmentSensors.this.startActivity(intent);*/
        }
        });
        }
}
