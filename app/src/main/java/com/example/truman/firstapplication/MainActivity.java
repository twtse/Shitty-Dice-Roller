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

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        */

        //Defines TextViews and EditTexts
        final TextView diceOutput=(TextView) findViewById(R.id.diceOutputTextView);
        final TextView diceResult=(TextView) findViewById(R.id.diceResultTextView);
        final EditText diceInput=(EditText) findViewById(R.id.diceInputEditText);

        //Defines the ROLL button
        Button diceRoll=(Button) findViewById(R.id.diceRollButton);
        diceRoll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                int nDice=0, nSides=0;

                //Turns input into a string
                String input= diceInput.getText().toString();

                String temp="0";
                boolean d=false;

                /*Parses through input and saves numbers before 'd' as nDice
                saves numbers after 'd' as nSides*/
                for(int i=0;i<input.length(); i++){

                    //Checks for 'd' input. Saves prior input as nDice
                    if(input.charAt(i)=='d'){
                        d=true;
                        i++;
                        nDice=Integer.parseInt(temp);
                        temp="0";
                    }

                    //Checks for invalid input, breaks loop and sends error to user
                    else if(!Character.isDigit(input.charAt(i))){
                        d=false;
                        break;
                    }

                    //Stores latest number in string temp
                    temp+=input.charAt(i);
                }

                //Sends eror to user upon invalid input
                if(!d){
                    diceOutput.setText("Invalid input!\n (#ofDice)d(#ofSides)");
                }


                else{

                    //Saves digits after 'd' as nSides
                    nSides=Integer.parseInt(temp);


                    Random random=new Random();

                    int[] results=new int[nDice];
                    int total=0;
                    int roll;
                    String diceHistory="[";
                    //Generates random numbers, saves results in array and sums total
                    for(int i=0; i<nDice;i++){
                        roll=random.nextInt(nSides)+1;
                        results[i]=roll;
                        diceHistory+=(roll+", ");
                        total+=results[i];
                    }

                    // Remove the last comma and following space from the dice history
                    diceHistory = diceHistory.substring(0, diceHistory.length() - 2);

                    diceHistory+=("]");
                    //Output the total
                    diceOutput.setText(String.valueOf(total));
                    diceResult.setText(diceHistory);

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
