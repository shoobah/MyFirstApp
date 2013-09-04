package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE="com.example.myfirstapp.MESSAGE";
	static final String SAVED_DATA="savedData";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		EditText editText=(EditText)findViewById(R.id.edit_message);
		String txt=savedInstanceState.getString(SAVED_DATA);
		editText.setText(txt);
		TextView tv=(TextView)findViewById(R.id.info_txt);
		tv.setText(txt);
		super.onRestoreInstanceState(savedInstanceState);
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onStop(){
		super.onStop();
		TextView tv=(TextView)findViewById(R.id.info_txt);
		tv.setText("STOPPAD");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		EditText editText=(EditText)findViewById(R.id.edit_message);
		String message=editText.getText().toString();
		outState.putString(SAVED_DATA, message);
		super.onSaveInstanceState(outState);
	};
	
	public void sendMessage(View view){
		Intent intent=new Intent(this, DisplayMessageActivity.class);
		EditText editText=(EditText)findViewById(R.id.edit_message);
		String message=editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
}
