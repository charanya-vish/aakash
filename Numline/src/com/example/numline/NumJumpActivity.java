	package com.example.numline;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class NumJumpActivity extends Activity {
	
	
	private int i = 0;
	private int j = 0;
	private NumLine [] n = new NumLine [10];
	private CountDownTimer [] c = new CountDownTimer [10];
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		int num_two = 11;
		Intent intent = getIntent();
        String n1 = intent.getStringExtra(MainActivity.NUM_ONE);
        String s = intent.getStringExtra(MainActivity.SIGN);
        String n2 = intent.getStringExtra(MainActivity.NUM_TWO);
     
        if(isInteger(n2)){
        	num_two = Integer.parseInt(n2);
        
        }
        else{
        	finish();
        }
              
        
        if (isInteger(n1) && isInteger(n2) && ispn(s) && num_two < 10){
        	        
        
        
        	int ln = Integer.parseInt(n2);
        
            
        	for (i = 0, j = 0; i <= ln; i++){
        		n[i]= new NumLine(this, n1, s, n2, i);
        		c[j] = new CountDownTimer(i * 1000, 1000){
        			
        			
        			public void onTick (long l){;}
        			public void onFinish(){
        				setContentView(n[j]);
        				j++;
        				
        			}
        			
        		}.start();
        
        	}
		}
        else{
        	finish();
        }
	}

		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.num_jump, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
//courtesy: http://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 

	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static boolean ispn(String s){
		
		if (s.equals("+") || s.equals("-")){
			return true;
		}
		else
			return false;
		
		
		
	}
	

}
