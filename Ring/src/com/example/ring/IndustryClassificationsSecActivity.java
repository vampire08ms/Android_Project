package com.example.ring;

import java.util.ArrayList;
import java.util.List;

import list.Classification;
import list.ClassificationAdapter;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class IndustryClassificationsSecActivity extends ActionBarActivity {

	public ListView listView = null;
	ClassificationAdapter adapter = null;
	private List<Classification> classificationList = new ArrayList<Classification>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_industry_classifications_sec);

		listView = (ListView) findViewById(R.id.listView1);
		InitClassificationName();
		adapter = new ClassificationAdapter(
				IndustryClassificationsSecActivity.this,
				R.layout.classification_item, classificationList);
		listView.setAdapter(adapter);

		// listView.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
		// long arg3) {
		// // TODO Auto-generated method stub
		// // Intent intent = new Intent();
		// //
		// intent.setClass(IndustryClassificationsFirstActivity.this,IndustryClassificationsSecActivity.class);
		// // startActivity(intent);
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.industry_classifications_sec, menu);
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
		Classification standrad = new Classification("±±¾©²Ë");
		classificationList.add(standrad);

		Classification standrad1 = new Classification("Â³²Ë");
		classificationList.add(standrad1);

		Classification standrad2 = new Classification("´¨²Ë");
		classificationList.add(standrad2);

		Classification standrad3 = new Classification("Ïã²Ë");
		classificationList.add(standrad3);
	}
}
