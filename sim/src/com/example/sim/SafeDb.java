package com.example.sim;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class SafeDb extends Activity {

	

	 private static final String SAMPLE_DB_NAME = "AuthDetails";
		private static final String SAMPLE_TABLE_NAME = "Safe_IDs";
		private static final String SAMPLE_TABLE_NAME2 = "Numbers";
		CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10;
		
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTitle("Authenticating Sim IDs");
		setContentView(R.layout.activity_safe_db);
		
		
		final SQLiteDatabase sampleDB =  this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
		String query = "Select distinct * FROM " + SAMPLE_TABLE_NAME;
    	Cursor cursor = sampleDB.rawQuery(query, null);
    	int count=0;
		if(cursor.moveToFirst()){ 
	    	do{
	    	  
    		 Log.i("chechDb1 inside", cursor.getString(0));
    		 count++;
    		 }while (cursor.moveToNext());
	      }
		
		cb1=(CheckBox)findViewById(R.id.cb1);
		cb2=(CheckBox)findViewById(R.id.cb2);
		cb3=(CheckBox)findViewById(R.id.cb3);
		cb4=(CheckBox)findViewById(R.id.cb4);
		cb5=(CheckBox)findViewById(R.id.cb5);
		cb6=(CheckBox)findViewById(R.id.cb6);
		cb7=(CheckBox)findViewById(R.id.cb7);
		cb8=(CheckBox)findViewById(R.id.cb8);
		
		cb1.setVisibility(View.INVISIBLE);
		cb2.setVisibility(View.INVISIBLE);
		cb3.setVisibility(View.INVISIBLE);
		cb4.setVisibility(View.INVISIBLE);
		cb5.setVisibility(View.INVISIBLE);
		cb6.setVisibility(View.INVISIBLE);
		cb7.setVisibility(View.INVISIBLE);
		cb8.setVisibility(View.INVISIBLE);
		
		if(count>=1)
		{
			cursor.moveToFirst();
			
					
					cb1.setText(cursor.getString(0));
					cb1.setVisibility(View.VISIBLE);
			
			
		}
		if(count>=2)
		{
			cursor.moveToNext();
		      
				
					
					cb2.setText(cursor.getString(0));
					cb2.setVisibility(View.VISIBLE);
			
		}
		if(count>=3)
		{
			cursor.moveToNext();
		      
				
					
					cb3.setText(cursor.getString(0));
					cb3.setVisibility(View.VISIBLE);
			
		}
		if(count>=4)
		{
			cursor.moveToNext();
			
					
					cb4.setText(cursor.getString(0));
					cb4.setVisibility(View.VISIBLE);
			
			
		}
		if(count>=5)
		{
			cursor.moveToNext();
					
					cb5.setText(cursor.getString(0));
					cb5.setVisibility(View.VISIBLE);
			
			
		}
		if(count>=6)
		{
			cursor.moveToNext();
			
					
					cb6.setText(cursor.getString(0));
					cb6.setVisibility(View.VISIBLE);
			
		}
		if(count>=7)
		{
			cursor.moveToNext();
			
					
					cb7.setText(cursor.getString(0));
					cb7.setVisibility(View.VISIBLE);
			
		}
		if(count>=8)
		{
			cursor.moveToNext();
			
					
					cb8.setText(cursor.getString(0));
					cb8.setVisibility(View.VISIBLE);
			
		}
		
		Button b1=(Button)findViewById(R.id.button1);
		Button b2=(Button)findViewById(R.id.button2);
		 b1.setOnClickListener(new OnClickListener() {
	    		
				String q="";
	    		public void onClick(View v) {
	    			
	    			if(cb1.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb1.getText()+"'");
	    			}
	    			if(cb2.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb2.getText()+"'");
	    			} 
	    			if(cb3.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb3.getText()+"'");
	    			} 
	    			if(cb4.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb4.getText()+"'");
	    			} 
	    			if(cb5.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb5.getText()+"'");
	    			} 
	    			if(cb6.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb6.getText()+"'");
	    			} 
	    			if(cb7.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb7.getText()+"'");
	    			} 
	    			if(cb8.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb8.getText()+"'");
	    			} 
	    			if(cb1.isChecked()){
	    				sampleDB.execSQL("DELETE FROM " +SAMPLE_TABLE_NAME +" WHERE Simid='"+cb1.getText()+"'");
	    			} 
	    			
	    			
	    			
	    		Intent i= new Intent(SafeDb.this, SafeDummy.class);	
	    		startActivity(i);
	    		}
	    		
	    		
	     });
		 
		 b2.setOnClickListener(new OnClickListener() {
	    		
				String q="";
	    		public void onClick(View v) {
	    			
	    			
	    			Intent i= new Intent(SafeDb.this, MainActivity.class);	
		    		startActivity(i);
		    		}
		    		
		    		
		     });
			
	    		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_safe_db, menu);
		return true;
	}

}
