package com.example.truman.firstapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class SettingsActivity extends AppCompatActivity {

    Settings settings=new Settings();

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        final Button ShadowrunButton=(Button) findViewById(R.id.ShadowrunButton);
        if(settings.get("dicePool")){
            ShadowrunButton.setText("ON");
        }
        else{
            ShadowrunButton.setText("OFF");
        }
        ShadowrunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(settings.get("dicePool")){
                    ShadowrunButton.setText("OFF");
                    settings.setOff("dicePool");
                }
                else{
                    ShadowrunButton.setText("ON");
                    settings.setOn("dicePool");
                }

            }
        });
    }


}
