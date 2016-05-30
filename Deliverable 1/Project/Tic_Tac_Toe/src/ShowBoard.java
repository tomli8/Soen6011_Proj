import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowBoard {

	private JFrame frame;
	private JTextField txtTictactoeGame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final TicTacToe game = new TicTacToe();
		game.initializeBoard();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowBoard window = new ShowBoard(game);
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
	public ShowBoard(TicTacToe game) {
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final TicTacToe game) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtTictactoeGame = new JTextField();
		txtTictactoeGame.setForeground(Color.BLUE);
		txtTictactoeGame.setBackground(Color.CYAN);
		txtTictactoeGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtTictactoeGame.setText("Tic-Tac-Toe Game");
		frame.getContentPane().add(txtTictactoeGame, BorderLayout.NORTH);
		txtTictactoeGame.setColumns(10);
		
		Font f = new Font("Arial",Font.PLAIN,50); //define size of button text
	
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		// button to binary choose X or O
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Choose O");
		rdbtnNewRadioButton.setBackground(Color.ORANGE);
		buttonGroup.add(rdbtnNewRadioButton);
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setCurrentPlayerMark('O');
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Choose X");
		rdbtnNewRadioButton_1.setBackground(Color.ORANGE);
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_1.add(rdbtnNewRadioButton_1, BorderLayout.NORTH);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setCurrentPlayerMark('X');
			}
		});
		
		// button to control music
		JButton musicContrl = new JButton("music on/off");
		musicContrl.setForeground(Color.RED);
		musicContrl.setBackground(Color.LIGHT_GRAY);
		musicContrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//playMusic();
			}
		});
		panel_1.add(musicContrl, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3,3));
		
		
		// 9 buttons to depict the markers
		final JButton btnNewButton_3 = new JButton(" ");
		btnNewButton_3.setFont(f);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(0, 0)){				
					btnNewButton_3.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_3);
		
		final JButton btnNewButton_4 = new JButton(" ");
		btnNewButton_4.setFont(f);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(0, 1)){				
					btnNewButton_4.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}				
			}
		});
		panel_2.add(btnNewButton_4);
		
		final JButton btnNewButton_6 = new JButton(" ");
		btnNewButton_6.setFont(f);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(0, 2)){				
					btnNewButton_6.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_6);
		
		final JButton btnNewButton_5 = new JButton(" ");
		btnNewButton_5.setFont(f);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(1, 0)){				
					btnNewButton_5.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_5);
		
		final JButton btnNewButton_7 = new JButton(" ");
		btnNewButton_7.setFont(f);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(1, 1)){				
					btnNewButton_7.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_7);
		
		final JButton btnNewButton_8 = new JButton(" ");
		btnNewButton_8.setFont(f);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(1, 2)){				
					btnNewButton_8.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_8);
		
		final JButton btnNewButton_9 = new JButton(" ");
		btnNewButton_9.setFont(f);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(2, 0)){				
					btnNewButton_9.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_9);
		
		final JButton btnNewButton_10 = new JButton(" ");
		btnNewButton_10.setFont(f);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(2, 1)){				
					btnNewButton_10.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_10);
		
		final JButton btnNewButton_11 = new JButton(" ");
		btnNewButton_11.setFont(f);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game.placeMark(2, 2)){				
					btnNewButton_11.setText(Character.toString(game.getCurrentPlayerMark()));
					game.changePlayer();
				}			
			}
		});
		panel_2.add(btnNewButton_11);
		
		//button to exit
		JButton exitButton = new JButton("Exit");
		exitButton.setForeground(Color.BLUE);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//button to reset board
		JButton resetButton = new JButton("Reset");
		resetButton.setForeground(Color.BLUE);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.initializeBoard();
				//set button text
				btnNewButton_3.setText(" ");
				btnNewButton_4.setText(" ");				
				btnNewButton_5.setText(" ");
				btnNewButton_6.setText(" ");
				btnNewButton_7.setText(" ");
				btnNewButton_8.setText(" ");
				btnNewButton_9.setText(" ");
				btnNewButton_10.setText(" ");
				btnNewButton_11.setText(" ");
								
			}
		});
		panel.add(resetButton);
		panel.add(exitButton);
	}


}
