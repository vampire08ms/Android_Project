package com.example.ring;

import java.util.ArrayList;
import java.util.List;

import list.Classification;
import list.ClassificationAdapter;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class IndustryClassificationsFirstActivity extends Activity {

	public ListView listView = null;
	ClassificationAdapter adapter = null;
	private List<Classification> classificationList = new ArrayList<Classification>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_industry_classifications_first);
		listView = (ListView) findViewById(R.id.listView1);
		InitClassificationName();
		adapter = new ClassificationAdapter(
				IndustryClassificationsFirstActivity.this,
				R.layout.classification_item, classificationList);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(IndustryClassificationsFirstActivity.this,IndustryClassificationsSecActivity.class);
				startActivity(intent);
			}

			
//			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent();
//				intent.setClass(IndustryClassificationsFirstActivity.this,MainActivity1.class);
//				startActivity(intent);
//			}
		});
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
		Classification standrad = new Classification("餐饮");
		classificationList.add(standrad);

		Classification standrad1 = new Classification("休闲娱乐");
		classificationList.add(standrad1);

		Classification standrad2 = new Classification("购物");
		classificationList.add(standrad2);

		Classification standrad3 = new Classification("丽人");
		classificationList.add(standrad3);

		Classification standrad4 = new Classification("结婚");
		classificationList.add(standrad4);

		Classification standrad5 = new Classification("健身运动");
		classificationList.add(standrad5);

		Classification standrad6 = new Classification("汽车");
		classificationList.add(standrad6);

		Classification standrad7 = new Classification("生活服务");
		classificationList.add(standrad7);

		Classification standrad8 = new Classification("教育");
		classificationList.add(standrad8);
	}
}
