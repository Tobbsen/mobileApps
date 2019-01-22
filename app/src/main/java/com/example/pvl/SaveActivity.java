package com.example.pvl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        // variables

        final EditText inputText = (EditText)findViewById(R.id.inputText);
        final TextView textNeuerText2 = (TextView)findViewById(R.id.textNeuerText2);
        TextView textShared = (TextView)findViewById(R.id.textShared);

        // Shared Preferences settings
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();

        // Fill textShared with value from shared pref first
        String storedValue = preferences.getString("text", "");
        if(!storedValue.equalsIgnoreCase(""))
        {
            textShared.setText(storedValue);
        }

        // Click Listener
        Button clickButton = (Button) findViewById(R.id.buttonSave);
        clickButton.setOnClickListener( new View.OnClickListener() {

            String text = "";

            @Override
            public void onClick(View v) {

                text = inputText.getText().toString();

                // Fill shared pref with value
                editor.putString("text", text);

                // Fill textNeuerText2 with value
                textNeuerText2.setText(text);

                editor.apply();

            }
        });


    }
}
