package com.example.truman.firstapplication;

public class DiceMacro {
    private String macro;

    public DiceMacro(String macroText){
        macro = macroText;
    }

    public String getMacro(){
        return macro;
    }

    public void setMacro(String value){
        macro = value;
    }
}
