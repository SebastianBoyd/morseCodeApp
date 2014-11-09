package com.sebastianboyd.morsecodeapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.hardware.Camera.Parameters;
import android.hardware.Camera;
import android.view.MenuItem;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
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
    public void flashTest(View view) {
        Camera cam = Camera.open();
        Parameters p = cam.getParameters();
        p.setFlashMode(Parameters.FLASH_MODE_TORCH);
        cam.setParameters(p);
        cam.startPreview();
        try {
            wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cam.stopPreview();
        cam.release();

    }
    public void vibrateTest(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(200);
    }

    private int dash = 1;
    private int dot = 0;

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    int alphabet[] = new int [26];



    public void assignVar(){
        a = 01;
        b = 1000;
        c = 1010;
        d = 100;
        e = 0;
        f = 0010;
        g = 110;
        h = 0000;
        i = 01;
        j = 0111;
        k = 101;
        l = 0100;
        m = 11;
        n = 10;
        o = 111;
        p = 0110;
        q = 1101;
        r = 010;
        s = 000;
        t = 1;
        u = 001;
        v = 0001;
        w = 011;
        x = 1001;
        y = 1011;
        z = 1100;

    }

}
