package com.example.ring;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.CursorJoiner.Result;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends ActionBarActivity {

	public Button upLoadInfo = null;
	public TextView industryClassification = null;
	public Intent result = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		industryClassification = (TextView) findViewById(R.id.industryClassification);
		upLoadInfo = (Button) findViewById(R.id.upLoadInfo);
		upLoadInfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(RegisterActivity.this, UpInfoActivity.class);
				startActivity(intent);
			}
		});

		industryClassification.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(RegisterActivity.this, IndustryClassificationsFirstActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		result = getIntent();
		if( null != result)
		{
			industryClassification.setText(result.getStringExtra("first"));
		}
	}
}
