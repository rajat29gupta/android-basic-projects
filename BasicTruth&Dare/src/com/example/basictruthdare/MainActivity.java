package com.example.basictruthdare;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void RotateBottle(View x)
    {
    	RotateAnimation RotateNeedle;
    	int angle=new Random().nextInt(361)+3600;
    	RotateNeedle=new RotateAnimation(0,angle,
    			RotateAnimation.RELATIVE_TO_SELF,0.5f,
    			RotateAnimation.RELATIVE_TO_SELF,0.5f);
    	RotateNeedle.setDuration(10000);
    	RotateNeedle.setFillAfter(true);
    	button.startAnimation(RotateNeedle);
    }
}
