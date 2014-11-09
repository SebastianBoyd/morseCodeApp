package com.sebastianboyd.morsecodeapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.hardware.Camera;
import java.util.*;
import android.view.MenuItem;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import android.widget.*;
import android.view.inputmethod.*;

public class vibrate {
    private static int dash = 800;
    private static int dot = 200;

    public static void vibrateTest() {
        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(200);


    }

    public static void vibrateDash(){

        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(dash);

    }
    public static void vibrateDot(){
        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(dot);

    }

    public static void vibrateSpace() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
