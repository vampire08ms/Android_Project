package com.example.ring;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityGolden extends ActionBarActivity {
    public ListView listView = null;
    private List<Treasure> treasureList = new ArrayList<Treasure>();
    private MyDatabaseHelper dbHelper;
    private Treasure temp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golden);

		/* �������ݿ� */
        dbHelper = new MyDatabaseHelper(this, "Saint.db", null, 1);
        dbHelper.getWritableDatabase();

		/* ��ʼ��List�ؼ� */
        ListView listView = (ListView) findViewById(R.id.listView1);
        /* ��ʼ������ */
        initTreasure();
        TreasureAdapter adapter = new TreasureAdapter(ActivityGolden.this,
                R.layout.treasure_item, treasureList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                temp = treasureList.get(arg2);
                Intent intent = new Intent();
                intent.putExtra("name", temp.getName());
                intent.setClass(ActivityGolden.this, Person.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_golden, menu);
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

    private void initTreasure() {

        Treasure aires = new Treasure("白羊座", R.drawable.aires);
        treasureList.add(aires);

        Treasure taurus = new Treasure("金牛座", R.drawable.taurus);
        treasureList.add(taurus);

        Treasure gemini = new Treasure("双子座", R.drawable.gemini);
        treasureList.add(gemini);

        Treasure cancer = new Treasure("巨蟹座", R.drawable.cancer);
        treasureList.add(cancer);

        Treasure leo = new Treasure("狮子座", R.drawable.leo);
        treasureList.add(leo);

        Treasure virgo = new Treasure("处女座", R.drawable.virgo);
        treasureList.add(virgo);

        Treasure libra = new Treasure("天秤座", R.drawable.libra);
        treasureList.add(libra);

        Treasure scorpius = new Treasure("天蝎座", R.drawable.scorpius);
        treasureList.add(scorpius);

        Treasure sagittarius = new Treasure("射手座", R.drawable.sagittarius);
        treasureList.add(sagittarius);

        Treasure capricornus = new Treasure("摩羯座", R.drawable.capricornus);
        treasureList.add(capricornus);

        Treasure aquarius = new Treasure("水瓶座", R.drawable.aquarius);
        treasureList.add(aquarius);

        Treasure pisces = new Treasure("双鱼座", R.drawable.pisces);
        treasureList.add(pisces);
    }
}
