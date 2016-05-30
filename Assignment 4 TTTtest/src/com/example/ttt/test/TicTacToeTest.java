package com.example.ttt.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;




import com.example.ttt.TicTacToe;

import junit.framework.TestCase;

public class TicTacToeTest extends TestCase {

	public TicTacToeTest(String name) {
		super(name);
	}
	
	@Test
	public void testTicTacToe()
		throws Exception {
		TicTacToe ttt = new TicTacToe();
		String[][] board = ttt.getBoard();
		// add additional test code here
		assertEquals(board[1][2], "-");
		assertEquals(board[0][0], "-");
		assertEquals(ttt.getCurrentPlayerMark(), "X");
	}
	
	@Test
	public void testisBoardFull()
		throws Exception {
		TicTacToe ttt = new TicTacToe();
		String[][] board = new String[3][3];
		
		assertEquals(ttt.isBoardFull(), false);
		
		 for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	            	board[i][j]= "X";
	            }
	     }
		 ttt.setBoard(board);
		 assertTrue(ttt.isBoardFull());
	}
	
	@Test
	public void testcheckForWin()
		throws Exception {
		TicTacToe ttt = new TicTacToe();
		
		ttt.placeMark(0, 0);
		ttt.placeMark(0, 1);
		ttt.placeMark(1, 1);
		assertFalse(ttt.checkForWin());
				
		ttt.placeMark(2, 1);
		assertTrue(ttt.checkForWin());
	}
	
	@Test
	public void testchangePlayer()
		throws Exception {
		TicTacToe ttt = new TicTacToe();
		assertEquals(ttt.getCurrentPlayerMark(), "X");
		ttt.changePlayer();
		assertEquals(ttt.getCurrentPlayerMark(), "O");
		ttt.changePlayer();
		assertEquals(ttt.getCurrentPlayerMark(), "X");
		ttt.changePlayer();
		assertEquals(ttt.getCurrentPlayerMark(), "O");

	}
	
	@Test
	public void testgetPlayer()
		throws Exception {
		TicTacToe ttt = new TicTacToe();
		assertEquals(ttt.getPlayer(), "Player1");
		ttt.changePlayer();
		assertEquals(ttt.getPlayer(), "Player2");
		ttt.changePlayer();
		assertEquals(ttt.getPlayer(), "Player1");


	}

}
