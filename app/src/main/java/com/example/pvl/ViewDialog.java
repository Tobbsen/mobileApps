package com.example.pvl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.security.AccessController.getContext;

public class ViewDialog {

    public void showDialog(final Activity activity, String mode){


        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);

        // basic dialog
        if(mode != "" && mode == "D"){

            dialog.setContentView(R.layout.dialog_layout);

            final ImageView img = (ImageView) dialog.findViewById(R.id.img_dialog);

            img.setImageResource(R.drawable.img_1);


            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    img.setImageResource(R.mipmap.ic_launcher);

                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageResource(R.drawable.img_1);
                        }
                    }, 10000);

                }
            });

        //contacts dialog
        } else if(mode != "" && mode == "C"){
            dialog.setContentView(R.layout.dialog_contacts_layout);

            ArrayList<String> contacts = new ArrayList<String>();

            Cursor phones = activity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
            while (phones.moveToNext())
            {

                String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contacts.add(name + " " + phoneNumber);

            }
            phones.close();

            ListView list_contacts = (ListView) dialog.findViewById(R.id.list_contacts);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity, R.layout.contact_layout, contacts);

            list_contacts.setAdapter(arrayAdapter);

        }




        dialog.show();

    }
}
