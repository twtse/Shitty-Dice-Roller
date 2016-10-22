package com.example.truman.firstapplication;

import java.security.InvalidParameterException;
import java.util.Random;

public class DiceRoller {

    public static DiceRollerResults roll(String inputString){
        int nDice=0, nSides=0;

        String temp="0";
        boolean d=false;

                /*Parses through input and saves numbers before 'd' as nDice
                saves numbers after 'd' as nSides*/
        for(int i=0;i<inputString.length(); i++){

            //Checks for 'd' input. Saves prior input as nDice
            if(inputString.charAt(i)=='d'){
                d=true;
                i++;
                nDice=Integer.parseInt(temp);
                temp="0";
            }

            //Checks for invalid input, breaks loop and sends error to user
            else if(!Character.isDigit(inputString.charAt(i))){
                d=false;
                break;
            }

            //Stores latest number in string temp
            if(i < inputString.length()) {
                temp += inputString.charAt(i);
            }
            else{
                // Edge case where entering "nd"
                // i++ could jump to an invalid index and try to add a null character
                throw new InvalidParameterException("Invalid input!\n (#ofDice)d(#ofSides)");
            }
        }

        //Sends eror to user upon invalid input
        if(!d){
            throw new InvalidParameterException("Invalid input!\n (#ofDice)d(#ofSides)");
        }
        else{
            //Saves digits after 'd' as nSides
            nSides=Integer.parseInt(temp);

            Random random=new Random();

            int[] results=new int[nDice];
            int roll;
            //Generates random numbers, saves results in array and sums total
            for(int i=0; i<nDice;i++){
                roll=random.nextInt(nSides)+1;
                results[i]=roll;
            }

            return new DiceRollerResults(results);
        }
    }
}
