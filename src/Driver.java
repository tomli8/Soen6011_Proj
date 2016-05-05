import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe();
		game.initializeBoard();
		game.printBoard();
		while(true){
			System.out.println("give the position you want");
			Scanner sc = new Scanner(System.in);
			String position = sc.nextLine();
			String[] temp  =position.split(" ");
			if (game.placeMark(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]))){
				game.printBoard();
				if (game.checkForWin()){
					System.out.println("game over!");
					//break;
				}else{
					if(game.isBoardFull()){
						System.out.println("tie");
						//break;
					}
				}
				game.changePlayer();
				System.out.println("change player");
			}else{
				System.out.println("the position is invalid");
			}
		}
		
	}

}
