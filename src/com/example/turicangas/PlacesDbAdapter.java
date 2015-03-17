package com.example.turicangas;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PlacesDbAdapter extends SQLiteOpenHelper {
	
	
	
	public static final String KEY_ROWID = "_id";
	//public static final String KEY_PIC = "pic";
	public static final String KEY_NAME = "name";
	public static final String KEY_LAT = "latitude";
	public static final String KEY_LNG = "longitude";
	public static final String KEY_SRC = "source";
	
	 
	 private static final String TAG = "PlacesDbAdapter";
	 
	
	 
	 private static final String DATABASE_NAME = "Cangas";
	 private static final String SQLITE_TABLE = "Places";
	 private static final String SQLITE_TABLE_PICS = "Pics";
	 
	 private static final int DATABASE_VERSION = 1;
	 
	 
	 
	 private static final String DATABASE_CREATE_PLACES =
	  "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
	  KEY_ROWID + " INTEGER PRIMARY KEY," +
	  KEY_NAME +" TEXT,"+KEY_LAT+" TEXT,"+KEY_LNG+" TEXT"+")";
	 
	 private static final String DATABASE_CREATE_PICS =
			  "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
			  KEY_ROWID + " INTEGER PRIMARY KEY," +
			  KEY_NAME +" TEXT,"+KEY_SRC+" TEXT)";
	 
	 
	 PlacesDbAdapter(Context context) {
		 super(context, DATABASE_NAME, null, DATABASE_VERSION);
	 }
  
	 @Override
	 public void onCreate(SQLiteDatabase mdb) {
		 Log.w(TAG, DATABASE_CREATE_PLACES);
		 mdb.execSQL(DATABASE_CREATE_PLACES);
		 mdb.execSQL(DATABASE_CREATE_PICS);
	 }
 
	 @Override
	 public void onUpgrade(SQLiteDatabase mdb, int oldVersion, int newVersion) {
		 Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
				 + newVersion + ", which will destroy all old data");
		 mdb.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
		 onCreate(mdb);
	 }
	 

		 
	 
	
	public void createPlace(Place p) { 
		
		SQLiteDatabase mdb = this.getWritableDatabase();		 
		ContentValues initialValues = new ContentValues();
			//initialValues.put(KEY_CODE, code);
			initialValues.put(KEY_NAME, p.getName());
			initialValues.put(KEY_LAT, p.getLat());
			initialValues.put(KEY_LNG, p.getLng());
		
				 
			try{	// Inserting Row
		        mdb.insert(SQLITE_TABLE, null, initialValues);
		        
		    }
		    catch(SQLiteException e){
		    	Log.v("tag","error sql"+e.getMessage());
		    }
		        mdb.close(); // Closing database connection 		  
	}
	
	public List<Place> getPlaces() {
		List<Place> places = new ArrayList<Place>();
		
		String selectQuery = "SELECT * FROM " + SQLITE_TABLE + " ORDER BY " + KEY_NAME;
		
		SQLiteDatabase mdb = this.getWritableDatabase();
        Cursor mCursor = mdb.rawQuery(selectQuery, null);
        
        
        
        if (mCursor.moveToFirst()) {
            do {
            	Place place = new Place();
            	place.setID(mCursor.getInt(0));
            	place.setName(mCursor.getString(1));
            	place.setLat(mCursor.getString(2));
            	place.setLng(mCursor.getString(3));
            	places.add(place);
            	
            }while(mCursor.moveToNext());
        }
        
        mCursor.close();
        return places;
	}
	
	public boolean isEmpty(){
		
		String selectQuery = "SELECT * FROM " + SQLITE_TABLE + " ORDER BY " + KEY_NAME;
		
		SQLiteDatabase mdb = this.getWritableDatabase();
        Cursor mCursor = mdb.rawQuery(selectQuery, null);
        
        return mCursor.getCount()<=0;
		
	}
	

}

