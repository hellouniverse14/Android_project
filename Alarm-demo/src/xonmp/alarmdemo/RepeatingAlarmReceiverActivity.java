package xonmp.alarmdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RepeatingAlarmReceiverActivity extends Activity{
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        
        			   Button buttonstop= (Button)(findViewById(R.id.stopAlarm)); 
                       buttonstop.setOnClickListener(new OnClickListener() {
 		
                    	   
                    	   public void onClick(View w) {
 		
                    		   								finish();
 			
                    	   								}
 	});
        

}
}
