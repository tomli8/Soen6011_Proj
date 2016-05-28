package com.example.ttt;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.MotionEvent;

public class MainActivity extends Activity {
	
	private TicTacToe tttGame; 
	private Context mContext = null;
	//private String[][] board;
	private Button btn[][];
	//private String currentPlayerMark;
	private TextView status;
	private Button startBtn;
	private Button staticsBtn;
	private Button winNumBtn;
	private ArrayList<String>gameRecord = new ArrayList<String>(); 	
	private int playerOneWinningNum = 0;
	private int playerTwoWinningNum = 0;
	private TextView s1;
	private TextView s2;
	private TextView s3;
	private TextView s4;
	private boolean isClickedOnce=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWindow().setBackgroundDrawableResource(R.drawable.sample);
		mContext = this;
		initializeBoard();// set game board		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuItem item = menu.add("New Game");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		initializeBoard();       
		return true;
	}
	
	// the logic for start a new game corresponding to start new game button
	public void startNewGame(){       
        startBtn.setEnabled(true);
        //click listener for start new game button
        startBtn.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v)
            {	
            	initializeBoard();
            	for (int i = 0; i < 3; i++) {
	                 for (int j = 0; j < 3; j++) {
	                    btn[i][j].setEnabled(true);
	                 }
            	}
            }
        });
	}
	
    public void initializeBoard() { 
    	tttGame = new TicTacToe();
    	btn = new Button[3][3];   	
        
    	startBtn = (Button) findViewById(R.id.startNewGame);
        //bind show best of 3 button
        staticsBtn = (Button) findViewById(R.id.bestOf3);
        staticsBtn.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v){            	
            	showPopupWindow();
            }
        });
        
        //bind show winning number button
        winNumBtn = (Button) findViewById(R.id.winNum);
        winNumBtn.setOnClickListener(new Button.OnClickListener(){ 
            public void onClick(View v){ 
            	if(isClickedOnce){
            		winNumBtn.setText("Player1:"+ playerOneWinningNum+"\n"+"Player2:"+playerTwoWinningNum);
            		isClickedOnce = false;
            	}else{
            		winNumBtn.setText("Show winning num");
            		isClickedOnce = true;
            	}
            }
        });
        
        status = (TextView) findViewById(R.id.dialogue);
        
        //first row buttons
        btn[0][2] = (Button) findViewById(R.id.one);
        btn[0][1] = (Button) findViewById(R.id.two);
        btn[0][0] = (Button) findViewById(R.id.three);

        //second row buttons
        btn[1][2] = (Button) findViewById(R.id.four);
        btn[1][1] = (Button) findViewById(R.id.five);
        btn[1][0] = (Button) findViewById(R.id.six);

        //third row buttons
        btn[2][2] = (Button) findViewById(R.id.seven);
        btn[2][1] = (Button) findViewById(R.id.eight);
        btn[2][0] = (Button) findViewById(R.id.nine);
        
        tttGame.initializeBoard();
        
		 status.setText(tttGame.getPlayer()+" turn");;
        
        // add the click listeners for each button
        for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                  btn[i][j].setOnClickListener(new UnitClickListener(i, j));
                  btn[i][j].setEnabled(false);
                  if(!btn[i][j].isEnabled()) {
                       btn[i][j].setText(" ");
                  }
             }
        }
        startNewGame();
    }
	
    // class to manage 9 unit buttons click listener and operation
    public class UnitClickListener implements View.OnClickListener{
    	
    	private int x;
    	private int y;
    	
    	public UnitClickListener(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		String[][] board = tttGame.getBoard();
    		 if (btn[x][y].isEnabled() && board[x][y].equals("-")) {   			 
    			 status.setText(tttGame.getPlayer()+" turn");
                 btn[x][y].setEnabled(false);
                 btn[x][y].setText(tttGame.getCurrentPlayerMark());
                 board[x][y] = tttGame.getCurrentPlayerMark();
                 // check winning condition and record game result when game is over
                 if (!tttGame.checkForWin()) {
                	 if(tttGame.isBoardFull()){
                		 if(gameRecord.size()>=3){
                      		gameRecord.remove(0);
                      	}
                  		gameRecord.add("Tie game");   	
                		 status.setText("game over! Tie game");
                		 lockTable();
                	 }else{
	                	 tttGame.changePlayer();	                	 
	        			 status.setText(tttGame.getPlayer()+" turn");;
                	 }
                 }else{
                	 if(tttGame.getCurrentPlayerMark().equals("X")){
                		 playerOneWinningNum++;
                	 }
                	 if(tttGame.getCurrentPlayerMark().equals("O")){
                		 playerTwoWinningNum++;
                	 }
                 	 if(gameRecord.size()>=3){
                 		 gameRecord.remove(0);
                 	 }
             		 gameRecord.add(tttGame.getPlayer()+" win");   		

                	 status.setText("game over! winner is: "+ tttGame.getPlayer());
                	 lockTable();
                 }
            }
    			
    	}

     }
       
    // lock all 9 unit buttons
    public void lockTable(){
    	for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	btn[i][j].setEnabled(false);
            }
    	}
    }
    
    
 // show popup window for statics in last 3 games   
    @SuppressWarnings("deprecation")
	private void showPopupWindow(){
    	
    	LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.popup_window, (ViewGroup) findViewById(R.id.popup_element));
        PopupWindow popupWindow = new PopupWindow(contentView,
        		200, LayoutParams.MATCH_PARENT, true);
        popupWindow.setTouchable(true);

        popupWindow.setTouchInterceptor(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
            }
        });

        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.sample2));
        popupWindow.showAtLocation(contentView, Gravity.LEFT, 0, 0);
    	s1 = (TextView) contentView.findViewById(R.id.statics1);
    	s2 = (TextView) contentView.findViewById(R.id.statics2);
    	s3 = (TextView) contentView.findViewById(R.id.statics3);
    	s4 = (TextView) contentView.findViewById(R.id.statics4);
        BestOfThree(gameRecord);
        //popupWindow.showAsDropDown(v);

    }
    
    //logic for finding out the better in the last 3 games
    private void BestOfThree(ArrayList<String> gameRec){
    	int player1Score = 0;
    	int player2Score = 0;
    	
    	if(gameRec.size()>0){
	    	s1.setText(gameRec.get(0));
	    	for(String s: gameRec){
	    		String[] temp = s.split(" ");
	    		if(temp[0].equals("Player1")){
	    			player1Score++;
	    		}
	    		if(temp[0].equals("Player2")){
	    			player2Score++;
	    		}
	    	}
	    	if(player1Score>player2Score){
	    		s4.setText("Player1 is better in last 3 games");
	    	}else{
	    		if(player1Score<player2Score){
	    			s4.setText("Player2 is better in last 3 games");
	    		}else{
	    			s4.setText("2 player duel in last 3 games");
	    		}
	    	}
    	}
    	if(gameRec.size()>1){
	    	s2.setText(gameRec.get(1));
    	}
    	if(gameRec.size()>2){
	    	s3.setText(gameRec.get(2));
    	}	    	

    }
    
}
