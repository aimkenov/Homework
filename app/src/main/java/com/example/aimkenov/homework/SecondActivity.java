package com.example.aimkenov.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

public class SecondActivity extends AppCompatActivity {

    public void printNumber(int number, TextView textView){

        int units, dozens, hundreds;
        units = (number % 10);
        dozens = ((number-units) % 100);
        hundreds = ((number-dozens-units) % 1000);
        StringBuilder stringBuilder = new StringBuilder();

        switch (number) {
            case 1000:
                stringBuilder.append("Тысяча ");
            default: break;
        }
        switch (hundreds) {
            case 100:
                stringBuilder.append("Сто ");
                break;
            case 200:
                stringBuilder.append("Двести ");
                break;
            case 300:
                stringBuilder.append("Триста ");
                break;
            case 400:
                stringBuilder.append("Четыреста ");
                break;
            case 500:
                stringBuilder.append("Пятьсот ");
                break;
            case 600:
                stringBuilder.append("Шестьсот ");
                break;
            case 700:
                stringBuilder.append("Семьсот ");
                break;
            case 800:
                stringBuilder.append("Восемьсот ");
                break;
            case 900:
                stringBuilder.append("Девятьсот ");
                break;
        }

        if(dozens == 10) {
            units += 10;
            dozens = 0;
        }

        switch (dozens) {
            case 20:
                stringBuilder.append("Двадцать ");
                break;
            case 30:
                stringBuilder.append("Тридцать ");
                break;
            case 40:
                stringBuilder.append("Сорок ");
                break;
            case 50:
                stringBuilder.append("Пятьдесят ");
                break;
            case 60:
                stringBuilder.append("Шестьдесят ");
                break;
            case 70:
                stringBuilder.append("Семьдесят ");
                break;
            case 80:
                stringBuilder.append("Восемьдесят ");
                break;
            case 90:
                stringBuilder.append("Девяносто ");
                break;
        }

        switch (units) {
            case 1:
                stringBuilder.append("Один ");
                break;
            case 2:
                stringBuilder.append("Два ");
                break;
            case 3:
                stringBuilder.append("Три ");
                break;
            case 4:
                stringBuilder.append("Четыре ");
                break;
            case 5:
                stringBuilder.append("Пять ");
                break;
            case 6:
                stringBuilder.append("Шесть ");
                break;
            case 7:
                stringBuilder.append("Семь ");
                break;
            case 8:
                stringBuilder.append("Восемь ");
                break;
            case 9:
                stringBuilder.append("Девять ");
                break;
            case 10:
                stringBuilder.append("Десять ");
                break;
            case 11:
                stringBuilder.append("Одиннадцать ");
                break;
            case 12:
                stringBuilder.append("Двенадцать ");
                break;
            case 13:
                stringBuilder.append("Тринадцать ");
                break;
            case 14:
                stringBuilder.append("Четырнадцать ");
                break;
            case 15:
                stringBuilder.append("Пятнадцать ");
                break;
            case 16:
                stringBuilder.append("Шестнадцать ");
                break;
            case 17:
                stringBuilder.append("Семнадцать ");
                break;
            case 18:
                stringBuilder.append("Восемнадцать ");
                break;
            case 19:
                stringBuilder.append("Девятнадцать ");
                break;
        }
        textView.setText(stringBuilder.toString());
    }

    CountDownTimer countDownTimer;
    final String stateStart = "Start";
    final String stateStop = "Stop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public int time;
    public int timeEdge = 1_001*1_000;
    @Override
    protected void onResume () {
        super.onResume();
        final TextView textView = ((TextView)findViewById(R.id.text));
        final Button button = (Button)findViewById(R.id.button);

        button.setText(R.string.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().toString().equals(stateStart)) {
                    button.setText(stateStop);
                    countDownTimer.start();
                } else if (button.getText().toString().equals(stateStop)) {
                    button.setText(stateStart);
                    countDownTimer.cancel();
                }

            }
        });

        countDownTimer = new CountDownTimer(timeEdge, 1_000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time++;
                printNumber(time, textView);
            }

            @Override
            public void onFinish() {
                countDownTimer.cancel();
                button.setText(stateStart);
                time = 0;
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    private static final String KEY_CURRENT_TIME = "";
    private static final String KEY_BUTTON = "";
    private static final String KEY_TEXT_VIEW = "";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_TIME, time);
        outState.putString(KEY_BUTTON, ((Button)(findViewById(R.id.button))).getText().toString());
        outState.putString(KEY_TEXT_VIEW, ((TextView)(findViewById(R.id.text))).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        time = savedInstanceState.getInt(KEY_CURRENT_TIME);

        String textView = savedInstanceState.getString(KEY_TEXT_VIEW);
        String buttonText = savedInstanceState.getString(KEY_BUTTON);

        ((TextView)findViewById(R.id.text)).setText(textView);
        ((Button)findViewById(R.id.button)).setText(buttonText);
    }
}



