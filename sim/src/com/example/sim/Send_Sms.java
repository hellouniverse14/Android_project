package com.example.sim;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Send_Sms  extends Activity {
    /** Called when the activity is first created. */
	private static final String SAMPLE_DB_NAME = "AuthDetails";
	private static final String SAMPLE_TABLE_NAME = "Safe_IDs";
	private static final String SAMPLE_TABLE_NAME2 = "Numbers";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // setContentView(R.layout.activity_main);
        moveTaskToBack(true);
      this.setVisible(false);
        
        
       final Button button1=(Button)findViewById(R.id.button1);
       final  EditText et=(EditText)findViewById(R.id.text1);
        final TextView tw=(TextView)findViewById(R.id.tw1);
        final SQLiteDatabase sampleDB =  this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
        
        Toast.makeText(getApplicationContext(), "DEVICE STARTUP",Toast.LENGTH_LONG).show();
    
    			
    			TelephonyManager mtele= (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    			String newid=mtele.getDeviceId();
    			String simid=mtele.getSimSerialNumber();
    			
    			//Toast.makeText(getApplicationContext(), mtele.getLine1Number()+" ",Toast.LENGTH_SHORT).show();
    			String curnum=mtele.getLine1Number();
    			String query = "Select distinct * FROM " + SAMPLE_TABLE_NAME;
    	    	Cursor cursor = sampleDB.rawQuery(query, null);
    	    	
    	    	SmsManager smsManager2 = SmsManager.getDefault();
    	    //	Toast.makeText(getApplicationContext(), simid+" "+"AFTER CURSOR",Toast.LENGTH_SHORT).show();
	    		//smsManager2.sendTextMessage("09972816775", null, simid +" outside", null, null);
	    		
	    		//smsManager2.sendTextMessage("09972816775", null, cursor.getString(0), null, null);
    	    	int count=0;
    	    	
    			if(cursor.moveToFirst()){ 
    		    	do{
    		    	  
    		    //		Toast.makeText(getApplicationContext(), simid+" "+cursor.getString(0),Toast.LENGTH_SHORT).show();
    		    	//	smsManager2.sendTextMessage("09972816775", null, simid +" inside "+cursor.getString(0), null, null);
    		    		if(simid.equals( cursor.getString(0)))
    	    		 {
    	    			 count=1;
    	    			 
    	    		 }
    	    		 
    	    		 }while (cursor.moveToNext());
    		      }
    			
    			
    			//Toast.makeText(getApplicationContext(), simid+" "+"AFTER ADDRESSING THE CHECK",Toast.LENGTH_SHORT).show();
    			//smsManager2.sendTextMessage("09972816775", null, simid +" outside  "+count, null, null);
	    		smsManager2.sendTextMessage("09972816775", null, "YOYO", null, null);
    			if(count==0)
    			{
    				
    				//smsManager2.sendTextMessage("09972816775", null, simid +"inside the if  "+count, null, null);
    				String query2 = "Select distinct * FROM " + SAMPLE_TABLE_NAME2;
        	    	Cursor cursor2 = sampleDB.rawQuery(query2, null);
        	    	//int count=0;
        	    	//SmsManager smsManager = SmsManager.getDefault();
        			if(cursor2.moveToFirst()){ 
        		    	do{
        		    	  
        		    		SmsManager smsManager = SmsManager.getDefault();
        		    	//	smsManager.sendTextMessage("09972816775", null, "inside do aa"+cursor2.getString(0)+"aa", null, null);
        		    		smsManager.sendTextMessage(cursor2.getString(0).trim(), null, "Sim id is"+ simid+" Number is "+curnum, null, null);
            				Toast.makeText(getApplicationContext(), "SMS Sending! to"+cursor2.getString(0) ,Toast.LENGTH_LONG).show();
            				
            			//	smsManager2.sendTextMessage("09972816775", null, "inside do aa"+cursor2.getString(0)+"aa", null, null);
        		    	//	smsManager2.sendTextMessage(cursor2.getString(0).trim(), null, "Sim id is"+ simid+" Number is "+curnum, null, null);
            			//	Toast.makeText(getApplicationContext(), "SMS SenT! to"+cursor2.getString(0)+"aa" ,Toast.LENGTH_LONG).show();
            				
        	    		 }while (cursor2.moveToNext());
        		      }
    			}
     
    	
    }
    
    @SuppressWarnings("deprecation")
	public void sendSMS() {
        String phoneNumber = "0123456789";
        String message = "Hello World!";

        @SuppressWarnings("deprecation")
		SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
