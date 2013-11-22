package com.example.sim;

//import simchange.proje.simchanged.gen.com.example.simchanged.R;
//import simchange.proje.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	
    private static final String SAMPLE_DB_NAME = "AuthDetails";
	private static final String SAMPLE_TABLE_NAME = "Safe_IDs";
	private static final String SAMPLE_TABLE_NAME2 = "Numbers";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Settings");
        setContentView(R.layout.main);
            TelephonyManager mtele= (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String newid=mtele.getDeviceId();
		String phno=mtele.getSubscriberId();
		final String simid=mtele.getSimSerialNumber();
        final TextView tw=(TextView)findViewById(R.id.tw1);
        tw.setText("Sim Id = "+simid);
        
    
    	final SQLiteDatabase sampleDB =  this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
			sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " +
	                SAMPLE_TABLE_NAME +
	                " (Simid VARCHAR);");
			sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " +
	                SAMPLE_TABLE_NAME2 +
	                " (Nums VARCHAR);");
	    
			
			Button b2=(Button)findViewById(R.id.button2);//to add current simid to table
			Button b4=(Button)findViewById(R.id.button4);
			Button b5=(Button)findViewById(R.id.button5);
			
			b4.setOnClickListener(new OnClickListener() {
	    		
	    	
	    		public void onClick(View v) {
	    			Intent i= new Intent(MainActivity.this, Phno.class);	
	    			startActivity(i);
	    		}
	     });
			
			b5.setOnClickListener(new OnClickListener() {
	    		
	    		
	    		public void onClick(View v) {
	    			Intent i= new Intent(MainActivity.this, SafeDb.class);
	    			startActivity(i);
	    		}
	     });
			
			 b2.setOnClickListener(new OnClickListener() {
		    		
		    		@SuppressWarnings("deprecation")
					@Override
		    		public void onClick(View v) {
		    			sampleDB.execSQL("INSERT INTO " +SAMPLE_TABLE_NAME +" Values ('"+simid+"');");	
		    		}
		     });
			 
		//b2.setVisibility(View.INVISIBLE);	 
			 Button b3=(Button)findViewById(R.id.button3);
			 final EditText et1=(EditText)findViewById(R.id.editText1);
			 
			 b3.setOnClickListener(new OnClickListener() {
		    		
		    		@SuppressWarnings("deprecation")
					@Override
		    		public void onClick(View v) {
		    			
		    			sampleDB.execSQL("INSERT INTO " +SAMPLE_TABLE_NAME2 +" Values ('"+et1.getText().toString()+"');");	
		    			et1.setText("");
		    		}
		     });
			 
			 
		/*	 Button b1=(Button)findViewById(R.id.button1);//to add current simid to table
				
			 b1.setOnClickListener(new OnClickListener() {
		    		
		    		@SuppressWarnings("deprecation")
					@Override
		    		public void onClick(View v) {	
		    			String query = "Select * FROM " + SAMPLE_TABLE_NAME;
				    	Cursor cursor = sampleDB.rawQuery(query, null);
				    
				    	 if(cursor.moveToFirst()){ 
						    	do{
						    	  
					    		 Log.i("chechDb1", cursor.getString(0));
					    		 }while (cursor.moveToNext());
						      }
				    	 
				    	  query = "Select * FROM " + SAMPLE_TABLE_NAME2;
					    	 cursor = sampleDB.rawQuery(query, null);
					    
					    	 if(cursor.moveToFirst()){ 
							    	do{
							    	  
						    		 Log.i("checkDb2", cursor.getString(0));
						    		 }while (cursor.moveToNext());
							      }
					    	 
					    	 sampleDB.execSQL("DROP TABLE "+SAMPLE_TABLE_NAME);
					    	 sampleDB.execSQL("DROP TABLE "+SAMPLE_TABLE_NAME2);
		    
		    		}
		     });*/
			     
    }
    
   // @SuppressWarnings("deprecation")
	/*public void sendSMS() {
        String phoneNumber = "0123456789";
        String message = "Hello World!";

        @SuppressWarnings("deprecation")
		SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }*/
}
