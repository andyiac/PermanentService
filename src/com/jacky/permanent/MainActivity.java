package com.jacky.permanent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private Button startButton = null;
	private Button stopButton = null;
	private Intent intent = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //get instance
        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton); 
        intent = new Intent(MainActivity.this, MyService.class);
        
        //set start service button click listener
        startButton.setOnClickListener(new OnClickListener()
        {
			
			@Override
			public void onClick(View view)
			{
				startService(intent);
			}
		});
        
        //set stop service button click listener
        stopButton.setOnClickListener(new OnClickListener()
        {
			
			@Override
			public void onClick(View view)
			{
				stopService(intent);
			}
		});
    }
}
