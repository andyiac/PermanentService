package com.jacky.permanent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service
{
	AlarmManager mAlarmManager = null;
	PendingIntent mPendingIntent = null;
	
	@Override
	public void onCreate()
	{
		//start the service through alarm repeatly
	    Intent intent = new Intent(getApplicationContext(), MyService.class);        
		mAlarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		mPendingIntent = PendingIntent.getService(this, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
		long now = System.currentTimeMillis();
		mAlarmManager.setInexactRepeating(AlarmManager.RTC, now, 300, mPendingIntent);
		
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
		Toast.makeText(getApplicationContext(), "Callback Successed!", Toast.LENGTH_SHORT).show();
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}

	@Override
	public void onDestroy() 
	{
		
		super.onDestroy();
	}
}
