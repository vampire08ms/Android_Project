package com.example.ring;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Person extends ActionBarActivity {

    private Intent intent = null;
    private TextView nameView = null;
    private TextView ageView = null;
    private TextView heightView = null;
    private TextView constellationView = null;
    private TextView actionText = null;
    private MyDatabaseHelper dbHelper = null;
    private Cursor cursor = null;
    private String actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        intent = getIntent();

        nameView = (TextView) findViewById(R.id.nameView);
        ageView = (TextView) findViewById(R.id.ageView);
        heightView = (TextView) findViewById(R.id.heightView);
        constellationView = (TextView) findViewById(R.id.constellationView);
        actionText = (TextView) findViewById(R.id.actionView);

        dbHelper = new MyDatabaseHelper(this, "Saint.db", null, 2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            cursor = db.rawQuery("select a.name\"姓名\", a.age\"年龄\", a.high\"身高\", b.name\"星座\"  from User a, constellation b where a.constellationID = b.id and b.name = ?", new String[]{intent.getStringExtra("name")});
            if (cursor.moveToFirst()) {
                do {
                    nameView.setText("姓名：" + cursor.getString(0));
                    ageView.setText("年龄：" + cursor.getString(1));
                    heightView.setText("身高：" + cursor.getString(2) + "cm");
                    constellationView.setText("星座：" + cursor.getString(3));
                } while (cursor.moveToNext());
            }
            cursor.close();

            cursor = db.rawQuery("select name\"必杀技\" from action where UserId = (select a.id from User a, constellation b  where a.constellationID = b.id and b.name = ?)", new String[]{intent.getStringExtra("name")});
            if (cursor.moveToFirst()) {
                do {
                    if (null == actions) {
                        actions = cursor.getString(0) + "\n";
                    } else {
                        actions = actions + cursor.getString(0) + "\n";
                    }

                } while (cursor.moveToNext());
            }
            actionText.setText(actions);
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Person", "数据库查询出现问题");
        } finally {
            cursor.close();
            db.close();
            dbHelper.close();
        }

//        Cursor cursor = db.query( "constellation", null, null, null, null, null, null );
//        if( cursor.moveToFirst()){
//            do{
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                Log.d("Person", "圣斗士："+name);
//            }while(cursor.moveToNext());
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.person, menu);
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
