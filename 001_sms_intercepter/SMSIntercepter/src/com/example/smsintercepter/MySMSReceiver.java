package com.example.smsintercepter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * @author X.L.Zhang
 * 
 */
public class MySMSReceiver extends BroadcastReceiver {

	public String number;
	public String content;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
	 * android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		StringBuilder num = new StringBuilder();
		StringBuilder con = new StringBuilder();
		Log.v("smsre", "sms start");
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			Intent service = new Intent(context, SMSService.class);
			context.startService(service);
			Log.e("receive", "receive boot");

			Intent act = new Intent(context, MainActivity.class);
			act.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(act);
		}
		Log.e("receive", "on receive");
		Bundle bundle = intent.getExtras();
		Object messages[] = (Object[]) bundle.get("pdus");
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		for (int n = 0; n < messages.length; n++) {
			smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
			num.append(smsMessage[n].getDisplayOriginatingAddress());
			con.append(smsMessage[n].getDisplayMessageBody());
		}

		number = num.toString();
		content = con.toString();
		this.abortBroadcast();

		Intent i = new Intent(context, MySMS.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("number", number);
		i.putExtra("content", content);
		context.startActivity(i);
	}

}
