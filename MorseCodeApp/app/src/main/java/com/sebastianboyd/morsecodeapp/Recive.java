package com.sebastianboyd.morsecodeapp;


import android.widget.Toast;

public class Recive extends MyActivity{
    private String test = "dot";
    private String test2 = "dash";

    public void bDot(){
        Toast.makeText(this, test, Toast.LENGTH_SHORT).show();

    }
    public void bDash(){
        Toast.makeText(this, test2, Toast.LENGTH_SHORT).show();


    }



}
