package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GeneratedAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class Game extends AppCompatActivity {

    TextView textView2, textView3, textView4, textView5;
    ImageButton imageButton4, imageButton5;
    boolean isResultCorrect;
    byte seconds = 59;
    public byte score = 0;
    private boolean stopTimer = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textView2 = (TextView) findViewById(R.id.textview2);
        textView3 = (TextView) findViewById(R.id.textview3);
        textView4 = (TextView) findViewById(R.id.textview4);
        textView5 = (TextView) findViewById(R.id.textview5);
        imageButton4 = (ImageButton) findViewById(R.id.imagebutton4);
        imageButton5 = (ImageButton) findViewById(R.id.imagebutton5);
        timer();

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(true);

            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(false);


            }
        });
        generateQuestion();
    }

    private void generateQuestion() {
        isResultCorrect = true;
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        int result = a + b;
        float f = random.nextFloat();
        if (f > 0.5f) {
        result = random.nextInt(100);
        isResultCorrect = false;
    }
        textView4.setText(a + "+" + b);
        textView5.setText("=" + result);
    }

    private void verifyAnswer(boolean answer) {
        if (answer == isResultCorrect) {
            score += 5;
            textView3.setText("SCORE: " + score);
        } else {
            Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
        }
        generateQuestion();
    }

    private void timer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView2.setText("TIME :" + seconds);
                seconds--;
                if (seconds < 0) {
                    Intent i = new Intent(Game.this, Score.class);
                    i.putExtra("score", score);
                    startActivity(i);
                    stopTimer = true;
                }
                if (stopTimer == false) {
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        stopTimer = false;
        finish();


    }
}
