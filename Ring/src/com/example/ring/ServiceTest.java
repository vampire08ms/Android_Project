package com.example.ring;

import java.net.ServerSocket;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ServiceTest extends Activity implements OnClickListener {

	private Button startServiceButton = null;
	private Button stopServiceButton = null;
	private Button bindServiceButton = null;
	private Button unbindServiceButton = null;
	private MyService.DownloadBinder downloadBinder;
	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d("MyService", "onServiceDisconnected start");
			Log.d("MyService", "onServiceDisconnected end");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d("MyService", "onServiceConnected start");
			downloadBinder = (MyService.DownloadBinder) service;
			downloadBinder.startDownload();
			downloadBinder.getProgess();
			Log.d("MyService", "onServiceConnected end");
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_test);
		startServiceButton = (Button) findViewById(R.id.startServiceButton);
		stopServiceButton = (Button) findViewById(R.id.stopServiceButton);
		bindServiceButton = (Button) findViewById(R.id.bindServiceButton);
		unbindServiceButton = (Button) findViewById(R.id.unbindServiceButton);

		startServiceButton.setOnClickListener(this);
		stopServiceButton.setOnClickListener(this);
		bindServiceButton.setOnClickListener(this);
		unbindServiceButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.service_test, menu);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.startServiceButton:
			Intent startIntent = new Intent(this, MyService.class);
			startService(startIntent);
			Toast.makeText(this, "服務開啓", Toast.LENGTH_LONG).show();
			break;
		case R.id.stopServiceButton:
			Intent stoptIntent = new Intent(this, MyService.class);
			stopService(stoptIntent);
			Toast.makeText(this, "服務關閉", Toast.LENGTH_SHORT).show();
			break;
		case R.id.bindServiceButton:
			Intent bindIntent = new Intent(this, MyService.class);
			if (true == bindService(bindIntent, connection, BIND_AUTO_CREATE)) {
				Toast.makeText(this, "绑定服务成功", Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(this, "绑定服务失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.unbindServiceButton:
			unbindService(connection);
			Toast.makeText(this, "取消绑定", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}
}
