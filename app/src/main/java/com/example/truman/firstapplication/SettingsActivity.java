package com.example.truman.firstapplication;


import android.content.Context;
import android.content.SharedPreferences;
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

    String dicePool= "dicePool";

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final SharedPreferences settings = getSharedPreferences
                ("com.example.TabletopCompanion.settings",0);

        final SharedPreferences.Editor editor = getSharedPreferences
                ("com.example.TabletopCompanion.settings",0).edit();

        final Button ShadowrunButton=(Button) findViewById(R.id.ShadowrunButton);
        if(settings.getBoolean(dicePool, false)){
            ShadowrunButton.setText("ON");
        }
        else{
            ShadowrunButton.setText("OFF");
        }
        ShadowrunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(settings.getBoolean(dicePool,false));
                if (settings.getBoolean(dicePool,false)) {
                    System.out.println("Turning Off");
                    editor.putBoolean(dicePool, false);
                    editor.commit();
                    ShadowrunButton.setText("OFF");
                }
                else{
                    System.out.println("Turning On");
                    editor.putBoolean(dicePool, true);
                    editor.commit();
                    ShadowrunButton.setText("ON");
                }
            }
        });
    }


}
