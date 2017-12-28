package com.example.dotsapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	DrawingView drView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drView = (DrawingView) findViewById(R.id.drawingView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void ChangeColor(View a) {
		Button btn = (Button) a;
		if (btn.getId() == R.id.button1) {
			DrawingView.clr = Color.WHITE;
		} else if (btn.getId() == R.id.button2) {
			DrawingView.clr = Color.parseColor("#652211");
		} else if (btn.getId() == R.id.button3) {
			DrawingView.clr = Color.parseColor("#000000");
		} else if (btn.getId() == R.id.button4) {
			DrawingView.clr = Color.parseColor("#0000ff");
		} else if (btn.getId() == R.id.button5) {
			DrawingView.clr = Color.parseColor("#00ff00");
		} else if (btn.getId() == R.id.button7) {
			DrawingView.clr = Color.parseColor("#ff0000");
		} else if (btn.getId() == R.id.button6) {
			drView.clear();
		}
	}

	public void strokeSize(View a) {
		Button btn = (Button) a;
		if (btn.getId() == R.id.button8) {
			DrawingView.STROKE_WIDTH += 5;
		} else if (btn.getId() == R.id.button9) {
			DrawingView.STROKE_WIDTH -= 5;
		}
	}

}
