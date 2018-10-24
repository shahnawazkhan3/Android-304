package com.zaaviyah.etech_303_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String Tag = "wellcome Android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("onCreate()",Tag);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart()",Tag);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume()",Tag);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause()",Tag);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop()",Tag);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy()",Tag);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("onRestart()",Tag);
    }
}
