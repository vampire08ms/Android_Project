package com.example.ring;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SharedPerferencesActivity extends ActionBarActivity {

	public final static String COLUMN_NAME = "name";
	public final static String COLUMN_MOBILE = "mobile";
	exampleHelper sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_perferences);

		sp = new exampleHelper(this, "contacts");

		sp.putValue(COLUMN_NAME, "Miss WANG");
		sp.putValue(COLUMN_MOBILE, "Miss XXXXXXXXXXXXXXx");

		String name = sp.getValue(COLUMN_NAME);
		String mobile = sp.getValue(COLUMN_MOBILE);

		TextView tv = new TextView(this);
		tv.setText("NAME:" + name + "\n" + "MOBILE:" + mobile);
		setContentView(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shared_perferences, menu);
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
}
