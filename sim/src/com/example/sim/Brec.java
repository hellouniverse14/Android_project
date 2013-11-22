package com.example.sim;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.webkit.WebView.FindListener;

public class Brec extends BroadcastReceiver{

	
    @Override
    public void onReceive(Context context, Intent intent) {
    	
    	
            Intent i = new Intent(context, Send_Sms.class);  
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            
            //JUST CHECK IN DB AND SEND MESSAGE
            context.startActivity(i);  
    }

}

