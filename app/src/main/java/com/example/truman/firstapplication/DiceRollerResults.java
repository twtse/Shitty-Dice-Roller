package com.example.truman.firstapplication;

public class DiceRollerResults{
    private int[] rolls;
    private int rollTotal;

    public DiceRollerResults(int[] rolls){
        this.rolls = rolls;
    }

    public int getTotal() {
        if(rollTotal > 0){
            return rollTotal;
        }

        int total = 0;
        for(int roll : rolls){
            total += roll;
        }

        rollTotal = total;
        return total;
    }

    public String getRolls(){
        String output = "[";
        for(int roll : rolls){
            output += String.valueOf(roll);
            output += ", ";
        }

        // Remove the last comma and following space from the dice history
        output = output.substring(0, output.length() - 2);

        output += "]";

        return output;
    }

    public static int addResults(DiceRollerResults r1, DiceRollerResults r2){
        return r1.getTotal() + r2.getTotal();
    }
}
