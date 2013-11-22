package com.example.sim;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Setup extends Activity {
    /** Called when the activity is first created. */

TextView tw;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tw=(TextView)findViewById(R.id.tw1);

        TelephonyManager mtele= (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    	String newid=mtele.getDeviceId();
    	String simid=mtele.getSimSerialNumber();

        tw.setText(simid);
        
        Toast.makeText(getApplicationContext(), "DEVICE STARTUP",Toast.LENGTH_LONG).show();
        
        /*button1.setOnClickListener(new OnClickListener() {
    		
    		@SuppressWarnings("deprecation")
			@Override
    		public void onClick(View v) {
    			//nameView.setText("hello"+nameField.getText());
    			
    			
    			
    			TelephonyManager mtele= (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    			String newid=mtele.getDeviceId();
    			String simid=mtele.getSimSerialNumber();
    			if(simid.equals(null))
    			{
    			et.setText("hello"+"null");
    			
    			}
    			else
    				
    				{
    				et.setText("hel2lo"+simid);
    				SmsManager smsManager = SmsManager.getDefault();
    				smsManager.sendTextMessage("09972816775", null, et.getText().toString(), null, null);
    				Toast.makeText(getApplicationContext(), "SMS Sent!",Toast.LENGTH_LONG).show();
    				
    				
    				}
    			
    		}
     });*/
    }
	
	
		
	


}
