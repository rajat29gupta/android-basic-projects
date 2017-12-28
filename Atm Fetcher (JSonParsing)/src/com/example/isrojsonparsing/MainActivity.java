package com.example.isrojsonparsing;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText poiType, radius, lat, longs, poiName;
	ListView lst;
	ProgressBar pg;
	ArrayList<String> nameArr= new ArrayList<String>();
	ArrayList<String> addArr= new ArrayList<String>();
	ArrayList<String> latArr= new ArrayList<String>();
	ArrayList<String> longArr= new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		poiType = (EditText) findViewById(R.id.editText1);
		radius = (EditText) findViewById(R.id.editText2);
		pg = (ProgressBar) findViewById(R.id.progressBar1);
		lat = (EditText) findViewById(R.id.editText3);
		longs = (EditText) findViewById(R.id.editText4);
		poiName = (EditText) findViewById(R.id.editText5);

		lst = (ListView) findViewById(R.id.listView1);
	}
	public void Search(View a) {
		 //http://api.androidhive.info/contacts/
		new MyThread()
				.execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
						+ lat.getText().toString()
						+ ","
						+ longs.getText().toString()
						+ "&radius="
						+ radius.getText().toString()
						+ "&types="
						+ poiType.getText().toString()
						+ "&name="
						+ poiName.getText().toString()
						+ "&sensor=false&key=AIzaSyBPXwJ6XQDhCfQGX1QGJBsoy4z6a1rc0lw");
	}

	public class MyThread extends AsyncTask<String, Void, ArrayList<String>> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pg.setVisibility(View.VISIBLE);
		}

		@Override
		protected ArrayList<String> doInBackground(String... abc) {
			// TODO Auto-generated method stub
			try {
				JsonHandler json = new JsonHandler();
				String jsonStr = json.makeServiceCall(abc[0], JsonHandler.GET);
				if (jsonStr != null) {
					 

						JSONObject jsonObject = new JSONObject(jsonStr);
						JSONArray arr=jsonObject.getJSONArray("results");
						
						for (int i = 0; i < arr.length(); i++) {
							
							JSONObject obj =arr.getJSONObject(i);
							JSONArray arr2=obj.getJSONArray("types");
							
							
							nameArr.add(arr2.getString(0)+"\n"+obj.getString("name")+"\n"+obj.getString("vicinity"));
						}
							return nameArr;
				}
				
			
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			
			return null;
			
		}

		@Override
		protected void onPostExecute(ArrayList<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pg.setVisibility(View.GONE);
			 
			if (result != null) {
				lst.setAdapter(new ArrayAdapter<String>(
						getApplicationContext(),
						android.R.layout.simple_list_item_1, result));
			} else {
				Toast.makeText(getApplicationContext(),
						"Technical Error pls try Again", 1).show();
			}

		}
	}

	 
}
