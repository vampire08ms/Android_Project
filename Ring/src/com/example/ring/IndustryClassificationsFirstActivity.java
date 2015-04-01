package com.example.ring;

import java.util.ArrayList;
import java.util.List;

import list.Classification;
import list.ClassificationAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class IndustryClassificationsFirstActivity extends ActionBarActivity {

	public ListView listView = null;
	ClassificationAdapter adapter = null;
	private List<Classification> classificationList = new ArrayList<Classification>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_industry_classifications_first);
		listView = (ListView) findViewById(R.id.listView1);
		InitClassificationName();
		adapter = new ClassificationAdapter(IndustryClassificationsFirstActivity.this, R.layout.classification_item, classificationList);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.industry_classifications, menu);
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

	public void InitClassificationName() {
		Classification standrad = new Classification("≤Õ“˚");
		classificationList.add(standrad);
		
		Classification standrad1 = new Classification("–›œ–”È¿÷");
		classificationList.add(standrad1);
		
		Classification standrad2 = new Classification("π∫ŒÔ");
		classificationList.add(standrad2);
		
		Classification standrad3 = new Classification("¿ˆ»À");
		classificationList.add(standrad3);
		
		Classification standrad4 = new Classification("Ω·ªÈ");
		classificationList.add(standrad4);
	}
}
