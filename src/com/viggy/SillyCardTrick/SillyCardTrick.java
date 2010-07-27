package com.viggy.SillyCardTrick;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class SillyCardTrick extends Activity {
    /** Called when the activity is first created. */
	public static int column;
    public GridView gridview;
    public ImageView imageview; 
    public int flag =0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        gridview = (GridView) findViewById(R.id.gridview); // to fill the grid
        gridview.setAdapter(new ImageAdapter(this)); // this will use ImageAdapter to display the images
        
        
        
        final Button button1 = (Button) findViewById(R.id.column1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              	shuffle(1);
            //    System.out.println("Button 1 presssed :" + flag);
                gridview.setAdapter(new ImageAdapter(getApplicationContext()));
            //    System.out.println("After gridview");
            	flag++;
            	if(flag==3){
            		result();
            	}
            }
        });
        final Button button2 = (Button) findViewById(R.id.column2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            		shuffle(2);
            	//	System.out.println("Button 2 presssed :" + flag);
            	gridview.setAdapter(new ImageAdapter(getApplicationContext()));
            	flag++;
            	if(flag==3){
            		result();
            		
            	}
            }
        });
        final Button button3 = (Button) findViewById(R.id.column3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shuffle(3);
          //      System.out.println("Button 3 presssed :" + flag);
                gridview.setAdapter(new ImageAdapter(getApplicationContext()));
            	flag++;
            	if(flag==3){
            		result();	
            	}
            }
        });
    }
	
	public static void shuffle(int column){
		int c1,c2,c0,index;
		c1 = c2 = c0 = index = 0;
		int[] temp = new int[21];
		//System.out.println("Entered shuffle");
		switch(column){
			case 1:{ c0 = 7; c1 = 14; c2 = 0; break;}
			case 2:{ c0 = 0; c1 = 7; c2 = 14; break;}
			case 3:{ c0 = 14; c1 = 0; c2 = 7; break;}
		}
		try{
		for(int j=0;j<21;j++){
			switch (j%3){
				case 0: { index = c0+(j/3); temp[index]=ImageAdapter.mThumbIds[j]; break;}
				case 1: { index = c1+(j/3); temp[index]=ImageAdapter.mThumbIds[j]; break;}
				case 2: { index = c2+(j/3); temp[index]=ImageAdapter.mThumbIds[j]; break;}
			}
			//System.out.println("card ::"+ImageAdapter.mThumbIds[j]);
			//System.out.println("temp ::"+temp[j]);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		for(int k=0;k<21;k++){
			//System.out.println("TEMP"+temp[k]);
			ImageAdapter.mThumbIds[k] = temp[k];
		}
		
	}
    private void result() {
    	setContentView(R.layout.result);
    	imageview = (ImageView) findViewById(R.id.imageview);
    	imageview.setImageResource(ImageAdapter.mThumbIds[10]);
	}
}