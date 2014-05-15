package com.example.sdcard.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;
import android.provider.MediaStore.Files;
import android.util.Log;

public class SDFileService {
	private Context context;

	public SDFileService(Context context) {
		this.context = context;
	}

	public SDFileService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param fileName
	 *            文件名
	 * @param content
	 *            保存内容
	 * @return
	 * @throws IOException
	 */
	public boolean saveContentToSDCard(String fileName, String content) {
		boolean tag = false;

		/*---------------
		 * 文件输入输出流
		 * --------------
		 */
		FileOutputStream fileOutputStream = null;

		File file = new File(Environment.getExternalStorageDirectory(),
				fileName);

		/*---------------
		 * 判断SD卡是否可用
		 * --------------
		 */
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {

			try {
				fileOutputStream = new FileOutputStream(file);

				/*---------------
				 * 写入内容
				 * --------------
				 */
				fileOutputStream.write(content.getBytes());
				tag = true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			Log.i("MyTest", "--> SDCard not mounted!");
		}
		return tag;
	}

	public void readContentFromSDCard(String fileName) {
		String content = null;
		FileInputStream fileInputStream;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			File file = new File(Environment.getExternalStorageDirectory(),fileName);
			try {
				fileInputStream = new FileInputStream(file);
				byte[] data = new byte[1024];
				int len = 0;
				while ((len = fileInputStream.read(data)) != -1)
				{
					outputStream.write(data, 0, len); 
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			Log.i("MyTest", "--> SDCard not mounted!");
		}
		
		content = outputStream.toString();
		
		Log.i("MyTest", "SDCard content --> "+content);
	}
}
