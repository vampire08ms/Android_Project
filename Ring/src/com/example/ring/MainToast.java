package com.example.ring;

import android.support.v7.app.ActionBarActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainToast extends ActionBarActivity {

	OnClickListener listener1 = null;
	OnClickListener listener2 = null;
	Button button1 = null;
	Button button2 = null;
	private static int NOTIFICATIONS_ID = R.layout.activity_main_toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		listener1 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setTitle("短暂的提醒");
				showToast(Toast.LENGTH_SHORT);
			}
		};

		listener2 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setTitle("长久的提醒");
				showToast(Toast.LENGTH_LONG);
				showNotification();
			}
		};

		setContentView(R.layout.activity_main_toast);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(listener1);
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(listener2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_toast, menu);
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

	protected void showToast(int type) {
		View view = inflateView(R.layout.activity_main_toast);

		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText("雪洁");

		Toast toast = new Toast(this);
		// toast.setView(view);
		// toast.setDuration(type);
		// toast.show();
		/* 默认的Toast */
		toast.makeText(getApplicationContext(), "默认的样式", Toast.LENGTH_SHORT)
				.show();

		/* 自定义位置的Toast */
		toast = Toast.makeText(getApplicationContext(), "自定义位置Toast",
				Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();

		/* 带图标的Toast */
		toast = Toast.makeText(getApplicationContext(), "带图片的Toast",
				Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.ic_launcher);
		toastView.addView(imageCodeProject, 0);
		toast.show();

	}

	private View inflateView(int resource) {
		// TODO Auto-generated method stub
		LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return vi.inflate(resource, null);
	}

	protected void showNotification() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		CharSequence title = "首都";
		CharSequence contents = "北京";

		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, MainActivity.class), 0);

		Notification notification = new Notification(R.drawable.ic_launcher,
				"中国", System.currentTimeMillis());
		notification.setLatestEventInfo(this, title, contents, contentIntent);
		notificationManager.notify(NOTIFICATIONS_ID, notification);
	}
}
