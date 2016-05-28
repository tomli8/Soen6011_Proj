package com.example.ttt;

public class TicTacToe {

    public void setCurrentPlayerMark(String currentPlayerMark) {
		this.currentPlayerMark = currentPlayerMark;
	}


	private String[][] board; 
    private String currentPlayerMark;
			
    public String[][] getBoard() {
		return board;
	}


	public void setBoard(String[][] board) {
		this.board = board;
	}


	public String getCurrentPlayerMark() {
		return currentPlayerMark;
	}


	public TicTacToe() {
        board = new String[3][3];
        currentPlayerMark = "X";
        initializeBoard();
    }
	
	
    // Set/Reset the board back to all empty values.
    public void initializeBoard() {
		
        // Loop through rows
        for (int i = 0; i < 3; i++) {
			
            // Loop through columns
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
    }

    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;
		
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    isFull = false;
                }
            }
        }
		
        return isFull;
    }
	
	
    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
	
	
    // Loop through rows and see if any are winners.
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }
	
	
    // Loop through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }
	
	
    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
	
	
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(String c1, String c2, String c3) {
        return ((!c1.equals("-")) && (c1.equals(c2)) && (c2.equals(c3)));
    }
	
	
    // Change player marks back and forth.
    public void changePlayer() {
        if (currentPlayerMark.equals("X")) {
            currentPlayerMark = "O";
        }
        else {
            currentPlayerMark = "X";
        }
    }
	
	
    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {
		
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col].equals("-")) {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
		
        return false;
    }
    
    public String getPlayer(){
    	String result = " ";
    	if(currentPlayerMark.equals("X")){
    		result =  "Player1";    		
    	}
    	if(currentPlayerMark.equals("O")){
    		result =  "Player2";
    	}
    	return result;
    }
}