package com.example.basicagefactor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class SevenActivity extends Activity {
int prev_val;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seven);
		prev_val=getIntent().getExtras().getInt("bvc");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_seven, menu);
		return true;
	}
	public void YesEvent(View x)
    {
    	prev_val+=64;
    	Toast.makeText(getApplicationContext(), "Your age is:"+ prev_val, Toast.LENGTH_LONG).show();
    	Intent myIntent=new Intent(getApplicationContext(),MainActivity.class);
    	startActivity(myIntent);
    	//finish(); is used to abort or quit the app
     }
	public void NoEvent(View x)
    {
    	Toast.makeText(getApplicationContext(), "Your age is:"+ prev_val, Toast.LENGTH_LONG).show();
    	Intent myIntent=new Intent(getApplicationContext(),MainActivity.class);
    	startActivity(myIntent);
    }

}
