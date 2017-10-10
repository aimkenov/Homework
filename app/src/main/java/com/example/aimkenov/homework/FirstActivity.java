package com.example.aimkenov.homework;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    static CountDownTimer countDownTimer;
    long timeEdge = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onResume() {
        super.onResume();

        countDownTimer = new CountDownTimer(timeEdge, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    private static final String KEY_TIME="";

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        timeEdge = savedInstanceState.getLong(KEY_TIME);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong(KEY_TIME, timeEdge);
    }

}