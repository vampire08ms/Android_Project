package com.example.ring;

import java.util.ArrayList;
import java.util.List;

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

public class Activity_list extends Activity {

	public Button buttonNotifaction = null;
	public Button buttonToast = null;
	public Button spinner = null;
	public Button sharedPreferences = null;
	public Button button = null;
	public TextView text1 = null;
	public TextView text2 = null;
	public TextView text3 = null;
	public EditText editText = null;
	private List<Treasure> treasureList = new ArrayList<Treasure>();

	private IntentFilter intentFilter = null;
	private NetworkChangeReceiver network = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		editText = (EditText) findViewById(R.id.editText1);
		ListView listView = (ListView) findViewById(R.id.listView1);

		initTreasure();
		TreasureAdapter adapter = new TreasureAdapter(Activity_list.this,R.layout.treasure_item, treasureList);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				// TODO Auto-generated method stub
				Treasure treasure = treasureList.get(position);
				Toast.makeText(Activity_list.this, treasure.getName(),	Toast.LENGTH_SHORT).show();

				Intent intent = new Intent();
				intent.putExtra("listItem", treasure);
				intent.setClass(Activity_list.this, MainActivity1.class);
				startActivity(intent);
			}
		});
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		manager.cancel(R.layout.activity_main_activity1);

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Activity_list.this,
						MainActivity1.class);
				// intent.putExtra("extra_data", editText.getText().toString());
				// startActivity(intent);
				Treasure temp = new Treasure("lisong", 123);
				intent.putExtra("test", temp);
				startActivity(intent);
				// startActivityForResult(intent, 1);
			}
		});

		/* ÍøÂç¸Ä±ä½ÓÊÕ */
		intentFilter = new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		network = new NetworkChangeReceiver();
		registerReceiver(network, intentFilter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		// super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
			}
			break;

		default:
			break;
		}
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

	protected void onStart() {
		super.onStart();
		Log.d("MainActivity", "onStart");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("MainActivity", "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("MainActivity", "onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("MainActivity", "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("MainActivity", "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("MainActivity", "onDestroy");
		unregisterReceiver(network);
	}

	class NetworkChangeReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
			String text = null;
			if (networkInfo != null && networkInfo.isAvailable()) {
				text = "network is available";
			} else {
				text = "network is unavailable";
			}
			Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
		}
	}

	private void initTreasure() {
		Treasure icon_ring_of_lightning_protection = new Treasure("¸ñ¶·Ê¿È­Ì×",
				R.drawable.icon_ring_of_lightning_protection);
		treasureList.add(icon_ring_of_lightning_protection);

		Treasure icon_breastplate_of_eldritch_might = new Treasure("ÉñÁ¦ÐØ¼×",
				R.drawable.icon_breastplate_of_eldritch_might);
		treasureList.add(icon_breastplate_of_eldritch_might);

		Treasure icon_cuirass_of_the_dwarven_kings = new Treasure("°«ÈËÍõÌú¼×",
				R.drawable.icon_cuirass_of_the_dwarven_kings);
		treasureList.add(icon_cuirass_of_the_dwarven_kings);

		Treasure icon_dragon_scale_armor = new Treasure("Áú÷ëîø¼×",
				R.drawable.icon_dragon_scale_armor);
		treasureList.add(icon_dragon_scale_armor);

		Treasure icon_robe_of_sar_issus = new Treasure("Èø-ÒÁËÕË¹µÄ³¤ÅÛ",
				R.drawable.icon_robe_of_sar_issus);
		treasureList.add(icon_robe_of_sar_issus);

		Treasure icon_runic_war_harness = new Treasure("·ûÎÄÕ½¼×",
				R.drawable.icon_runic_war_harness);
		treasureList.add(icon_runic_war_harness);

		Treasure icon_scale_mail_of_enlightenment = new Treasure("ÆôµÏÁÛ¼×",
				R.drawable.icon_scale_mail_of_enlightenment);
		treasureList.add(icon_scale_mail_of_enlightenment);

		Treasure icon_tunic_of_the_carved_flesh = new Treasure("Æ¤ÎÆÕ½ÅÛ",
				R.drawable.icon_tunic_of_the_carved_flesh);
		treasureList.add(icon_tunic_of_the_carved_flesh);

	}
}
