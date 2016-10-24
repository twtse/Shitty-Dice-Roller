package com.example.truman.firstapplication;

import android.content.Intent;
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

import java.security.InvalidParameterException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button diceRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Defines TextViews and EditTexts
        final TextView diceOutput=(TextView) findViewById(R.id.diceOutputTextView);
        final TextView diceResult=(TextView) findViewById(R.id.diceResultTextView);
        final EditText diceInput=(EditText) findViewById(R.id.diceInputEditText);

        //Defines the ROLL button
        Button diceRoll=(Button) findViewById(R.id.diceRollButton);

        final Button ShadowrunButton=(Button) findViewById(R.id.ShadowrunButton);

        ShadowrunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShadowrunButton.getText().toString().equals("OFF")) {
                    ShadowrunButton.setText("ON");
                }
                else{
                    ShadowrunButton.setText("OFF");
                }

            }
        });

        diceRoll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            try{

                DiceRollerResults results = DiceRoller.roll(diceInput.getText().toString());

                if(ShadowrunButton.getText().toString().equals("ON")){
                    String temp = String.valueOf(results.getHits());
                    temp+= " Hits";
                    if(results.isGlitch()){
                        temp+= "(GLITCH)";
                    }
                    diceOutput.setText(temp);
                    diceResult.setText(results.getRolls());
                }
                else{
                    diceOutput.setText(String.valueOf(results.getTotal()));
                    diceResult.setText(results.getRolls());
                }

            }
            catch(InvalidParameterException ex){
                diceOutput.setText(ex.getMessage());
                diceResult.setText("");
            }
            }

        });

        //Defines numerical buttons
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button4);
        Button button5=(Button) findViewById(R.id.button5);
        Button button6=(Button) findViewById(R.id.button6);
        Button button7=(Button) findViewById(R.id.button7);
        Button button8=(Button) findViewById(R.id.button8);
        Button button9=(Button) findViewById(R.id.button9);
        Button button0=(Button) findViewById(R.id.button0);
        Button buttonD=(Button) findViewById(R.id.buttonD);
        Button buttonDelete=(Button) findViewById(R.id.buttonDelete);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput=diceInput.getText().toString();
                diceInput.setText(currInput+=1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 6);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 8);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 9);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 0);
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                diceInput.setText(currInput += 'd');
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currInput = diceInput.getText().toString();
                if(currInput.length()!=0&&currInput!=null){
                    diceInput.setText(currInput.substring(0,currInput.length()-1));
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
            TextView diceOutput=(TextView) findViewById(R.id.diceOutputTextView);
            diceOutput.setText("*Settings Open*");
            startActivity(new Intent(MainActivity.this, Settings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
