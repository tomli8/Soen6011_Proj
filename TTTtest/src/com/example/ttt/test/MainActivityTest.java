package com.example.ttt.test;

import static org.junit.Assert.*;

import org.junit.Test;

import android.app.Instrumentation;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ttt.MainActivity;
import com.example.ttt.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2 <MainActivity>{
	
    private Instrumentation mInstrumentation;  
    private MainActivity mATest; 
	private Button staticsBtn;
    private Button sBtn;
    private Button winNumBtn;
	private Button btn[][]= new Button[3][3];
	private TextView s1;
	private TextView s2;
	private TextView s3;
	private TextView s4;
	private View popview;
	private TextView status;
    
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override  
	protected void setUp() throws Exception{  
	    // TODO Auto-generated method stub  
	    super.setUp();    
	    mInstrumentation = getInstrumentation();   
	    mATest = getActivity();
	    
	    status = (TextView) mATest.findViewById(R.id.dialogue);
	    sBtn = (Button) mATest.findViewById(R.id.startNewGame);
	    staticsBtn = (Button) mATest.findViewById(R.id.bestOf3);
	    //first row buttons
        btn[0][2] = (Button) mATest.findViewById(R.id.one);
        btn[0][1] = (Button) mATest.findViewById(R.id.two);
        btn[0][0] = (Button) mATest.findViewById(R.id.three);

        //second row buttons
        btn[1][2] = (Button) mATest.findViewById(R.id.four);
        btn[1][1] = (Button) mATest.findViewById(R.id.five);
        btn[1][0] = (Button) mATest.findViewById(R.id.six);

        //third row buttons
        btn[2][2] = (Button) mATest.findViewById(R.id.seven);
        btn[2][1] = (Button) mATest.findViewById(R.id.eight);
        btn[2][0] = (Button) mATest.findViewById(R.id.nine);
        winNumBtn = (Button) mATest.findViewById(R.id.winNum);
        
	}  
	
	// test the function of game start and game playing(set mark on 9-unit board) 
	public void testGameProcess() throws Throwable {
		 mInstrumentation.runOnMainSync(new Runnable() {
	        @Override
	        public void run() {
	        	sBtn.performClick();// game start button
	        	assertTrue(btn[1][1].isEnabled());
	        	btn[1][1].performClick();
	        	assertFalse(btn[1][1].isEnabled());
	        	assertEquals(btn[1][1].getText(), "X");
	        	btn[1][0].performClick();
	        	assertEquals(btn[1][0].getText(), "O");
	        }
	    });
	}
	// test the function of show winning num 
	public void testshowWinNum() throws Throwable {
		 mInstrumentation.runOnMainSync(new Runnable() {
	        @Override
	        public void run() {
	        	winNumBtn.performClick();
	        	assertEquals(winNumBtn.getText(), "Player1:0"+"\n"+"Player2:0");
	        	winNumBtn.performClick();
	        	assertEquals(winNumBtn.getText(),"Show winning num");
	        	//stimulate a scenario that player1 wins in the first game
	        	sBtn.performClick();// a new game
	        	btn[0][0].performClick();
	        	btn[1][0].performClick();
	        	btn[0][1].performClick();
	        	btn[2][0].performClick();
	        	btn[0][2].performClick();
	        	winNumBtn.performClick();
	        	//assertEquals(winNumBtn.getText(), "Player1:1"+"\n"+"Player2:0");
	        }
	    });
	}
	
	 //test the function of show best of 3 games 
	public void testshowBestOfThree() throws Throwable {
		 mInstrumentation.runOnMainSync(new Runnable() {
	        @Override
	        public void run() {
	        	sBtn.performClick();// a new game
	        	//stimulate a scenario that player1 wins in the first game
	        	btn[0][0].performClick();
	        	btn[1][0].performClick();
	        	btn[0][1].performClick();
	        	btn[2][0].performClick();
	        	btn[0][2].performClick();
	        	assertEquals(status.getText(),"game over! winner is: Player1");
	        	sBtn.performClick();// a new game
	        	//stimulate a scenario that player2 wins in the second game
	        	btn[0][0].performClick();
	        	btn[1][0].performClick();
	        	btn[0][1].performClick();
	        	btn[1][1].performClick();
	        	btn[2][0].performClick();
	        	btn[1][2].performClick();
	        	assertEquals(status.getText(),"game over! winner is: Player2");
	        	
	        	sBtn.performClick();// a new game
	        	//stimulate a scenario that 2 players tie in the third game
	        	btn[0][0].performClick();
	        	btn[1][0].performClick();
	        	btn[0][1].performClick();
	        	btn[1][1].performClick();
	        	btn[2][0].performClick();
	        	btn[0][2].performClick();
	        	btn[1][2].performClick();
	        	btn[2][1].performClick();
	        	btn[2][2].performClick();
	        	assertEquals(status.getText(),"game over! Tie game");	        	
	        	staticsBtn.performClick();
	        }
	    });
	}
	
	// test the function of showing who's turn at present 
	public void testshowCurrentPlayer() throws Throwable {
		 mInstrumentation.runOnMainSync(new Runnable() {
	        @Override
	        public void run() {
	        	sBtn.performClick();// a new game
	        	assertEquals(status.getText(), "Player1 turn");
	        	btn[0][0].performClick();
	        	assertEquals(status.getText(), "Player2 turn");
	        	btn[0][1].performClick();
	        	assertEquals(status.getText(), "Player1 turn");
	        }
	    });
	}

}
