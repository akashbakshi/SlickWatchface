package com.example.akash.slickwatchface;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by akash on 2017-02-10.
 */
public class ColorSelection extends Activity {
    public SeekBar red,green,blue,alpha;
    public TextView tRed,tBlue,tGreen,tAlpha;
    public RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_selector);
        DisplayMetrics screensize = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(screensize);
        int width = screensize.widthPixels;
        int height = screensize.heightPixels;


        WindowManager.LayoutParams param = getWindow().getAttributes();
        param.y = 250;
        param.width =(int)(width*0.65);
        param.height =(int)(height*0.55);



      

        if(MainActivity.colorOption == 0) {
            sliderHHSetup();
            param.y = (int)(screensize.heightPixels*0.025);
            getWindow().setAttributes(param);
        }
        else if(MainActivity.colorOption == 1) {
            sliderAMSetup();
            param.y = (int)(screensize.heightPixels*0.15);
            getWindow().setAttributes(param);
        }
        else if(MainActivity.colorOption == 2) {
            sliderPMSetup();;
            param.y = (int)(screensize.heightPixels*0.25);
            getWindow().setAttributes(param);
        }
    }


    void sliderHHSetup(){

        //set Layout Background color
        layout = (RelativeLayout)findViewById(R.id.rLayout);
        layout.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
        
        // Set Text view info for seek bars
        tRed = (TextView)findViewById(R.id.tvRed);
        tGreen = (TextView)findViewById(R.id.tvGreen);
        tBlue = (TextView)findViewById(R.id.tvBlue);
        tAlpha = (TextView)findViewById(R.id.tvAlpha);


        tRed.setText(Integer.toString(MainActivity.hhColorRed));
        tGreen.setText(Integer.toString(MainActivity.hhColorGreen));
        tBlue.setText(Integer.toString(MainActivity.hhColorBlue));
        tAlpha.setText(Integer.toString(MainActivity.hhColorAlpha));

        //Set Seekbar info
        red = (SeekBar) findViewById(R.id.sbRed);
        green = (SeekBar) findViewById(R.id.sbGreen);
        blue = (SeekBar) findViewById(R.id.sbBlue);
        alpha = (SeekBar) findViewById(R.id.sbAlpha);

        red.setMax(255);
        red.setProgress(MainActivity.hhColorRed);
        int thumbPos = red.getMeasuredWidth() * red.getProgress() / red.getMax() - red.getThumbOffset();

        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tRed.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tRed.setTextSize(20.0f);
                MainActivity.hhColorRed = progress;
                tRed.setText(Integer.toString(MainActivity.hhColorRed));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.hhColorRed < 10)
                    tRed.setX(thumbPos+60);
                else if(MainActivity.hhColorRed>230)
                    tRed.setX(thumbPos-90);
                else
                    tRed.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
                MainActivity.hhColor.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
            }
        });

        blue.setMax(255);
        blue.setProgress(MainActivity.hhColorBlue);
        thumbPos = blue.getMeasuredWidth() * blue.getProgress() / blue.getMax() - blue.getThumbOffset();
        tBlue.setX(thumbPos);
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tBlue.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tBlue.setTextSize(20.0f);
                MainActivity.hhColorBlue = progress;
                tBlue.setText(Integer.toString(MainActivity.hhColorBlue));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.hhColorBlue < 10)
                    tBlue.setX(thumbPos+60);
                else if(MainActivity.hhColorBlue>230)
                    tBlue.setX(thumbPos-90);
                else
                    tBlue.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
                MainActivity.hhColor.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
            }
        });
        green.setMax(255);
        green.setProgress(MainActivity.hhColorGreen);
        thumbPos = green.getMeasuredWidth() * green.getProgress() / green.getMax() - green.getThumbOffset();
        tGreen.setX(thumbPos);
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tGreen.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tGreen.setTextSize(20.0f);
                MainActivity.hhColorGreen = progress;
                tGreen.setText(Integer.toString(MainActivity.hhColorGreen));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.hhColorGreen < 10)
                    tGreen.setX(thumbPos+60);
                else if(MainActivity.hhColorGreen>230)
                    tGreen.setX(thumbPos-90);
                else
                    tGreen.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
                MainActivity.hhColor.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
            }
        });
        alpha.setMax(255);
        alpha.setProgress(MainActivity.hhColorAlpha);
        thumbPos = alpha.getMeasuredWidth() * alpha.getProgress() / alpha.getMax() - alpha.getThumbOffset();
        tAlpha.setX(thumbPos);
        alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tAlpha.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tAlpha.setTextSize(20.0f);
                MainActivity.hhColorAlpha = progress;
                tAlpha.setText(Integer.toString(MainActivity.hhColorAlpha));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.hhColorAlpha < 10)
                    tAlpha.setX(thumbPos+60);
                else if(MainActivity.hhColorAlpha>230)
                    tAlpha.setX(thumbPos-90);
                else
                    tAlpha.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
                MainActivity.hhColor.setBackgroundColor(Color.argb(MainActivity.hhColorAlpha,MainActivity.hhColorRed,MainActivity.hhColorGreen,MainActivity.hhColorBlue));
            }
        });

    }

    void sliderAMSetup(){

        //set Layout Background color
        layout = (RelativeLayout)findViewById(R.id.rLayout);
        layout.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));

        // Set Text view info for seek bars
        tRed = (TextView)findViewById(R.id.tvRed);
        tGreen = (TextView)findViewById(R.id.tvGreen);
        tBlue = (TextView)findViewById(R.id.tvBlue);
        tAlpha = (TextView)findViewById(R.id.tvAlpha);


        tRed.setText(Integer.toString(MainActivity.amColorRed));
        tGreen.setText(Integer.toString(MainActivity.amColorGreen));
        tBlue.setText(Integer.toString(MainActivity.amColorBlue));
        tAlpha.setText(Integer.toString(MainActivity.amColorAlpha));

        //Set Seekbar info
        red = (SeekBar) findViewById(R.id.sbRed);
        green = (SeekBar) findViewById(R.id.sbGreen);
        blue = (SeekBar) findViewById(R.id.sbBlue);
        alpha = (SeekBar) findViewById(R.id.sbAlpha);

        red.setMax(255);
        red.setProgress(MainActivity.amColorRed);
        int thumbPos = red.getMeasuredWidth() * red.getProgress() / red.getMax() - red.getThumbOffset();

        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tRed.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tRed.setTextSize(20.0f);
                MainActivity.amColorRed = progress;
                tRed.setText(Integer.toString(MainActivity.amColorRed));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.amColorRed < 10)
                    tRed.setX(thumbPos+60);
                else if(MainActivity.amColorRed>230)
                    tRed.setX(thumbPos-90);
                else
                    tRed.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
                MainActivity.amColor.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
            }
        });

        blue.setMax(255);
        blue.setProgress(MainActivity.amColorBlue);
        thumbPos = blue.getMeasuredWidth() * blue.getProgress() / blue.getMax() - blue.getThumbOffset();
        tBlue.setX(thumbPos);
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tBlue.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tBlue.setTextSize(20.0f);
                MainActivity.amColorBlue = progress;
                tBlue.setText(Integer.toString(MainActivity.amColorBlue));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.amColorBlue < 10)
                    tBlue.setX(thumbPos+60);
                else if(MainActivity.amColorBlue>230)
                    tBlue.setX(thumbPos-90);
                else
                    tBlue.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
                MainActivity.amColor.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
            }
        });
        green.setMax(255);
        green.setProgress(MainActivity.amColorGreen);
        thumbPos = green.getMeasuredWidth() * green.getProgress() / green.getMax() - green.getThumbOffset();
        tGreen.setX(thumbPos);
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tGreen.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tGreen.setTextSize(20.0f);
                MainActivity.amColorGreen = progress;
                tGreen.setText(Integer.toString(MainActivity.amColorGreen));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.amColorGreen < 10)
                    tGreen.setX(thumbPos+60);
                else if(MainActivity.amColorGreen>230)
                    tGreen.setX(thumbPos-90);
                else
                    tGreen.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
                MainActivity.amColor.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
            }
        });
        alpha.setMax(255);
        alpha.setProgress(MainActivity.amColorAlpha);
        thumbPos = alpha.getMeasuredWidth() * alpha.getProgress() / alpha.getMax() - alpha.getThumbOffset();
        tAlpha.setX(thumbPos);
        alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tAlpha.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tAlpha.setTextSize(20.0f);
                MainActivity.amColorAlpha = progress;
                tAlpha.setText(Integer.toString(MainActivity.amColorAlpha));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.amColorAlpha < 10)
                    tAlpha.setX(thumbPos+60);
                else if(MainActivity.amColorAlpha>230)
                    tAlpha.setX(thumbPos-90);
                else
                    tAlpha.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
                MainActivity.amColor.setBackgroundColor(Color.argb(MainActivity.amColorAlpha,MainActivity.amColorRed,MainActivity.amColorGreen,MainActivity.amColorBlue));
            }
        });

    }

    void sliderPMSetup(){

        //set Layout Background color
        layout = (RelativeLayout)findViewById(R.id.rLayout);
        layout.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));

        // Set Text view info for seek bars
        tRed = (TextView)findViewById(R.id.tvRed);
        tGreen = (TextView)findViewById(R.id.tvGreen);
        tBlue = (TextView)findViewById(R.id.tvBlue);
        tAlpha = (TextView)findViewById(R.id.tvAlpha);


        tRed.setText(Integer.toString(MainActivity.pmColorRed));
        tGreen.setText(Integer.toString(MainActivity.pmColorGreen));
        tBlue.setText(Integer.toString(MainActivity.pmColorBlue));
        tAlpha.setText(Integer.toString(MainActivity.pmColorAlpha));

        //Set Seekbar info
        red = (SeekBar) findViewById(R.id.sbRed);
        green = (SeekBar) findViewById(R.id.sbGreen);
        blue = (SeekBar) findViewById(R.id.sbBlue);
        alpha = (SeekBar) findViewById(R.id.sbAlpha);

        red.setMax(255);
        red.setProgress(MainActivity.pmColorRed);
        int thumbPos = red.getMeasuredWidth() * red.getProgress() / red.getMax() - red.getThumbOffset();

        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tRed.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tRed.setTextSize(20.0f);
                MainActivity.pmColorRed = progress;
                tRed.setText(Integer.toString(MainActivity.pmColorRed));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.pmColorRed < 10)
                    tRed.setX(thumbPos+60);
                else if(MainActivity.pmColorRed>230)
                    tRed.setX(thumbPos-90);
                else
                    tRed.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
                MainActivity.pmColor.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
            }
        });

        blue.setMax(255);
        blue.setProgress(MainActivity.pmColorBlue);
        thumbPos = blue.getMeasuredWidth() * blue.getProgress() / blue.getMax() - blue.getThumbOffset();
        tBlue.setX(thumbPos);
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tBlue.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tBlue.setTextSize(20.0f);
                MainActivity.pmColorBlue = progress;
                tBlue.setText(Integer.toString(MainActivity.pmColorBlue));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.pmColorBlue < 10)
                    tBlue.setX(thumbPos+60);
                else if(MainActivity.pmColorBlue>230)
                    tBlue.setX(thumbPos-90);
                else
                    tBlue.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
                MainActivity.pmColor.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
            }
        });
        green.setMax(255);
        green.setProgress(MainActivity.pmColorGreen);
        thumbPos = green.getMeasuredWidth() * green.getProgress() / green.getMax() - green.getThumbOffset();
        tGreen.setX(thumbPos);
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tGreen.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tGreen.setTextSize(20.0f);
                MainActivity.pmColorGreen = progress;
                tGreen.setText(Integer.toString(MainActivity.pmColorGreen));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.pmColorGreen < 10)
                    tGreen.setX(thumbPos+60);
                else if(MainActivity.pmColorGreen>230)
                    tGreen.setX(thumbPos-90);
                else
                    tGreen.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
                MainActivity.pmColor.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
            }
        });
        alpha.setMax(255);
        alpha.setProgress(MainActivity.pmColorAlpha);
        thumbPos = alpha.getMeasuredWidth() * alpha.getProgress() / alpha.getMax() - alpha.getThumbOffset();
        tAlpha.setX(thumbPos);
        alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar sb){

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb){
                tAlpha.setTextSize(14.0f);
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tAlpha.setTextSize(20.0f);
                MainActivity.pmColorAlpha = progress;
                tAlpha.setText(Integer.toString(MainActivity.pmColorAlpha));
                int thumbPos = seekBar.getMeasuredWidth() * seekBar.getProgress() / seekBar.getMax() - seekBar.getThumbOffset();
                if(MainActivity.pmColorAlpha < 10)
                    tAlpha.setX(thumbPos+60);
                else if(MainActivity.pmColorAlpha>230)
                    tAlpha.setX(thumbPos-90);
                else
                    tAlpha.setX(thumbPos);

                layout.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
                MainActivity.pmColor.setBackgroundColor(Color.argb(MainActivity.pmColorAlpha,MainActivity.pmColorRed,MainActivity.pmColorGreen,MainActivity.pmColorBlue));
            }
        });

    }
}

