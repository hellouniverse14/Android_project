package xonmp.alarmdemo;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmReceiverActivity extends Activity{
	
	
	private MediaPlayer mMediaPlayer;
	private PowerManager.WakeLock mWakeLock;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	      //  setContentView(R.layout.main);
	        
	        
	        PowerManager pm= (PowerManager)getSystemService(Context.POWER_SERVICE);
	        mWakeLock= pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "MY WAKE LOG");
	        mWakeLock.acquire();
	        
	        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
	        		WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | 
	        		WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED, 
	        		WindowManager.LayoutParams.FLAG_FULLSCREEN | 
	        		WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | 
	        		WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
	        
	        setContentView(R.layout.alarm);
	     
	        
	        
	        Button buttonstop= (Button)(findViewById(R.id.stopAlarm)); 
	    
	       
	       buttonstop.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View w) {
			mMediaPlayer.stop();
			finish();
				
			}
		});
	       
	       
	       
	    
	    playSound(this,getAlarmUri());
	    
	    }
	    private void playSound(Context context, Uri alert)
	    {
	    	mMediaPlayer= new MediaPlayer();
	    	
	    	
	    	try{
	    		
	    		mMediaPlayer.setDataSource(context, alert);
	    		final AudioManager audiomanager=(AudioManager)(context.getSystemService(context.AUDIO_SERVICE));
	    		
	    		if(audiomanager.getStreamVolume(audiomanager.STREAM_ALARM)!=0)
	    		{
	    				mMediaPlayer.setAudioStreamType(audiomanager.STREAM_ALARM);
	    				mMediaPlayer.prepare();
	    				mMediaPlayer.start();
	    		}
	    	
	    	
	    	
	    	}
	    	catch(Exception e)
	    	{
	    			Log.i("AlarmReceiver","NO AUDIO");
	    			
	    	
	    	}
	    	
	    	
	    }
	    private Uri getAlarmUri()
	    {
	    		Uri alert=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
	    		if(alert==null)
	    		{
	    				alert= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
	    				if(alert==null)
	    				{
	    						alert= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
	    				}
	    		}
	    		
	    		return alert;
	    }
	    public void onStop()
	    {
	    		super.onStop();
	    		mWakeLock.release();
	    }

	    
	}


