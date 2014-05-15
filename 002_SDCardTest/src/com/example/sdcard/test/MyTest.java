package com.example.sdcard.test;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

public class MyTest extends AndroidTestCase {
	
	public final static String TAG = "MyTest";
	
	public MyTest(){
		
	}
	
	public void saveFile()
	{
		Context context = getContext();
		SDFileService sdFileService = new SDFileService(context);
		boolean tag = sdFileService.saveContentToSDCard("test.txt", "Hello World!");
		Log.i(TAG,"Save File To SDCard!"+"-->"+tag);
	}
	
	public void readFile()
	{
		Context context = getContext();
		SDFileService sdFileService = new SDFileService(context);
		sdFileService.readContentFromSDCard("test.txt");
	}
}
