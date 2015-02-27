package com.example.ring;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsMessage;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity1 extends ActionBarActivity {

	private TextView myTextView = null;
	public Intent intent = null;
	public EditText myEditText = null;
	public Button myButton_add = null;
	public Button mySQLite = null;
	public Button serviceButton = null;
	public customView test = null;
	public String string = null;
	public IntentFilter intentReceiverFilter = null;;
	public MessageReceiver messageReceiver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_activity1);
		myEditText = (EditText) findViewById(R.id.editText1);
		myButton_add = (Button) findViewById(R.id.button1);
		myTextView = (TextView) findViewById(R.id.textView1);
		mySQLite = (Button) findViewById(R.id.button2);
		serviceButton = (Button) findViewById(R.id.button3);
		intent = getIntent();
		try {
			myTextView.setText(intent.getStringExtra("extra_data"));
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("MainActivity1", "TextView有问题");
		}
		Log.d("MainActivity1", intent.getStringExtra("extra_data"));

		myButton_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity1.this,MainActivity.class);
				PendingIntent pIntent = PendingIntent.getActivity( MainActivity1.this, 0, intent,	PendingIntent.FLAG_CANCEL_CURRENT );
				NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				Notification notification = new Notification(	R.drawable.ic_launcher, "This is ticket text", System.currentTimeMillis() );
				String content = myEditText.getText().toString();
				if (content.isEmpty())
					notification.setLatestEventInfo(MainActivity1.this, "This",
							"this is content text", pIntent);
				else
					notification.setLatestEventInfo(MainActivity1.this, "This",
							content, pIntent);
				manager.notify(R.layout.activity_main_activity1, notification);
			}
		});

		mySQLite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity1.this, SQLiteActivity.class);
				startActivity(intent);
			}
		});

		serviceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity1.this, ServiceTest.class);
				startActivity(intent);
			}
		});
		/* 接收短信 */
		intentReceiverFilter = new IntentFilter();
		intentReceiverFilter
				.addAction("android.provider.Telephony.SMS_RECEVIED");
		messageReceiver = new MessageReceiver();
		registerReceiver(messageReceiver, intentReceiverFilter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		save(myEditText.getText().toString());
		unregisterReceiver(messageReceiver);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
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

	public void save(String inputText) {
		FileOutputStream out = null;
		BufferedWriter write = null;
		try {
			out = openFileOutput("data", Context.MODE_PRIVATE);
			write = new BufferedWriter(new OutputStreamWriter(out));
			write.write(inputText);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != write) {
					write.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	class MessageReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle bundle = intent.getExtras();
			Object[] pdus = (Object[]) bundle.get("pdu");
			SmsMessage[] messages = new SmsMessage[pdus.length];
			for (int i = 0; i < messages.length; i++) {
				messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
			}
			String fullMessageString = "default";
			for (SmsMessage message : messages) {
				fullMessageString = message.getMessageBody();
			}
			myTextView.setText(fullMessageString);
		}

	}
}
