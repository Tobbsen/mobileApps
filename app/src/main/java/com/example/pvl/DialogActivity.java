package com.example.pvl;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewDialog alert = new ViewDialog();
        alert.showDialog(this, "D");

    }


}
