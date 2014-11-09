package com.sebastianboyd.morsecodeapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.hardware.Camera;
import java.util.*;
import android.view.WindowManager;
import android.view.MenuItem;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import android.widget.*;
import android.view.inputmethod.*;


public class MyActivity extends Activity {

    Map Morse = new HashMap();
    private EditText userInput;
    private int dash = 800;
    private int dot = 200;
    private int space = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        makeMap();


    }
    public void onDoneButtonClick(View view){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }
    public String[] binaryConvert(String response){
        response = response.toLowerCase(); //making the array lower case
        String[] responseArray = response.split(""); //spitting the response array
        int num = 1;
        String working;
        String[] binaryArray = new String[responseArray.length - 1]; //new string array
        String originalPrint = Arrays.toString(responseArray); //turning array into string
        Toast.makeText(this, originalPrint, Toast.LENGTH_SHORT).show(); //printing array one screen
        while (num < responseArray.length){ //while loop
            working = responseArray[num];
            binaryArray[num - 1] = (String) Morse.get(responseArray[num]);
            num++;
        }
        String printResponse = Arrays.toString(binaryArray);
        Toast.makeText(this, printResponse, Toast.LENGTH_SHORT).show();
        return binaryArray;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static Camera mCamera;
    private static Camera.Parameters mParameters;
    public static boolean torchOn = false;

    public static void startCamera() {
        if (mCamera == null) {
            mCamera = Camera.open();
            mParameters = mCamera.getParameters();
        }
    }
    public static void destroy() {
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }
    public void flashTest(View view) {
        startCamera();
        if (mCamera != null && mParameters != null) {
            if (!mParameters.getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH)) {
                mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(mParameters);
                mCamera.startPreview();
                torchOn = true;
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        if (mCamera != null && mParameters != null) {
            mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            mCamera.setParameters(mParameters);
            mCamera.stopPreview();
            torchOn = false;
        }
    }
    public void flashOn(){
        if (mCamera != null && mParameters != null) {
            if (!mParameters.getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH)) {
                mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(mParameters);
                mCamera.startPreview();
                torchOn = true;
            }
        }
    }
    public void flashOff(){
        if (mCamera != null && mParameters != null) {
            mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            mCamera.setParameters(mParameters);
            mCamera.stopPreview();
            torchOn = false;
        }
    }
    public void flashOutput(View view){
        startCamera();
        userInput = (EditText) findViewById(R.id.userInput);
        String input = String.valueOf(userInput.getText());
        String response = input;
        String[] converted = binaryConvert(response);
        int num = 0;
        String working = null;
        while (num < converted.length){
            working = converted[num];
            char[] workingArray = working.toCharArray();
            int num2 = 0;
            while (num2 < workingArray.length){
                if (workingArray[num2] == '0'){
                    flashOn();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flashOff();

                }
                if (workingArray[num2] == '1'){
                    flashOn();
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flashOff();
                }
                if (workingArray[num2] == '2'){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num2++;
            }
            num++;
        }
    }
    public void vibrateTest() {
        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(200);


    }

    public void vibrateDash(){

        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(800);

    }
    public void vibrateDot(){
        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(200);

    }

    public void vibrateSpace() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void vibrateOutput(View view){
        userInput = (EditText) findViewById(R.id.userInput);
        String input = String.valueOf(userInput.getText());
        String response = input;
        String[] converted = binaryConvert(response);
        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        int num = 0;
        String working = null;
        while (num < converted.length){
            working = converted[num];
            char[] workingArray = working.toCharArray();
            int num2 = 0;
            while (num2 < workingArray.length){
                if (workingArray[num2] == '0'){
                    v.vibrate(800);

                }
                if (workingArray[num2] == '1'){
                    v.vibrate(800);
                }
                if (workingArray[num2] == '2'){
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num2++;
            }
            num++;
        }
    }


    public void makeMap(){
        Morse.put("a", "01");
        Morse.put("b", "1000");
        Morse.put("c", "1010");
        Morse.put("d", "100");
        Morse.put("e", "0");
        Morse.put("f", "0010");
        Morse.put("g", "110");
        Morse.put("h", "0000");
        Morse.put("i", "00");
        Morse.put("j", "0111");
        Morse.put("k", "101");
        Morse.put("l", "0100");
        Morse.put("m", "11");
        Morse.put("n", "10");
        Morse.put("o", "111");
        Morse.put("p", "0110");
        Morse.put("q", "1101");
        Morse.put("r", "010");
        Morse.put("s", "000");
        Morse.put("t", "1");
        Morse.put("u", "001");
        Morse.put("v", "0001");
        Morse.put("w", "011");
        Morse.put("x", "1001");
        Morse.put("y", "1011");
        Morse.put("z", "1100");
        Morse.put(" ", "2");
        Morse.put("\n", "22");
    }




}
