package com.example.numline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	

	public final static String NUM_ONE = "com.example.myfirstapp.NUMONE";
	public final static String SIGN = "com.example.myfirstapp.SIGN";
	public final static String NUM_TWO = "com.example.myfirstapp.NUMTWO";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
    }
    
    public void onRestart() {
    	
        super.onRestart();
        EditText editstr1 = (EditText) findViewById(R.id.editText1);
        editstr1.setText("");

        EditText editstr2 = (EditText) findViewById(R.id.editText2);
        editstr2.setText("");

        EditText editstr3 = (EditText) findViewById(R.id.editText3);
        editstr3.setText("");

        
        setContentView(R.layout.activity_main);
        
                
    }
    
 
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void passAttr (View view){
    	
    	int num_two = 11;

    	EditText editstr1 = (EditText) findViewById(R.id.editText1); //1st int
		String s1 = editstr1.getText().toString();

		EditText editstr2 = (EditText) findViewById(R.id.editText2); //+ or -
		String s2 = editstr2.getText().toString();
    	
		EditText editstr3 = (EditText) findViewById(R.id.editText3); //2nd int
		String s3 = editstr3.getText().toString();
		
		if (isInteger1(s3)){
		
			num_two = Integer.parseInt(s3);
			
			if(!isInteger1(s1) || !ispn1(s2) || num_two > 9 ){
				onRestart();
				
			}
			
			
		}
		
		else{
			onRestart();
			
		}

		
		
    	
    	
    	Intent intent = new Intent(this, NumJumpActivity.class);
    	
		intent.putExtra(NUM_ONE, s1);

		intent.putExtra(SIGN, s2);

		intent.putExtra(NUM_TWO, s3);
	
		
		startActivity(intent);
		
    }
    
    public static boolean isInteger1(String s) {
	    try { 
	        Integer.parseInt(s); 

	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
    
    public static boolean ispn1(String s){
		
		if (s.equals("+") || s.equals("-")){
			return true;
		}
		else
			return false;
		
		
		
	}
    

}
