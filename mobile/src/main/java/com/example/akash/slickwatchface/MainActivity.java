package com.example.akash.slickwatchface;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

public class MainActivity extends AppCompatActivity  {
    public static int hhColorRed=0,hhColorGreen=0,hhColorBlue=240,hhColorAlpha=255;
    public static int amColorRed=80,amColorGreen=202,amColorBlue=255,amColorAlpha=255;
    public static int pmColorRed=0,pmColorGreen=255,pmColorBlue=160,pmColorAlpha=255;
    public static int colorOption = 0;
    public static Button hhColor,amColor,pmColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hhColor = (Button)findViewById(R.id.btnHHColor);
        hhColor.setBackgroundColor(Color.argb(hhColorAlpha,hhColorRed,hhColorGreen,hhColorBlue));
        hhColor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                colorOption = 0;
                startActivity(new Intent(MainActivity.this,ColorSelection.class));
            }
        });

        amColor = (Button)findViewById(R.id.btnAMColor);
        amColor.setBackgroundColor(Color.argb(amColorAlpha,amColorRed,amColorGreen,amColorBlue));
        amColor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                colorOption = 1;
                startActivity(new Intent(MainActivity.this,ColorSelection.class));
            }
        });

        pmColor = (Button)findViewById(R.id.btnPMColor);
        pmColor.setBackgroundColor(Color.argb(pmColorAlpha,pmColorRed,pmColorGreen,pmColorBlue));
        pmColor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                colorOption = 2;
                startActivity(new Intent(MainActivity.this,ColorSelection.class));
            }
        });
    }




}
