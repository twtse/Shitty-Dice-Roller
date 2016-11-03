package com.example.truman.firstapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Settings {

    private OutputStream output;
    private InputStream input;
    private String filename="Settings.txt";
    private Properties sProperties;
    private File settingsFile;

   public Settings(){
       sProperties=new Properties();
       settingsFile=new File(filename);
       //initialize();
   }

    /*Loads settings from file, creates new file if not yet created*/
    public boolean initialize(){

        try{
            if(settingsFile.createNewFile()){
                output= new FileOutputStream(filename);
                setDefault();

            }

            else{
                input= new FileInputStream(filename);
                output= new FileOutputStream(filename);
                //sProperties.load(input);
                setDefault();
            }
        }

        catch (IOException io){
            System.out.print("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println(io.getMessage());
            return false;
        }
        return true;
    }

    public boolean setOn(String setting){
        try{
            sProperties.setProperty(setting, "ON");
            sProperties.store(output,"");
            return true;
        }
        catch(IOException io){
            return false;
        }
    }

    public boolean setOff(String setting){
        try{
            sProperties.setProperty(setting, "OFF");
            sProperties.store(output,"");
            return true;
        }
        catch(IOException io){
            return false;
        }
    }

    /* Takes a setting and returns whether or not the setting is on or off*/
    public boolean get(String setting){

        return sProperties.getProperty(setting, "OFF").equals("ON");

    }
    /* Creates keys for all settings with default value "OFF"*/
    private void setDefault(){

        sProperties.setProperty("dicePool", "OFF");

    }
}
