package com.example.basicbmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText hgt_ft,hgt_inch,wgt_kgs;
	Button calc;
	ImageView arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hgt_ft=(EditText)findViewById(R.id.editText1);
        hgt_inch=(EditText)findViewById(R.id.EditText01);
        wgt_kgs=(EditText)findViewById(R.id.EditText02);
        calc=(Button)findViewById(R.id.button1);
        arrow=(ImageView)findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void Calculate(View x)
    {
    	double height,weight,BMI;
    	int angle;
    	height=Double.parseDouble(hgt_ft.getText().toString())*12+Double.parseDouble(hgt_inch.getText().toString());
    	weight=Double.parseDouble(wgt_kgs.getText().toString())*2.204;
    	BMI=(weight*703)/(height*height);
    	angle=(int) (BMI*3.6);
    	
    	RotateAnimation RotateNeedle;
    	//int angle=new Random().nextInt(361)+3600;
    	RotateNeedle=new RotateAnimation(0,angle,
    			RotateAnimation.RELATIVE_TO_SELF,0.9f,
    			RotateAnimation.RELATIVE_TO_SELF,0.5f);
    	RotateNeedle.setDuration(3000);
    	RotateNeedle.setFillAfter(true);
    	arrow.startAnimation(RotateNeedle);
    	Toast.makeText(getApplicationContext(), "Your Body Mass Index is:"+ BMI, Toast.LENGTH_LONG).show();
    }
}
