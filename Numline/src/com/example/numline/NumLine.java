package com.example.numline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class NumLine extends View {

	private String myn1;
	private String mysign;
	private String myn2;
	private int myln;
	Paint paint = new Paint();
	
	public NumLine(Context context, String n1, String sign, String n2, int ln){
		
		super(context);
		
		myn1 = n1;
		mysign = sign;
		myn2 = n2;
		myln = ln;
		
		
		paint.setColor(Color.BLACK);
		
	}
	
	
	@Override
	public void onDraw(Canvas canvas){
		
		//width corr x axis
		//height corr y axis
		
		RectF r = new RectF();
		
		int width = this.getWidth();
		int height = this.getHeight();
		
		int w_offset = width/20;
		int h_offset = height/10;
		
		int loop_limit;
		int num2 = Integer.parseInt(myn2);
		int num1 = Integer.parseInt(myn1);
		int flag = 2;
		int i; 
		
		
		int j = Integer.parseInt(myn1);
		String text;
		
		String Answer;
		
		Answer = myn1 + " " + mysign+ " " +  myn2 + " " + "=" + " ";
		
		
		
		//draw line
		paint.setStrokeWidth(2);
		canvas.drawLine((w_offset / 2), height/2, (width - w_offset / 2), height/2, paint);
		
		canvas.drawLine ((w_offset / 2), (height/2), (w_offset / 2 + 10), (height/2 -10), paint);
		canvas.drawLine ((w_offset / 2), (height/2), (w_offset / 2 + 10), (height/2 - 10), paint);
		canvas.drawLine ((w_offset / 2), (height/2), (w_offset / 2 + 10), (height/2 +10), paint);
		canvas.drawLine ((w_offset / 2), (height/2), (w_offset / 2 + 10), (height/2 + 10), paint);
		
		canvas.drawLine ((width - w_offset / 2), (height/2), (width - w_offset / 2 - 10), (height/2 -10), paint);
		canvas.drawLine ((width - w_offset / 2), (height/2), (width - w_offset / 2 - 10), (height/2 - 10), paint);
		canvas.drawLine ((width - w_offset / 2), (height/2), (width - w_offset / 2 - 10), (height/2 +10), paint);
		canvas.drawLine ((width - w_offset / 2), (height/2), (width - w_offset / 2 - 10), (height/2 + 10), paint);
		
		
		
		
		//place numbers
		paint.setTextSize(18);
		paint.setColor(Color.BLUE);
		
		for( i = 0; i < 10; i++){
			
			text = String.valueOf(j+i);
			
			canvas.drawText(text, width/2 + i*w_offset - 6, (height/2 + h_offset), paint);	
			
		
		}
		
		for(i = 1; i < 10; i++){
		
			text = String.valueOf(j-i);
			
			canvas.drawText(text, width/2 - i*w_offset - 6, (height/2 + h_offset), paint);	
			
			
			
		}
		
		
		//drawing the jumps
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3);
		
		
		
		
		if (mysign.equals("+")){
			flag = 1;
		}
		else if (mysign.equals("-")){
			flag = 0;
		}
		
	
		
				
		loop_limit = myln;
		for (i = 0; i < loop_limit; i++){
				
			
			if (flag == 1){ //go forward
				
				r.set(width/2 + (i)*w_offset, height/2-h_offset, width/2+(i+1)*w_offset, height/2+h_offset);
			}
			else if (flag == 0){
				r.set(width/2 + (0-(i+1))*w_offset, height/2-h_offset, width/2+(1-(i+1))*w_offset, height/2+h_offset);	
			}
			
			
			
			canvas.drawArc(r, 0, -180, false, paint);
			
			
		}
		if (flag == 0){
			canvas.drawLine ((width/2), (height/2 - 2*w_offset), (width / 2 - 2 * w_offset), (height/2 - 2 * w_offset), paint);	
			canvas.drawLine ((width / 2 - 2 * w_offset), (height/2 - 2 * w_offset), (width / 2 - 2 * w_offset + 20), (height/2 - 2 * w_offset - 20), paint);
			canvas.drawLine ((width / 2 - 2 * w_offset), (height/2 - 2 * w_offset), (width / 2 - 2 * w_offset + 20), (height/2 - 2 * w_offset + 20), paint);
		}
		else if (flag == 1){
			canvas.drawLine ((width/2), (height/2 - 2*w_offset), (width / 2 + 2 * w_offset), (height/2 - 2 * w_offset), paint);	
			canvas.drawLine ((width / 2 + 2 * w_offset), (height/2 - 2 * w_offset), (width / 2 + 2 * w_offset - 20), (height/2 - 2 * w_offset - 20), paint);
			canvas.drawLine ((width / 2 + 2 * w_offset), (height/2 - 2 * w_offset), (width / 2 + 2 * w_offset - 20), (height/2 - 2 * w_offset + 20), paint);
		}
		
		
		//display answer
		paint.setStrokeWidth(1);
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.BLUE);
		paint.setTextSize(30);
		if (flag == 1) {
			i = num2 + num1;
		}
		else {
			i = num1 - num2;
		}
		text = String.valueOf(i);
		Answer += text;
		
		if(num2 == myln){
				canvas.drawText(Answer, (width/2 - 1*w_offset), height/6, paint);
		}
		
	}
	
	
	
}
