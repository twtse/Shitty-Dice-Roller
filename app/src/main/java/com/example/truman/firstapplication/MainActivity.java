package com.example.truman.firstapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button diceRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        final TextView diceOutput=(TextView) findViewById(R.id.diceOutputTextView);
        final EditText diceInput=(EditText) findViewById(R.id.diceInputEditText);

        Button diceRoll=(Button) findViewById(R.id.diceRollButton);
        diceRoll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int nDice=0, nSides=0;
                String input= diceInput.getText().toString();
                String temp="0";
                boolean d=false;
                for(int i=0;i<input.length(); i++){

                    if(input.charAt(i)=='d'){
                        d=true;
                        i++;
                        nDice=Integer.parseInt(temp);
                        temp="0";
                    }

                    temp+=input.charAt(i);
                }
                nSides=Integer.parseInt(temp);
                if(!d){
                    diceOutput.setText("Invalid input!\n (#ofDice)d(#ofSides)");
                }
                else{

                    Random random=new Random();

                    int[] results=new int[nDice];
                    int total=0;

                    for(int i=0; i<nDice;i++){
                        results[i]=random.nextInt(nSides)+1;
                        total+=results[i];

                    }
                    diceOutput.setText(String.valueOf(total));


                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
