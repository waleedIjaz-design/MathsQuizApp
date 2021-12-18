package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Score extends AppCompatActivity {
       TextView textView6,textView7;
public ImageButton imageButton6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        textView6 = (TextView) findViewById(R.id.textview6);
        imageButton6 = (ImageButton)findViewById(R.id.imagebutton6);

        int score = getIntent().getIntExtra("score", 0);
        textView6.setText("Current Score : " + score);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("Text/Plain");
                startActivity(intent);

            }
        });

    }
}