import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;


public class PlayBoard {

	private JFrame frame;
	private JTextField txtTictactoe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.initializeBoard();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayBoard window = new PlayBoard(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayBoard(TicTacToe game) {
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TicTacToe game) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		Font f = new Font("¡• È",Font.PLAIN,100); 
		//UIManager.put("Button.font",f); 
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.setFont(f);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.placeMark(0, 0)){				
					btnNewButton.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
					System.out.println("change player");
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		
		txtTictactoe = new JTextField();
		txtTictactoe.setBackground(Color.ORANGE);
		txtTictactoe.setForeground(Color.BLACK);
		txtTictactoe.setHorizontalAlignment(SwingConstants.CENTER);
		txtTictactoe.setText("Tic-Tac_Toe");
		GridBagConstraints gbc_txtTictactoe = new GridBagConstraints();
		gbc_txtTictactoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTictactoe.insets = new Insets(0, 0, 5, 5);
		gbc_txtTictactoe.gridx = 1;
		gbc_txtTictactoe.gridy = 0;
		frame.getContentPane().add(txtTictactoe, gbc_txtTictactoe);
		txtTictactoe.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setFont(f);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(0, 1)){				
					btnNewButton_2.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 1;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("-");
		btnNewButton_4.setFont(f);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(0, 2)){				
					btnNewButton_4.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 1;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setFont(f);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(1, 0)){				
					btnNewButton_1.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.setFont(f);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(1, 1)){				
					btnNewButton_3.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 2;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("-");
		btnNewButton_5.setFont(f);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(1, 2)){				
					btnNewButton_5.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 2;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("-");
		btnNewButton_6.setFont(f);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(2, 0)){				
					btnNewButton_6.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 3;
		frame.getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("-");
		btnNewButton_7.setFont(f);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(2, 1)){				
					btnNewButton_7.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 3;
		frame.getContentPane().add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("-");
		btnNewButton_8.setFont(f);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(2, 2)){				
					btnNewButton_8.setText(Character.toString(game.getCurrentPlayerMark()));
					if (game.checkForWin()){
						JOptionPane.showMessageDialog(null, "game over, winner is: "+game.getCurrentPlayerMark());
						System.out.println("game over!");
						System.exit(0);
					}else{
						if(game.isBoardFull()){
							System.out.println("tie");
							JOptionPane.showMessageDialog(null, "tie");
							System.exit(0);
						}
					}
					game.changePlayer();
				}else{
					System.out.println("invalid operation!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_8.gridx = 2;
		gbc_btnNewButton_8.gridy = 3;
		frame.getContentPane().add(btnNewButton_8, gbc_btnNewButton_8);
	}
}
