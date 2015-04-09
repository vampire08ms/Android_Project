package com.example.ring;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public static final String CREATE_ACTION = "CREATE TABLE action (id integer PRIMARY KEY AUTOINCREMENT, userId INTEGER, name varchar (30));";
//	CREATE TABLE "action" (id integer PRIMARY KEY AUTOINCREMENT, userId INTEGER, name varchar (30));
//	INSERT INTO "action" (id, userId, name) VALUES (1, 1, '念动力');
//	INSERT INTO "action" (id, userId, name) VALUES (2, 1, '水晶墙');
//	INSERT INTO "action" (id, userId, name) VALUES (3, 1, '星光灭绝');
//	INSERT INTO "action" (id, userId, name) VALUES (4, 1, '星屑旋转功');
//	INSERT INTO "action" (id, userId, name) VALUES (5, 2, '巨型号角');
//	INSERT INTO "action" (id, userId, name) VALUES (6, 3, '异次元空间');
//	INSERT INTO "action" (id, userId, name) VALUES (7, 3, '幻胧魔皇拳');
//	INSERT INTO "action" (id, userId, name) VALUES (8, 3, '银河星爆');
//	INSERT INTO "action" (id, userId, name) VALUES (9, 4, '银河星爆');
//	INSERT INTO "action" (id, userId, name) VALUES (10, 4, '黄金魔鬼大三角');
//	INSERT INTO "action" (id, userId, name) VALUES (11, 4, '黄金超光速拳');
//	INSERT INTO "action" (id, userId, name) VALUES (12, 4, '幻胧魔皇拳');
//	INSERT INTO "action" (id, userId, name) VALUES (13, 4, '瞬间移动');
//	INSERT INTO "action" (id, userId, name) VALUES (14, 4, '银河自爆');
//	INSERT INTO "action" (id, userId, name) VALUES (15, 5, '积尸气冥界波');
//	INSERT INTO "action" (id, userId, name) VALUES (16, 6, '闪电光束');
//	INSERT INTO "action" (id, userId, name) VALUES (17, 6, '闪电等离子');
//	INSERT INTO "action" (id, userId, name) VALUES (18, 7, '天法轮印');
//	INSERT INTO "action" (id, userId, name) VALUES (19, 7, '奥姆');
//	INSERT INTO "action" (id, userId, name) VALUES (20, 7, '天空霸邪-魑魅魍魉');
//	INSERT INTO "action" (id, userId, name) VALUES (21, 7, '六道轮回');
//	INSERT INTO "action" (id, userId, name) VALUES (22, 7, '天魔降伏');
//	INSERT INTO "action" (id, userId, name) VALUES (23, 7, '天舞宝轮');
//	INSERT INTO "action" (id, userId, name) VALUES (24, 8, '庐山百龙霸');
//	INSERT INTO "action" (id, userId, name) VALUES (25, 8, '庐山升龙霸');
//	INSERT INTO "action" (id, userId, name) VALUES (26, 8, '庐山龙飞翔');
//	INSERT INTO "action" (id, userId, name) VALUES (27, 8, '庐山亢龙霸');
//	INSERT INTO "action" (id, userId, name) VALUES (28, 9, '毒蝎念动波');
//	INSERT INTO "action" (id, userId, name) VALUES (29, 9, '猩红毒针');
//	INSERT INTO "action" (id, userId, name) VALUES (30, 9, '安达里士');
//	INSERT INTO "action" (id, userId, name) VALUES (31, 9, '猩红旋风');
//	INSERT INTO "action" (id, userId, name) VALUES (32, 10, '黄金之箭');
//	INSERT INTO "action" (id, userId, name) VALUES (33, 10, '原子闪电光速拳');
//	INSERT INTO "action" (id, userId, name) VALUES (34, 11, '圣剑');
//	INSERT INTO "action" (id, userId, name) VALUES (35, 12, '冻结拳');
//	INSERT INTO "action" (id, userId, name) VALUES (36, 12, '冰结环');
//	INSERT INTO "action" (id, userId, name) VALUES (37, 12, '钻石星辰拳');
//	INSERT INTO "action" (id, userId, name) VALUES (38, 12, '曙光女神之宽恕');
//	INSERT INTO "action" (id, userId, name) VALUES (39, 13, '皇家魔宫玫瑰');
//	INSERT INTO "action" (id, userId, name) VALUES (40, 13, '食人鱼玫瑰');
//	INSERT INTO "action" (id, userId, name) VALUES (41, 13, '血腥玫瑰');
	
//	CREATE TABLE constellation (id integer PRIMARY KEY AUTOINCREMENT ,name varchar(30) );
//	INSERT INTO constellation (id, name) VALUES (1, '白羊座');
//	INSERT INTO constellation (id, name) VALUES (2, '金牛座');
//	INSERT INTO constellation (id, name) VALUES (3, '双子座');
//	INSERT INTO constellation (id, name) VALUES (4, '巨蟹座');
//	INSERT INTO constellation (id, name) VALUES (5, '狮子座');
//	INSERT INTO constellation (id, name) VALUES (6, '处女座');
//	INSERT INTO constellation (id, name) VALUES (7, '天秤座');
//	INSERT INTO constellation (id, name) VALUES (8, '天蝎座');
//	INSERT INTO constellation (id, name) VALUES (9, '射手座');
//	INSERT INTO constellation (id, name) VALUES (10, '摩羯座');
//	INSERT INTO constellation (id, name) VALUES (11, '水瓶座');
//	INSERT INTO constellation (id, name) VALUES (12, '双鱼座');
	
//	CREATE TABLE User (ID integer PRIMARY KEY AUTOINCREMENT, constellationID INTEGER REFERENCES constellation (id), typeID INTEGER REFERENCES Type (id), gradeID INTEGER, actionID INTEGER REFERENCES "action" (id), name CHAR, high INTEGER, age INTEGER, nationality CHAR, location CHAR);
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (1, 1, 1, 1, 1, '穆', 182, 20, '中国', '嘉米尔');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (2, 2, 1, 1, 2, '阿鲁迪巴', 210, 20, '巴西', '不详');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (3, 3, 1, 1, 3, '撒加', 188, 28, '希腊', '希腊圣域');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (4, 3, 1, 1, 4, '加隆', 188, 28, '希腊', '希腊圣域');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (5, 4, 1, 1, 5, '迪斯马斯克', 184, '', '意大利', '西西里岛');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (6, 5, 1, 1, 6, '艾奥里亚', 185, 20, '希腊', '希腊圣域');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (7, 6, 1, 1, 7, '沙加', 182, NULL, '印度', '恒河流域');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (8, 7, 1, 1, 8, '童虎', 170, 261, '中国', '庐山五老峰');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (9, 8, 1, 1, 9, '米罗', 185, 20, '德国', '希腊米尔斯岛');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (10, 9, 1, 1, 10, '艾俄洛斯', 187, 13, '希腊', '希腊圣域');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (11, 10, 1, 1, 11, '修罗', 186, 23, '西班牙', '比利牛斯山脉');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (12, 11, 1, 1, 12, '卡妙', 184, 20, '法国', '西伯利亚');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (13, 12, 1, 1, 13, '阿布罗狄', 184, 22, '瑞典', '格陵兰岛');
	
//	CREATE TABLE Type (id integer PRIMARY KEY AUTOINCREMENT, name varchar (30));
//	INSERT INTO Type (id, name) VALUES (1, '圣斗士');
//	INSERT INTO Type (id, name) VALUES (2, '海斗士');
//	INSERT INTO Type (id, name) VALUES (3, '神斗士');
	private Context mContext;

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_ACTION);
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
