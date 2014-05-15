package com.example.smsintercepter;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	private EditText ev1;	//�����ռ���
	private EditText ev2;	//��������
	private Button button; //���Ͱ�ť
	private ArrayList<String> textList = new ArrayList<String>();	//�������ݲ��
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ev1 = (EditText)findViewById(R.id.editText1);
        ev2 = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button1);
        
        button.setOnClickListener(new OnClickListener() {	//���ð�ť�¼������Ͷ��š�
			public void onClick(View v) {
				String number = ev1.getText().toString();
				String content = ev2.getText().toString();
				
				if(null != number && null != content)
				{
					SmsManager sms = SmsManager.getDefault();
					textList = sms.divideMessage(content);
					for(String text: textList)
					{
						sms.sendTextMessage(number, null, text, null, null);
					}
					Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
}
