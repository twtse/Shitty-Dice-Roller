package com.example.truman.firstapplication;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiceRoller {
    public static DiceRollerResults roll(String inputString){
        int nDice=0, nSides=0;

        String temp="";
        boolean d=false;

                /*Parses through input and saves numbers before 'd' as nDice
                saves numbers after 'd' as nSides*/
        for(int i=0;i<inputString.length(); i++){

            //Checks for 'd' input. Saves prior input as nDice
            if(inputString.charAt(i)=='d'){
                if(d || i == inputString.length() - 1 || temp == "0" || temp == ""){
                    // Ensure that "d" doesn't occur more than once in the input string
                    throw new InvalidParameterException("Invalid input!\n (#ofDice)d(#ofSides)");
                }
                d=true;
                nDice=Integer.parseInt(temp);
                temp="";
                continue;
            }

            //Checks for invalid input, breaks loop and sends error to user
            else if(!Character.isDigit(inputString.charAt(i))){
                throw new InvalidParameterException("Invalid input!\n (#ofDice)d(#ofSides)");
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
        if(temp.length()==0){
            nSides=0;
        }
        else {
            //Saves digits after 'd' as nSides
            nSides = Integer.parseInt(temp);
        }
        //Sends eror to user upon invalid input
        if(!d||nSides==0){
            throw new InvalidParameterException("Invalid input!\n (#ofDice)d(#ofSides)");
        }
        else{
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
