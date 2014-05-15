package com.example.smsintercepter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * @author X.L.Zhang
 *
 */
public class SMSService extends Service {

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

		Log.e("onCreate", "service on Create");
		Toast.makeText(getApplicationContext(), "service on Create", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
		Log.e("onDestroy", "service on Create");
		Toast.makeText(getApplicationContext(), "service on destroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		
		Log.e("onStart", "service on Create");
		Toast.makeText(getApplicationContext(), "service on Start", Toast.LENGTH_LONG).show();
		super.onStart(intent, startId);
	}

}
