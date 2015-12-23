package com.cirrius.calender.listview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

	Context context;
	private static DBHandler DBHnadlerInstance = null;
	private static final String DATABASE_NAME = "DBCG";
	private static final int DATABASE_VERSION = 2;
	static SQLiteDatabase db;

	final String TBCONTROL = "TBControl";

	final String TBSYS000 = "TBSYS000";

	private DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;

		db = this.getWritableDatabase();

	}

	public static DBHandler getInstance(Context ctx) {

		if (DBHnadlerInstance == null) {
			DBHnadlerInstance = new DBHandler(ctx);

		}
		return DBHnadlerInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		if (oldVersion < newVersion) {
		}
	}

	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();

		// if(dbExist){
		// //do nothing - database already exist
		// }else{

		// By calling this method and empty database will be created into the
		// default system path
		// of your application so we are gonna be able to overwrite that
		// database with our database.
		this.getReadableDatabase();

		try {

			copyDataBase();

		} catch (IOException e) {

			throw new Error("Error copying database");

		}
		// }

	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			String myPath = context.getDatabasePath(DATABASE_NAME) + "";

			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}

	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = context.getAssets().open(DATABASE_NAME);

		// Path to the just created empty db
		String outFileName = context.getDatabasePath(DATABASE_NAME) + "";

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	// create all required tables

	public void createTables(boolean isSecond_db) {

		SQLiteDatabase db = this.getWritableDatabase();

		try {

			// table for transaction
			db.execSQL("CREATE TABLE " + TBSYS000// CLientid+USERID+PWD,INSATNCEID,LAST
													// SYNCDATe,LASTLOGIN,PWDCHNG
													// DATE,CPFFLAG,auto
					// increment no for unique identify
					+ "( COL0 TEXT,COL1 TEXT,COL2 TEXT,COL3 TEXT,COL4 TEXT,COL5 TEXT,COL6 INTEGER PRIMARY KEY AUTOINCREMENT ,COL7 TEXT,COL8 TEXT,COL9 TEXT,COL10 TEXT,COL11 TEXT,COL12 TEXT)");

			db.execSQL("CREATE TABLE "
					+ "TB201508"
					+ "( COL0 TEXT,COL1 TEXT,COL2 TEXT,COL3 TEXT,COL4 TEXT,COL5 TEXT,"
					+ "COL6 TEXT,COL7 TEXT,COL8 TEXT,COL9 TEXT,COL10 TEXT,COL11 TEXT,"
					+ "COL12 TEXT,COL13 TEXT,COL14 TEXT,COL15 TEXT,COL16 TEXT,COL17 TEXT,"
					+ "COL18 TEXT,COL19 TEXT,COL20 TEXT,COL21 TEXT,COL22 TEXT,COL23 TEXT,"
					+ "COL24 TEXT,COL25 TEXT,COL26 TEXT,COL27 TEXT,COL28 TEXT,COL29 TEXT,"
					+ "COL30 TEXT,COL31 TEXT,COL32 TEXT,COL33 TEXT,COL34 TEXT,COL35 TEXT,"
					+ "COL36 TEXT,COL37 TEXT,COL38 TEXT,COL39 TEXT,COL40 TEXT,COL41 TEXT,"
					+ "COL42 TEXT,COL43 TEXT,COL44 TEXT,COL45 TEXT,COL46 TEXT,COL47 TEXT,"
					+ "COL48 TEXT,COL49 TEXT,COL50 TEXT,COL51 TEXT,COL52 TEXT,COL53 TEXT,"
					+ "COL54 TEXT,COL55 TEXT,COL56 TEXT,COL57 TEXT,COL58 TEXT,COL59 TEXT,"
					+ "COL60 TEXT,COL61 TEXT,COL62 TEXT,COL63 TEXT,COL64 TEXT,COL65 TEXT,"
					+ "COL66 TEXT,COL67 TEXT,COL68 TEXT,COL69 TEXT,COL70 TEXT,COL71 TEXT,"
					+ "COL72 TEXT,COL73 TEXT,COL74 TEXT,COL75 TEXT,COL76 TEXT,COL77 TEXT,"
					+ "COL78 TEXT,COL79 TEXT,COL80 TEXT,COL81 TEXT,COL82 TEXT,COL83 TEXT,"
					+ "COL84 TEXT,COL85 TEXT,COL86 TEXT,COL87 TEXT,COL88 TEXT,COL89 TEXT,"
					+ "COL90 TEXT,COL91 TEXT,COL92 TEXT,COL93 TEXT,COL94 TEXT,COL95 TEXT,"
					+ "COL96 TEXT)");

			System.out.println("table created");
		} catch (Exception exp) {
			System.out.println("Error in table creation " + exp);
			exp.printStackTrace();
		} finally {
			// db.close();
			close();
		}
	}

	// create all required tables
	public boolean executscript() {
		long starttime = System.currentTimeMillis();

		boolean TAG_CHECK = true;
		int count = 0;
		SQLiteDatabase db = this.getWritableDatabase();

		File dirFiles = context.getFilesDir();
		for (String strFile : dirFiles.list()) {
			if (strFile.endsWith(".sql")) {
				try {
					count = DbUtils.executeSqlScript(context, db, strFile,
							true, false);
					if (count > 0) {

						String path = context.getFilesDir() + "/" + strFile;
						File file = new File(path);
						file.delete();
					}

				} catch (IOException e) {
					TAG_CHECK = false;
				}
			}
		}

		return TAG_CHECK;

	}

	public void tp() {
		SQLiteDatabase db = this.getWritableDatabase();
		try {
			DbUtils.executeSqlScript(context, db, "kb.sql", true, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[][] genericSelect(String query, int noCols) {
		String strData[][] = null;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cur = null;
		try {
			cur = db.rawQuery(query, new String[] {});
			int noOfRows = cur.getCount();
			int count = 0;
			if (noOfRows > 0) {
				strData = new String[noOfRows][noCols];
				while (cur.moveToNext()) {
					for (int i = 0; i < noCols; i++) {
						strData[count][i] = cur.getString(i);
					}
					count++;
				}
			}
		} catch (Exception e) {
			System.out.println("In getallData block------->" + e);
		} finally {
			if (cur != null && !cur.isClosed())
				cur.close();
			// db.close();
			close();
		}
		return strData;
	}

	public boolean genericUpdate(String table, int ColNo, String updateString,
			int keyCol, String key) {
		boolean str_return = true;
		SQLiteDatabase db = this.getWritableDatabase();
		try {
			ContentValues cv = new ContentValues();
			try {
				cv.put("COL" + ColNo, updateString);
				long rowId = db.update(table, cv, "COL" + keyCol + " = ?",
						new String[] { key });
				if (rowId == -1) {
					str_return = false;
				}
			} catch (Exception e) {
				str_return = false;
			}
		} finally {
			// db.close();
			close();
		}
		return str_return;
	}

	public int check_control_table() {

		int a = 0;
		String[][] tablesname = genericSelect(
				"SELECT name FROM sqlite_master  where name!='TBControl' and  name!='android_metadata'",
				1);

		for (int i = 0; i < tablesname.length; i++) {

			try {

				String countQuery = "SELECT * FROM " + tablesname[i][0];
				SQLiteDatabase db = this.getReadableDatabase();
				Cursor cursor = db.rawQuery(countQuery, null);
				int cnt = cursor.getCount();

				String countQuery1 = "SELECT COL2 FROM TBCONTROL Where COL1='"
						+ tablesname[i][0].substring(2,
								tablesname[i][0].length()) + "'";

				Cursor cursor1 = db.rawQuery(countQuery1, null);

				cursor1.moveToNext();

				String old = cursor1.getString(0);
				String diff = "" + (Integer.parseInt(old) - cnt);

				ContentValues cv = new ContentValues();
				cv.put("COL3", cnt);
				cv.put("COL4", diff);
				String query = "UPDATE TBControl set COL3 = '"
						+ cnt
						+ "' , COL4 = '"
						+ diff
						+ "' Where COL1='"
						+ tablesname[i][0].substring(2,
								tablesname[i][0].length()) + "'";
				db.execSQL(query);
				a = 1;
				cursor.close();
			} catch (Exception e) {
				a = 0;
				e.printStackTrace();
			}
		}

		return 11;
	}

	public String hardcodequery(String query) {

		String strReturn = "success";
		SQLiteDatabase db = this.getWritableDatabase();
		try {
			db.execSQL(query);
		} catch (Exception e) {
			strReturn = "error";
			e.printStackTrace();
		}

		return strReturn;
	}

	public String insertDATA(String tablename, String data[]) {

		String strReturn = "success";
		SQLiteDatabase db = this.getWritableDatabase();
		try {
			ContentValues cv = new ContentValues();

			for (int i = 0; i < data.length; i++) {

				cv.put("COL" + i, data[i]);
			}

			long rowId = db.insert(tablename, null, cv);
			if (rowId == -1) {
				strReturn = "error";
			}

		} catch (Exception exp) {
			strReturn = "error";
			exp.printStackTrace();
		} finally {

			// db.close();
			close();
		}
		return strReturn;

	}

	public String UpdateSystable(HashMap<String, String> hasmap,
			String lastsyncDate, String LASTLOGIN, String PWDCHNGdate,
			String CPFFLAG, String pwdchnageFirsttime) {
		return pwdchnageFirsttime;}

	public String[][] genericSelect(String select, String tableName,
			String where, String groupBy, String having, int noCols) {
		String strData[][] = null;
		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT " + select + " FROM " + tableName;
		if (!where.equals("")) {
			query = query + " WHERE " + where;
		}
		if (!groupBy.equals("")) {
			query = query + " GROUP BY " + groupBy;
		}
		if (!having.equals("")) {
			query = query + " HAVING " + having;
		}
		Cursor cur = null;
		try {
			cur = db.rawQuery(query, new String[] {});
			int noOfRows = cur.getCount();
			int count = 0;
			if (noOfRows > 0) {
				strData = new String[noOfRows][noCols];
				while (cur.moveToNext()) {
					for (int i = 0; i < noCols; i++) {
						strData[count][i] = cur.getString(i);
					}
					count++;
				}
			}
		} catch (Exception e) {
			System.out.println("In getallData block------->" + e);
		} finally {
			if (cur != null && !cur.isClosed())
				cur.close();
			// db.close();
			close();
		}

		return strData;
	}

	public Cursor getAllBooks(String tableName) {

		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT *  FROM " + tableName;

		Cursor cur = null;
		try {
			cur = db.rawQuery(query, new String[] {});
			int noOfRows = cur.getCount();
			if (noOfRows > 0) {
			}
			cur.moveToFirst();
		} catch (Exception e) {
			System.out.println("In getallData block------->" + e);
		} finally {
			// if (cur != null && !cur.isClosed())
			// cur.close();
			// db.close();
			// close();
		}
		return cur;

	}
}
