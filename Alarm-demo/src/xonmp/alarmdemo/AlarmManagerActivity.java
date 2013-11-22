package xonmp.alarmdemo;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmManagerActivity extends Activity implements OnClickListener {
    

	private Button buttonstart1,buttonstart2,buttonstop, select;
	private EditText edittext;
	private Toast toast;
	private ImageButton ib;
	 private Calendar cal;
	 private int hour333;
	 private int min333;
	 private EditText et;
	 int seco;
	 Dialog picker;
	 Button set;
	 TimePicker timep;
	 DatePicker datep;
	 Integer hoursss,minutesss,monthsss,daysss,yearsss;
	
	 public void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        	buttonstart1= (Button)(findViewById(R.id.setAlarmOneshot)); 
	        	buttonstart2= (Button)(findViewById(R.id.setAlarmRepeating));
	        	buttonstop= (Button)(findViewById(R.id.stopAlarmRepeating));
	        	edittext= (EditText)(findViewById(R.id.textseconds));
	        	
	        	
	        //	ib = (ImageButton) findViewById(R.id.imageButton2);
	        	  cal = Calendar.getInstance();
	        	  hour333 = cal.get(Calendar.HOUR_OF_DAY);
	        	  min333 = cal.get(Calendar.MINUTE);
	        	//  et = (EditText) findViewById(R.id.editText);
	        	//  ib.setOnClickListener(this);
	        	  select = (Button)findViewById(R.id.btnSelect);
	            
	              select.setOnClickListener(new View.OnClickListener() {
	       
	                  @Override
	                  public void onClick(View view) {
	                      // TODO Auto-generated method stub
	                      picker = new Dialog(AlarmManagerActivity.this);
	                      picker.setContentView(R.layout.picker_frag);
	                      picker.setTitle("Select Date and Time");
	       
	                      datep = (DatePicker)picker.findViewById(R.id.datePicker);
	                      timep = (TimePicker)picker.findViewById(R.id.timePicker1);
	                      set = (Button)picker.findViewById(R.id.btnSet);
	       
	                      set.setOnClickListener(new View.OnClickListener() {
	       
	                          @Override
	                          public void onClick(View view) {
	                              // TODO Auto-generated method stub
	                              monthsss = datep.getMonth();
	                              daysss = datep.getDayOfMonth();
	                              yearsss = datep.getYear();
	                              hoursss = timep.getCurrentHour();
	                              minutesss = timep.getCurrentMinute();
	                             // time.setText("Time is "+hour+":" +minute);
	       
	                            edittext.setText(""+daysss+"/"+monthsss+"/"+yearsss+"T "+hoursss+":" +minutesss);
	                              picker.dismiss();
	                          }
	                      });
	                      picker.show();
	       
	                  }
	              });    
	       
	              
	        
	        	  
	        	buttonstart1.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View v) {
					
						
						Date dt= new Date();
						int hours=dt.getHours();
						int mins=dt.getMinutes();
						int secs=dt.getSeconds();
						int days=dt.getDate();
						int month= dt.getMonth();
						month+=1;
						
						int year=dt.getYear();
						year=year%100;
						String cmp=year+"";
						if(month>9)
							cmp=cmp+(month+"");
						else
							cmp=cmp+("0"+month+"");
						if(days>9)
							cmp=cmp+(days+"");
						else
							cmp=cmp+("0"+days+"");
						if(hours>9)
							cmp=cmp+(hours+"");
						else
							cmp=cmp+("0"+hours+"");
						if(mins>9)
							cmp=cmp+(mins+"");
						else
							cmp=cmp+("0"+mins+"");
						
					
						Log.i("tagged","currenttime"+""+cmp);
						Log.i("tagged","passedtime"+""+(((yearsss%100)+""+monthsss+""+daysss+""+hoursss+""+minutesss+"")+""));
						//cmp=cmp+(sec+"");
						
						/*String endate=caltext.getText().toString();
						endate=endate.substring(2);
					
						String entime=timetext.getText().toString();
						endate=endate+entime;
						Log.i("tagged","enterredtime"+""+endate);
						
						int cur=Integer.parseInt(cmp);
						int ent=Integer.parseInt(endate);
						if(cur>ent)
						{	
							Log.i("tagged","diff"+""+(cur-ent));
								Toast.makeText(getApplicationContext(), "Time already passed", Toast.LENGTH_LONG).show();
						}
						else
						{
						
						
						//now to calculate the time
					/*	String yr=(caltext.getText().toString()).substring(0, 4);
						String mon=(caltext.getText().toString()).substring(4, 6);
						String day=(caltext.getText().toString()).substring(6, 8);
						String hr=(timetext.getText().toString()).substring(0, 2);
						String min=(timetext.getText().toString()).substring(2, 4);
					//	String seconds=(timetext.getText().toString()).substring(4, 6);
						Log.i("tagged",(yr+mon+day+hr+min));
						int y=Integer.parseInt(yr);
						int m=Integer.parseInt(mon);
						int d=Integer.parseInt(day);
						int h=Integer.parseInt(hr);
						int mi=Integer.parseInt(min);
						//int s=Integer.parseInt(seconds);*/
						
					long current=dt.UTC(year, month, days, hours, mins, secs);
						Log.i("currentmilli",current+"");
						long passed= dt.UTC(yearsss-2000, monthsss+1, daysss, hoursss, minutesss, 0);
						Log.i("passedmilli",passed+"");
						 seco=(int)((passed-current)/1000);
						Log.i("tagged",seco+"");
						
						try{
							
							//int seco=Integer.parseInt(edittext.getText().toString());
						Intent intent= new Intent(AlarmManagerActivity.this, AlarmReceiverActivity.class);
						PendingIntent pendingintent= PendingIntent.getActivity(AlarmManagerActivity.this,2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
						
						AlarmManager am= (AlarmManager)getSystemService(ALARM_SERVICE);
					am.set(AlarmManager.RTC_WAKEUP, (System.currentTimeMillis()+(seco*1000)), pendingintent);
					
					if(toast!=null)
					{
							toast.cancel();
					}
					toast= Toast.makeText(getApplicationContext(), "set in "+seco+"seconds", Toast.LENGTH_LONG);
					toast.show();
					}
					
						
						
						catch(NumberFormatException e)
					{
						if(toast!=null)
						{
								toast.cancel();
						}
						toast= Toast.makeText(getApplicationContext(), "ENTER NUMBER", Toast.LENGTH_LONG);
						toast.show();
						Log.i("AlarmManager","Not number");
					}
					
				}});
	        	
	        	
	buttonstart2.setOnClickListener(new OnClickListener() {
					
					
					public void onClick(View v) {
					
						
						try{
							seco=Integer.parseInt(edittext.getText().toString());
						Intent intent= new Intent(AlarmManagerActivity.this, RepeatingAlarmReceiverActivity.class);
						PendingIntent pendingintent= PendingIntent.getActivity(AlarmManagerActivity.this,3, intent, 0);
						
						AlarmManager am= (AlarmManager)getSystemService(ALARM_SERVICE);
					am.setRepeating(AlarmManager.RTC_WAKEUP, (System.currentTimeMillis()+(seco*1000)), 15*1000, pendingintent);
					
					if(toast!=null)
					{
							toast.cancel();
					}
					toast= Toast.makeText(getApplicationContext(), "set in "+seco+"seconds and Repeating every 15secs hence" , Toast.LENGTH_LONG);
					toast.show();
					}
					
						
						
						catch(NumberFormatException e)
					{
						if(toast!=null)
						{
								toast.cancel();
						}
						toast= Toast.makeText(getApplicationContext(), "ENTER NUMBER", Toast.LENGTH_LONG);
						toast.show();
						Log.i("AlarmManager","Not number");
						}
					}
				});
	        	
	        	
	        	
	buttonstop.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
		
			
		
				int sec=Integer.parseInt(edittext.getText().toString());
			Intent intent= new Intent(AlarmManagerActivity.this, RepeatingAlarmReceiverActivity.class);
			PendingIntent pendingintent= PendingIntent.getActivity(AlarmManagerActivity.this,3, intent, 0);
			
			AlarmManager am= (AlarmManager)getSystemService(ALARM_SERVICE);
			am.cancel(pendingintent);
		
		if(toast!=null)
		{
				toast.cancel();
		}
		toast= Toast.makeText(getApplicationContext(), "repeating alarm cancelled" , Toast.LENGTH_LONG);
		toast.show();
		
		
			
		}
	
	});
	
	
	 }



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}}