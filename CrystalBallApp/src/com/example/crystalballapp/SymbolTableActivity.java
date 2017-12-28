package com.example.crystalballapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SymbolTableActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_symbol_table);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_symbol_table, menu);
		return true;
	}
	public void ProceedToResult(View a)
    {
    	Intent myIntent=new Intent(getApplicationContext(),ResultActivity.class);
    	startActivity(myIntent);
    }
    
}
