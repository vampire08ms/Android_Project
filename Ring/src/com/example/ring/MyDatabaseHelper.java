package com.example.ring;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public static final String CREATE_ACTION = "CREATE TABLE action (id integer PRIMARY KEY AUTOINCREMENT, userId INTEGER, name varchar (30));";
//	CREATE TABLE "action" (id integer PRIMARY KEY AUTOINCREMENT, userId INTEGER, name varchar (30));
//	INSERT INTO "action" (id, userId, name) VALUES (1, 1, '���');
//	INSERT INTO "action" (id, userId, name) VALUES (2, 1, 'ˮ��ǽ');
//	INSERT INTO "action" (id, userId, name) VALUES (3, 1, '�ǹ����');
//	INSERT INTO "action" (id, userId, name) VALUES (4, 1, '��м��ת��');
//	INSERT INTO "action" (id, userId, name) VALUES (5, 2, '���ͺŽ�');
//	INSERT INTO "action" (id, userId, name) VALUES (6, 3, '���Ԫ�ռ�');
//	INSERT INTO "action" (id, userId, name) VALUES (7, 3, '����ħ��ȭ');
//	INSERT INTO "action" (id, userId, name) VALUES (8, 3, '�����Ǳ�');
//	INSERT INTO "action" (id, userId, name) VALUES (9, 4, '�����Ǳ�');
//	INSERT INTO "action" (id, userId, name) VALUES (10, 4, '�ƽ�ħ�������');
//	INSERT INTO "action" (id, userId, name) VALUES (11, 4, '�ƽ𳬹���ȭ');
//	INSERT INTO "action" (id, userId, name) VALUES (12, 4, '����ħ��ȭ');
//	INSERT INTO "action" (id, userId, name) VALUES (13, 4, '˲���ƶ�');
//	INSERT INTO "action" (id, userId, name) VALUES (14, 4, '�����Ա�');
//	INSERT INTO "action" (id, userId, name) VALUES (15, 5, '��ʬ��ڤ�粨');
//	INSERT INTO "action" (id, userId, name) VALUES (16, 6, '�������');
//	INSERT INTO "action" (id, userId, name) VALUES (17, 6, '���������');
//	INSERT INTO "action" (id, userId, name) VALUES (18, 7, '�취��ӡ');
//	INSERT INTO "action" (id, userId, name) VALUES (19, 7, '��ķ');
//	INSERT INTO "action" (id, userId, name) VALUES (20, 7, '��հ�а-��������');
//	INSERT INTO "action" (id, userId, name) VALUES (21, 7, '�����ֻ�');
//	INSERT INTO "action" (id, userId, name) VALUES (22, 7, '��ħ����');
//	INSERT INTO "action" (id, userId, name) VALUES (23, 7, '���豦��');
//	INSERT INTO "action" (id, userId, name) VALUES (24, 8, '®ɽ������');
//	INSERT INTO "action" (id, userId, name) VALUES (25, 8, '®ɽ������');
//	INSERT INTO "action" (id, userId, name) VALUES (26, 8, '®ɽ������');
//	INSERT INTO "action" (id, userId, name) VALUES (27, 8, '®ɽ������');
//	INSERT INTO "action" (id, userId, name) VALUES (28, 9, '��Ы���');
//	INSERT INTO "action" (id, userId, name) VALUES (29, 9, '�ɺ춾��');
//	INSERT INTO "action" (id, userId, name) VALUES (30, 9, '������ʿ');
//	INSERT INTO "action" (id, userId, name) VALUES (31, 9, '�ɺ�����');
//	INSERT INTO "action" (id, userId, name) VALUES (32, 10, '�ƽ�֮��');
//	INSERT INTO "action" (id, userId, name) VALUES (33, 10, 'ԭ���������ȭ');
//	INSERT INTO "action" (id, userId, name) VALUES (34, 11, 'ʥ��');
//	INSERT INTO "action" (id, userId, name) VALUES (35, 12, '����ȭ');
//	INSERT INTO "action" (id, userId, name) VALUES (36, 12, '���ỷ');
//	INSERT INTO "action" (id, userId, name) VALUES (37, 12, '��ʯ�ǳ�ȭ');
//	INSERT INTO "action" (id, userId, name) VALUES (38, 12, '���Ů��֮��ˡ');
//	INSERT INTO "action" (id, userId, name) VALUES (39, 13, '�ʼ�ħ��õ��');
//	INSERT INTO "action" (id, userId, name) VALUES (40, 13, 'ʳ����õ��');
//	INSERT INTO "action" (id, userId, name) VALUES (41, 13, 'Ѫ��õ��');
	
//	CREATE TABLE constellation (id integer PRIMARY KEY AUTOINCREMENT ,name varchar(30) );
//	INSERT INTO constellation (id, name) VALUES (1, '������');
//	INSERT INTO constellation (id, name) VALUES (2, '��ţ��');
//	INSERT INTO constellation (id, name) VALUES (3, '˫����');
//	INSERT INTO constellation (id, name) VALUES (4, '��з��');
//	INSERT INTO constellation (id, name) VALUES (5, 'ʨ����');
//	INSERT INTO constellation (id, name) VALUES (6, '��Ů��');
//	INSERT INTO constellation (id, name) VALUES (7, '�����');
//	INSERT INTO constellation (id, name) VALUES (8, '��Ы��');
//	INSERT INTO constellation (id, name) VALUES (9, '������');
//	INSERT INTO constellation (id, name) VALUES (10, 'Ħ����');
//	INSERT INTO constellation (id, name) VALUES (11, 'ˮƿ��');
//	INSERT INTO constellation (id, name) VALUES (12, '˫����');
	
//	CREATE TABLE User (ID integer PRIMARY KEY AUTOINCREMENT, constellationID INTEGER REFERENCES constellation (id), typeID INTEGER REFERENCES Type (id), gradeID INTEGER, actionID INTEGER REFERENCES "action" (id), name CHAR, high INTEGER, age INTEGER, nationality CHAR, location CHAR);
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (1, 1, 1, 1, 1, '��', 182, 20, '�й�', '���׶�');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (2, 2, 1, 1, 2, '��³�ϰ�', 210, 20, '����', '����');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (3, 3, 1, 1, 3, '����', 188, 28, 'ϣ��', 'ϣ��ʥ��');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (4, 3, 1, 1, 4, '��¡', 188, 28, 'ϣ��', 'ϣ��ʥ��');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (5, 4, 1, 1, 5, '��˹��˹��', 184, '', '�����', '�����ﵺ');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (6, 5, 1, 1, 6, '��������', 185, 20, 'ϣ��', 'ϣ��ʥ��');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (7, 6, 1, 1, 7, 'ɳ��', 182, NULL, 'ӡ��', '�������');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (8, 7, 1, 1, 8, 'ͯ��', 170, 261, '�й�', '®ɽ���Ϸ�');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (9, 8, 1, 1, 9, '����', 185, 20, '�¹�', 'ϣ���׶�˹��');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (10, 9, 1, 1, 10, '������˹', 187, 13, 'ϣ��', 'ϣ��ʥ��');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (11, 10, 1, 1, 11, '����', 186, 23, '������', '����ţ˹ɽ��');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (12, 11, 1, 1, 12, '����', 184, 20, '����', '��������');
//	INSERT INTO User (ID, constellationID, typeID, gradeID, actionID, name, high, age, nationality, location) VALUES (13, 12, 1, 1, 13, '�����޵�', 184, 22, '���', '��������');
	
//	CREATE TABLE Type (id integer PRIMARY KEY AUTOINCREMENT, name varchar (30));
//	INSERT INTO Type (id, name) VALUES (1, 'ʥ��ʿ');
//	INSERT INTO Type (id, name) VALUES (2, '����ʿ');
//	INSERT INTO Type (id, name) VALUES (3, '��ʿ');
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
