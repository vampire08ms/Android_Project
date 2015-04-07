package com.example.ring;

import java.util.ArrayList;
import java.util.List;

import list.Classification;
import list.ClassificationAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class IndustryClassificationsSecActivity extends Activity {

	public ListView listView = null;
	public TextView titleTextView = null;
	private Button backButton = null;
	ClassificationAdapter adapter = null;
	Classification item = null;
	String title = null;
	Intent intent = null;
	private List<Classification> classificationList = new ArrayList<Classification>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_industry_classifications_first);
		//设置标题为某个layout
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);

		listView = (ListView) findViewById(R.id.listView1);
		titleTextView = (TextView) findViewById(R.id.textView1);

		intent = getIntent();
		title = intent.getStringExtra("title");
		titleTextView.setText(title);
		InitClassificationName();
		adapter = new ClassificationAdapter(	IndustryClassificationsSecActivity.this,	R.layout.classification_item, classificationList);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				// TODO Auto-generated method stub
				item = classificationList.get(arg2);
				Intent intent = new Intent();
				intent.putExtra("first", title);
				intent.putExtra("second", item.getName() );
				intent.setClass(IndustryClassificationsSecActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});

		backButton = (Button) findViewById(R.id.button1);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
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
		Classification standrad = new Classification("北京菜");
		classificationList.add(standrad);

		Classification standrad1 = new Classification("鲁菜");
		classificationList.add(standrad1);

		Classification standrad2 = new Classification("川菜");
		classificationList.add(standrad2);

		Classification standrad3 = new Classification("香菜");
		classificationList.add(standrad3);
	}
}
