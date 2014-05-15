package com.example.smsintercepter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author X.L.Zhang
 *
 */
public class MySMS extends Activity {
    
    private String number;
    private String content;
    private EditText et1;
    private EditText et2;
    private Intent intent;
    
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        
        intent  = getIntent();
        number = intent.getStringExtra("number");
        content = intent.getStringExtra("content");
        
        et1.setText(number);
        et2.setText(content);
        setContentView(R.layout.messagedisplay);
        
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
	 }
}
