package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



      TextView textView1;
      public ImageButton imageButton1, imagebutton2, imagebutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton1 = (ImageButton) findViewById(R.id.imagebutton1);
        imagebutton2 = (ImageButton) findViewById(R.id.imagebutton2);
        imagebutton3 = (ImageButton) findViewById(R.id.imagebutton3);


        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, Game.class );
                startActivity(intent);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("Text/Plain");
                startActivity(intent);
            }
        });


        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Toast.makeText(MainActivity.this,"Open Google Play Store",Toast.LENGTH_SHORT).show();



            }
        });















    }
}